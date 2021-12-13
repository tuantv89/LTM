package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.GiangVien;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class DAOGiangVien {

    Statement statement;
    PreparedStatement preStatement;
    Connection conn;
    ResultSet rs;

    public DAOGiangVien(Connection conn) {
        this.conn = conn;
        try {
            this.statement = this.conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int insert(GiangVien s) {
        int ans = 0;
        try {
            String sql = "INSERT INTO giangvien (hoten,sdt,bomon,khoa,diachi,hocham) VALUES (?,?,?,?,?,?)";
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, s.getHoten());
            this.preStatement.setString(2, s.getSdt());
            this.preStatement.setString(3, s.getBomon());
            this.preStatement.setString(4, s.getKhoa());
            this.preStatement.setString(5, s.getDiachi());
            this.preStatement.setString(6, s.getHocham());
            int res = this.preStatement.executeUpdate();
            return res;
        } catch (Exception e) {
            System.out.println(e);
        }
        return ans;
    }

    public List<GiangVien> getAll() {
        List<GiangVien> l = new ArrayList<GiangVien>();
        try {
            String sql = "SELECT * FROM giangvien";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                GiangVien gv = new GiangVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                l.add(gv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }

    public List<GiangVien> selectByName(String hoten) {
        List<GiangVien> l = new ArrayList<GiangVien>();
        try {
            String sql = "SELECT * FROM giangvien WHERE hoten='" + hoten + "'";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                GiangVien gv = new GiangVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                l.add(gv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }

    public void update(GiangVien gv) {
        String sql = "UPDATE giangvien SET hoten=?, sdt=?, bomon=?, khoa=?, diachi=?, hocham=? WHERE id = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, gv.getHoten());
            this.preStatement.setString(2, gv.getSdt());
            this.preStatement.setString(3, gv.getBomon());
            this.preStatement.setString(4, gv.getKhoa());
            this.preStatement.setString(5, gv.getDiachi());
            this.preStatement.setString(6, gv.getHocham());
            this.preStatement.setInt(7, gv.getId());
            this.preStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM giangvien WHERE id=" + id;
        statement.execute(sql);
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (Exception e) {
        }
    }

}
