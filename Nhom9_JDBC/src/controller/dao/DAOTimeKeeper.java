package controller.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import model.Timekeeper;

public class DAOTimeKeeper extends IDAO<Timekeeper> {

    public DAOTimeKeeper(Connection conn) {
        this.conn = conn;
        try {
            this.statement = this.conn.createStatement();

        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }

    public ArrayList<Integer> selectEmpId() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            String sql = "Select EMP_ID from employee";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int t = rs.getInt(1);
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Timekeeper[] selectAll() {
        Vector<Timekeeper> tk = new Vector<Timekeeper>();
        Timekeeper[] result;
        try {
            String sql = "Select * from TIMEKEEPER";
            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                Timekeeper e = new Timekeeper(
                        rs.getString(1),
                        rs.getDate(2),
                        BigInteger.valueOf(rs.getInt(4)),
                        rs.getString(3)
                );
                tk.add(e);
                i++;
            }
            result = new Timekeeper[i];
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
            return null;
        }
        return tk.toArray(result);
    }

    @Override
    public Timekeeper[] selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Timekeeper t) {
        String sql = "INSERT INTO TIMEKEEPER("
                + "Timekeeper_Id, Date_Time, In_Out, EMP_ID) VALUES(?,?,?,?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, String.valueOf(t.getTimekeeper_Id()));
            this.preStatement.setDate(2, new Date(t.getDate_Time().getTime()));
            this.preStatement.setString(3, String.valueOf(t.getIn_Out()));
            this.preStatement.setString(4, String.valueOf(t.getEmpId()));
            int rowCount = this.preStatement.executeUpdate();;
            return rowCount;
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
            return 0;
        }
    }

    @Override
    public int update(Timekeeper t) {
        String sql = "UPDATE TIMEKEEPER SET "
                + "Date_Time = ?, In_Out = ?, EMP_ID = ? WHERE Timekeeper_Id = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(4, String.valueOf(t.getTimekeeper_Id()));
            this.preStatement.setDate(1, new Date(t.getDate_Time().getTime()));
            this.preStatement.setString(2, String.valueOf(t.getIn_Out()));
            this.preStatement.setString(3, String.valueOf(t.getEmpId()));
            int rowCount = this.preStatement.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    public int detete(Timekeeper t) {
        String sql = "DELETE FROM TIMEKEEPER WHERE Timekeeper_Id = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, String.valueOf(t.getTimekeeper_Id()));
            int rowCount = this.preStatement.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
