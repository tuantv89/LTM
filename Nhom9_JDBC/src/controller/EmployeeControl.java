package controller;

import controller.dao.DAOEmployee;
import controller.utils.ConnectionUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Employee;
import view.EmployeeView;

public class EmployeeControl {

    private EmployeeView view;
    private ArrayList<Employee> list;
    private DAOEmployee dao;

    public EmployeeControl(EmployeeView employeeView) {
        try {
            this.view = employeeView;
            dao = new DAOEmployee(ConnectionUtils.getMyConnection());
            list = new ArrayList<Employee>();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            dao.closeConnection();
        }
        getAll();
        loadDeptId();
        view.addBtnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee em = view.getData();
                dao.insert(em);
                list.add(em);
                view.addRow(em);
                //getAll();
            }
        });
        view.addBtnModifyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                try {
                    int r = view.getSelectedRow();
                    Employee e = list.get(r);
                    Employee ee = view.getData();
                    e.setEmpNo(ee.getEmpNo());
                    e.setEmpName(ee.getEmpName());
                    e.setJob(ee.getJob());
                    e.setDeptId(ee.getDeptId());
                    dao.update(e);
                    getAll();
                } catch (Exception exc) {
                    System.out.println(exc);
                }
            }
        });
        view.addBtnDeleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = view.getSelectedRow();
                    dao.delete(list.get(r));
                    list.remove(r);
                    getAll();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    public void loadDeptId() {
        ArrayList<Integer> list = dao.selectDeptId();
        view.loadItem(list);
    }

    public void getAll() {
        list.clear();
        list.addAll(Arrays.asList(dao.selectAll()));
        view.setDefault(list);
    }

}
