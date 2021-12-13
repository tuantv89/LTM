package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Timekeeper implements Serializable {

    private static final long serialVersionUID = 1L;

    public Timekeeper(String timekeeper_Id, Date date_Time, BigInteger empId, String in_Out) {
        super();
        this.timekeeper_Id = timekeeper_Id;
        this.date_Time = date_Time;
        this.empId = empId;
        this.in_Out = in_Out;
    }

    private String timekeeper_Id;

    private Date date_Time;

    private java.math.BigInteger empId;

    private String in_Out;

    public Timekeeper() {
    }

    public String getTimekeeper_Id() {
        return this.timekeeper_Id;
    }

    public void setTimekeeper_Id(String timekeeper_Id) {
        this.timekeeper_Id = timekeeper_Id;
    }

    public Date getDate_Time() {
        return this.date_Time;
    }

    public void setDate_Time(Date date_Time) {
        this.date_Time = date_Time;
    }

    public java.math.BigInteger getEmpId() {
        return this.empId;
    }

    public void setEmpId(java.math.BigInteger empId) {
        this.empId = empId;
    }

    public String getIn_Out() {
        return this.in_Out;
    }

    public void setIn_Out(String in_Out) {
        this.in_Out = in_Out;
    }

}
