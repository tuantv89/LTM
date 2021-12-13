package controller;

import controller.dao.DAODepartment;
import controller.utils.ConnectionUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Department;
import view.DepartmentView;

public class DepartmentControl {

    private DepartmentView view;
    private DAODepartment dao;
    private ArrayList<Department> list;

    public DepartmentControl(DepartmentView view) {
        try {
            dao = new DAODepartment(ConnectionUtils.getMyConnection());
            list = new ArrayList<Department>();
            this.view = view;
        } catch (Exception e) {
            System.out.println(e);
            this.dao.closeConnection();
            System.exit(0);
        }
        getAll();
        view.addBtnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department d = view.getData();
                dao.insert(d);
                list.add(d);
                view.addRow(d);
            }
        });
        view.addBtnModifyListener(new ActionListener() {     //sửa tất cả trừ id
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = view.getSelectedRow();
                    Department d = list.get(r);
                    Department dd = view.getData();
                    // d.setDeptId(dd.getDeptId());
                    d.setDeptName(dd.getDeptName());
                    d.setDeptNo(dd.getDeptNo());
                    d.setLocation(dd.getLocation());
                    dao.update(d);
                    getAll();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        view.addBtnDeleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = view.getSelectedRow();
                    System.out.println(r);
                    Department d = list.get(r);
                    dao.delete(d);
                    list.remove(r);
                    getAll();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    public void getAll() {
        list.clear();
        list.addAll(Arrays.asList(dao.selectAll()));
        view.showtbl(list);
    }
}
