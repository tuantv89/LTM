package model;

import java.io.Serializable;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class Student implements Serializable {

    static final long serialVersionUID = 1L;
    private String maSV;
    private String hovaten;
    private String IP;
    private int group;

    public int getGroup() {
        return this.group;
    }

    public Student(String maSV, String hovaten, String IP, int group) {
        this.maSV = maSV;
        this.hovaten = hovaten;
        this.IP = IP;
        this.group = group;
    }

    public String getMaSV() {
        return this.maSV;
    }

    public String getHovaten() {
        return this.hovaten;
    }

    public String getIP() {
        return this.IP;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setNhom(int nhom) {
        this.group = nhom;
    }
}
