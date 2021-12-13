package model;

import java.io.Serializable;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class SinhVien implements Serializable {

    private String ma;
    private String ten;
    private int nhom;

    public SinhVien() {

    }

    public SinhVien(String ma, String ten, int nhom) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    public Object[] toObject() {
        return new Object[]{
            ma, ten, nhom
        };
    }

    public String toString() {
        return ma + "\t" + ten + "\t" + "\t" + nhom;
    }

}
