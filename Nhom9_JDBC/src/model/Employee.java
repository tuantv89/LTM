package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    public Employee(int empId, String empName, String empNo, Date hireDate, byte[] image, String job,
            float salary, int deptId, BigInteger mngId) {
        super();
        this.empId = empId;
        this.deptId = deptId;
        this.empName = empName;
        this.empNo = empNo;
        this.hireDate = hireDate;
        this.image = image;
        this.job = job;
        this.mngId = mngId;
        this.salary = salary;
    }

    private int empId;

    private int deptId;

    private String empName;

    private String empNo;

    private Date hireDate;

    private byte[] image;

    private String job;

    private java.math.BigInteger mngId;

    private float salary;

    public Employee() {
    }

    public int getEmpId() {
        return this.empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getDeptId() {
        return this.deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public java.math.BigInteger getMngId() {
        return this.mngId;
    }

    public void setMngId(java.math.BigInteger mngId) {
        this.mngId = mngId;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String str = "empId: " + this.empId + "\n" + "deptId: " + this.deptId + "\n" + "empName: " + this.empName + "\n"
                + "empNo: " + this.empNo + "\n" + "hireDate: " + this.hireDate.toString() + "\n" + "job: " + this.job + "\n" + "mngId:"
                + this.mngId + "\n" + "salary: " + this.salary;
        return str;
    }

    public Object[] toObjects() {
        return new Object[]{
            empId, empName, empNo, job, deptId
        };
    }

}
