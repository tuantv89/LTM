package Client_Class;

import control.IRegistration;
import model.Student;
import java.net.Inet4Address;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import model.Answer;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class Client {

    public static void main(String[] args) {
        IRegistration i = null;
        Scanner sc = new Scanner(System.in);
        try {
            i = (IRegistration) LocateRegistry.getRegistry("localhost", 1099).lookup("Server");
            String ipClient = Inet4Address.getLocalHost().getHostAddress();
            String maSV = "";
            System.out.print("Nhap ma sinh vien:");
            maSV = sc.nextLine();
            String hoten = "";
            System.out.print("Nhap ho va ten:");
            hoten = sc.nextLine();
            int nhom = 0;
            System.out.print("Nhap nhom:");
            nhom = Integer.parseInt(sc.nextLine());
            Student st = new Student(maSV, hoten, ipClient, nhom);
            Student s = i.register(st);
            System.out.println("Response from server:");
            System.out.println("Ma sinh vien:" + s.getMaSV());
            System.out.println("Ho va ten:" + s.getHovaten());
            System.out.println("Dia chi IP:" + s.getIP());
            System.out.println("Nhom:" + s.getGroup());
            Answer answer = new Answer(s);
            Answer ans = i.answer(answer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
