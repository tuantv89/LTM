package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.UserModel;

public class LoginController {
    private Socket socket = null;
    private String host = "localhost";
    private int port = 6000;
    
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
        
    public LoginController() {
        try {
            socket = new Socket(host, port);
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception e) {
            e.printStackTrace();
        }     
    }
    
    public int checkUser(UserModel user) {
        try {
            oos.writeObject("login");
            oos.flush();
            oos.writeObject(user);
            oos.flush();
            
            return (int) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return 0;
    }
    
    public boolean registerUser(UserModel user) { 
        try {
            oos.writeObject("register");
            oos.flush();
            oos.writeObject(user);
            oos.flush();
            
            
            return (boolean) ois.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public void close() {
        try {
            if (socket != null)
                socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
