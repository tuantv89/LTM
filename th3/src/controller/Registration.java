package controller;

import controller.dao.DAOGiangVien;
import controller.utils.ConnectionUtils;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.GiangVien;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class Registration extends UnicastRemoteObject implements IRegistration {

    private DAOGiangVien dao;

    public Registration() throws RemoteException, MalformedURLException, UnknownHostException, SQLException, ClassNotFoundException {
        dao = new DAOGiangVien(ConnectionUtils.getMyConnection());
        Registry reg = LocateRegistry.createRegistry(1099);
        System.out.println("IP " + InetAddress.getLocalHost().getHostAddress());
        reg.rebind("Server", this);
    }

    @Override
    public synchronized void insert(GiangVien gv) throws RemoteException {
        try {
            int ans = dao.insert(gv);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public synchronized List<GiangVien> getAll() throws RemoteException {
        List<GiangVien> l = dao.getAll();
        return l;
    }

    @Override
    public synchronized List<GiangVien> selectByName(String hoten) throws RemoteException {
        List<GiangVien> l = dao.selectByName(hoten);
        return l;
    }

    @Override
    public synchronized void delete(int id) throws RemoteException {
        try {
            dao.delete(id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public synchronized void update(GiangVien gv) throws RemoteException {
        dao.update(gv);
    }

}
