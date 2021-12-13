package model;

/**
 *
 * @author Thiều Văn Tuấn
 */
import java.io.Serializable;

public class Student implements Serializable {

    static final long serialVersionUID = 31L;
    private String maSV;
    private String hovaten;
    private String IP;
    private int group;

    public int getGroup() {
        return this.group;
    }

    public Student() {
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

    public void setGroup(int nhom) {
        this.group = nhom;
    }
}
