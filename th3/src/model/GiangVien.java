package model;

import java.io.Serializable;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class GiangVien implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String hoten;
    private String sdt;
    private String bomon;
    private String khoa;
    private String diachi;
    private String hocham;

    public GiangVien() {
    }

    public GiangVien(int id, String hoten, String sdt, String bomon, String khoa, String diachi, String hocham) {
        this.hoten = hoten;
        this.id = id;
        this.sdt = sdt;
        this.bomon = bomon;
        this.khoa = khoa;
        this.diachi = diachi;
        this.hocham = hocham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getBomon() {
        return bomon;
    }

    public void setBomon(String bomon) {
        this.bomon = bomon;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHocham() {
        return hocham;
    }

    public void setHocham(String hocham) {
        this.hocham = hocham;
    }

}
