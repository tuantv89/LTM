package rmiServer_class;

import controller.Registration;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class server {

    public static void main(String[] args) throws RemoteException, MalformedURLException, UnknownHostException, SQLException, ClassNotFoundException {
        Registration reg = new Registration();
    }

}
