package model;

import java.io.Serializable;

public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    public Department(int deptId, String deptName, String deptNo, String location) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptNo = deptNo;
        this.location = location;
    }

    private int deptId;

    private String deptName;

    private String deptNo;

    private String location;

    public Department() {
    }

    public int getDeptId() {
        return this.deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object[] toObjects() {
        return new Object[]{
            deptId, deptName, deptNo, location
        };
    }

}
