package controller.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import model.Employee;

public class DAOEmployee extends IDAO<Employee> {

    public DAOEmployee(Connection conn) {
        this.conn = conn;
        try {
            this.statement = this.conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Integer> selectDeptId() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            String sql = "Select DEPT_ID from department";
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
    public Employee[] selectAll() {
        Vector<Employee> ee = new Vector<Employee>();
        Employee[] result;
        try {
            String sql = "Select * from EMPLOYEE";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getBytes(5),
                        rs.getString(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        BigInteger.valueOf(rs.getInt(9)));
                ee.add(e);

                i++;
            }
            result = new Employee[i];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return ee.toArray(result);
    }

    @Override
    public Employee[] selectByName(String name) {
        Vector<Employee> ee = new Vector<Employee>();
        Employee[] result;
        try {
            String sql = "Select * from EMPLOYEE where Emp_Name='" + name + "'";

            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getBytes(5),
                        rs.getString(6),
                        rs.getFloat(7),
                        rs.getInt(8),
                        BigInteger.valueOf(rs.getInt(9)));
                ee.add(e);

                i++;
            }
            result = new Employee[i];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return ee.toArray(result);
    }

    @Override
    public int insert(Employee e) {
        String sql = "INSERT INTO EMPLOYEE (EMP_ID,"
                + "EMP_NAME,"
                + "EMP_NO,"
                + "HIRE_DATE,"
                + "IMAGE,"
                + "JOB,"
                + "SALARY,"
                + "DEPT_ID,"
                + "MNG_ID)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, e.getEmpId());
            this.preStatement.setString(2, e.getEmpName());
            this.preStatement.setString(3, e.getEmpNo());
            this.preStatement.setDate(4, new java.sql.Date(e.getHireDate().getTime()));
            this.preStatement.setBytes(5, e.getImage());
            this.preStatement.setString(6, e.getJob());
            this.preStatement.setFloat(7, e.getSalary());
            this.preStatement.setInt(8, e.getDeptId());
            this.preStatement.setLong(9, e.getMngId().longValue());
            int rowCount = this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;

        }

    }

    @Override
    public int update(Employee e) {
        String sql = "UPDATE EMPLOYEE set "
                + "EMP_NAME = ?,"
                + "EMP_NO = ?,"
                + "HIRE_DATE = ?,"
                + "IMAGE= ?,"
                + "JOB= ?,"
                + "SALARY = ?,"
                + "DEPT_ID = ?,"
                + "MNG_ID= ? "
                + "Where EMP_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, e.getEmpName());
            this.preStatement.setString(2, e.getEmpNo());
            this.preStatement.setDate(3, new java.sql.Date(e.getHireDate().getTime()));
            this.preStatement.setBytes(4, e.getImage());
            this.preStatement.setString(5, e.getJob());
            this.preStatement.setFloat(6, e.getSalary());
            this.preStatement.setInt(7, e.getDeptId());
            this.preStatement.setLong(8, e.getMngId().longValue());
            this.preStatement.setInt(9, e.getEmpId());

            int rowCount = this.preStatement.executeUpdate();

            return rowCount;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return 0;

        }
    }

    public void delete(Employee e) throws SQLException {
        String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = " + e.getEmpId();
        statement.execute(sql);
    }

    @Override
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
