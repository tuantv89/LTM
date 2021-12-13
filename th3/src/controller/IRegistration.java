package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.GiangVien;

/**
 *
 * @author Thiều Văn Tuấn
 */
public interface IRegistration extends Remote {

    public void insert(GiangVien s) throws RemoteException;

    public List<GiangVien> getAll() throws RemoteException;

    public List<GiangVien> selectByName(String hoten) throws RemoteException;

    public void delete(int id) throws RemoteException;

    public void update(GiangVien gv) throws RemoteException;
}
