package controller;

import controller.dao.DAOTimeKeeper;
import controller.utils.ConnectionUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Timekeeper;
import view.TimeKeeperView;

public class TimeKeeperControl {

    private TimeKeeperView view;
    private DAOTimeKeeper dao;
    private ArrayList<Timekeeper> list;

    public TimeKeeperControl(TimeKeeperView view) {
        this.view = view;
        this.list = new ArrayList<Timekeeper>();
        try {
            dao = new DAOTimeKeeper(ConnectionUtils.getMyConnection());
        } catch (Exception e) {
            System.out.println(e);
        }
        getAll();
        loadEmpId();
        view.addBtnAdd(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timekeeper tk = new Timekeeper();
                try {
                    tk = view.getData();
                } catch (ParseException ex) {
                    view.showMessage("Dữ liệu nhập không hợp lệ vui lòng thử lại.");
                    System.out.println(ex);
                    return;
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                int i = dao.insert(tk);
                if (i == 0) {
                    view.showMessage("Thêm thất bại, vui lòng thử lại.");
                } else {
                    //getAll();
                    list.add(tk);
                    view.insertRow(tk);
                    view.showMessage("Thêm thành công.");
                }
            }
        });
        view.addBtnDelete(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = view.getSelectedRow();
                    dao.detete(list.get(r));
                    list.remove(r);
                    getAll();
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });
        view.addBtnModify(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = view.getSelectedRow();
                    Timekeeper t = list.get(r);
                    Timekeeper tt = view.getData();
                    t.setEmpId(tt.getEmpId());
                    t.setDate_Time(tt.getDate_Time());
                    t.setIn_Out(tt.getIn_Out());
                    dao.update(t);
                    getAll();
                    view.showMessage("Sửa thành công");
                } catch (Exception ex) {
                    view.showMessage("Thất bại!");
                }
            }
        });
    }

    public void loadEmpId() {
        ArrayList<Integer> list = dao.selectEmpId();
        view.loadItem(list);
    }

    public void getAll() {
        list.clear();
        list.addAll(Arrays.asList(dao.selectAll()));
        view.showList(list);
    }

}
