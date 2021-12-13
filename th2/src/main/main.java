package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import model.*;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class main {

    Socket mySocket = null;
    DataOutputStream out = null;
    DataInputStream in = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    public void sendAnswer(Answer ans) {
        try {
            oos.writeObject(ans);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void sendMaSV(String masv) {
        try {
            out.writeUTF(masv);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void sendStudent(Student s) {
        try {
            oos.writeObject(s);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void sendHoVaTen(String hovaten) {
        try {
            out.writeUTF(hovaten);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void sendNhom(int nhom) {
        try {
            out.writeInt(nhom);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void sendObjectOK(ObjectOK objOK) {
        try {
            oos.writeObject(objOK);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public IntOK receiveIntOK() {
        if (mySocket != null && ois != null) {
            try {
                IntOK obj = (IntOK) ois.readObject();
                return obj;
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public Answer receiveAnswer() {
        if (mySocket != null && ois != null) {
            try {
                Answer ans = (Answer) ois.readObject();
                return ans;
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public ObjectOK receiveObjectOK() {
        if (mySocket != null && ois != null) {
            try {
                ObjectOK obj = (ObjectOK) ois.readObject();
                return obj;
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public StringOK receiveStringOK() {
        if (mySocket != null && ois != null) {
            try {
                StringOK obj = (StringOK) ois.readObject();
                return obj;
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public String receiveString() {
        if (mySocket != null && in != null) {
            try {
                String response = in.readUTF();
                return response;
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public void connect() {
        try {
            mySocket = new Socket("14.226.23.116", 11310);
            oos = new ObjectOutputStream(mySocket.getOutputStream());
            ois = new ObjectInputStream(mySocket.getInputStream());
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void terminate() {
        if (mySocket != null && out != null && in != null) {
            try {
                out.close();
                in.close();
                oos.close();
                ois.close();
                mySocket.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        try {
            main client = new main();
            client.connect();
            String masv = "B18DCAT217";
            String hovaten = "Thieu Van Tuan";
            int group = 9;
            String IP = InetAddress.getLocalHost().getHostAddress();
            Student student = new Student(masv, hovaten, IP, group);
            String receive = client.receiveString();
//            System.out.println(receive);
            client.sendStudent(student);
            ObjectOK objOK = client.receiveObjectOK();
//            System.out.println(objOK.getValue());
            client.sendMaSV(masv);
            StringOK stringOK = client.receiveStringOK();
//            System.out.println(strOK.getValue());
            client.sendHoVaTen(hovaten);
            stringOK = client.receiveStringOK();
//            System.out.println(strOK.getValue());
            client.sendNhom(group);
            IntOK intOK = client.receiveIntOK();
//            System.out.println(intOK.getValue());
            Answer ans = client.receiveAnswer();
//            System.out.println(ans);
            client.sendObjectOK(objOK);
            client.terminate();
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }
    }

}
