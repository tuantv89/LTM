package rmiClient_class;

import controller.IRegistration;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GiangVien;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class client {

    public static void main(String[] args) {

        IRegistration i = null;
        Scanner sc = new Scanner(System.in);
        try {
            i = (IRegistration) LocateRegistry.getRegistry("localhost", 1099).lookup("Server");
            while (true) {
                System.out.println("0. Thoat chuong trinh");
                System.out.println("1. Them giang vien");
                System.out.println("2. Sua thong tin giang vien");
                System.out.println("3. Xoa giang vien");
                System.out.println("4. Liet ke tat ca giang vien");
                System.out.println("5. Liet ke thong tin cua mot giang vien cu the");
                System.out.print("Nhap lua chon(0,1,2,3,4,5):");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 0) {
                    System.exit(0);
                }
                if (choice == 1) {
                    System.out.print("Nhap ho ten giang vien:");
                    String hoten = sc.nextLine();
                    System.out.print("Nhap sdt giang vien:");
                    String sdt = sc.nextLine();
                    System.out.print("Nhap bo mon cua giang vien:");
                    String bomon = sc.nextLine();
                    System.out.print("Nhap khoa cua giang vien:");
                    String khoa = sc.nextLine();
                    System.out.print("Nhap dia chi cua giang vien:");
                    String diachi = sc.nextLine();
                    System.out.print("Nhap hoc ham cua giang vien:(1: Thac sy, 2: Tien sy, 3: Pho giao su, 4: giao su, nhap 1 hoac 2 hoac 3 hoac 4):");
                    int c = Integer.parseInt(sc.nextLine());
                    String hocham = "Thac sy";
                    if (c == 1) {
                        hocham = "Thac sy";
                    }
                    if (c == 2) {
                        hocham = "Tien sy";
                    }
                    if (c == 3) {
                        hocham = "Pho giao su";
                    }
                    if (c == 4) {
                        hocham = "Giao su";
                    }
                    i.insert(new GiangVien(0, hoten, sdt, bomon, khoa, diachi, hocham));
                }
                if (choice == 2) {
                    System.out.print("Nhap ma giang vien can sua:");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ho ten moi cua giang vien:");
                    String hoten = sc.nextLine();
                    System.out.print("Nhap sdt moi cua giang vien:");
                    String sdt = sc.nextLine();
                    System.out.print("Nhap bo mon moi cua cua giang vien:");
                    String bomon = sc.nextLine();
                    System.out.print("Nhap khoa moi cua giang vien:");
                    String khoa = sc.nextLine();
                    System.out.print("Nhap dia chi moi cua giang vien:");
                    String diachi = sc.nextLine();
                    System.out.print("Nhap hoc ham moi cua giang vien:(1: Thac sy, 2: Tien sy, 3: Pho giao su, 4: giao su, nhap 1 hoac 2 hoac 3 hoac 4):");
                    int c = Integer.parseInt(sc.nextLine());
                    String hocham = "Thac sy";
                    if (c == 1) {
                        hocham = "Thac sy";
                    }
                    if (c == 2) {
                        hocham = "Tien sy";
                    }
                    if (c == 3) {
                        hocham = "Pho giao su";
                    }
                    if (c == 4) {
                        hocham = "Giao su";
                    }
                    i.update(new GiangVien(id, hoten, sdt, bomon, khoa, diachi, hocham));
                }
                if (choice == 3) {
                    System.out.print("Nhap ma giang vien can xoa:");
                    int id = Integer.parseInt(sc.nextLine());
                    i.delete(id);
                }
                if (choice == 4) {
                    List<GiangVien> l = i.getAll();
                    for (GiangVien gv : l) {
                        System.out.println(gv.getId() + "\t" + gv.getHoten() + "\t" + gv.getSdt() + "\t" + gv.getBomon() + "\t" + gv.getKhoa() + "\t" + gv.getDiachi() + "\t" + gv.getHocham());
                    }
                }
                if (choice == 5) {
                    System.out.print("Nhap ten giang vien can xem thong tin chi tiet(Nhap day du ho ten):");
                    String hoten = sc.nextLine();
                    List<GiangVien> l = i.selectByName(hoten);
                    for (GiangVien gv : l) {
                        System.out.println(gv.getId() + "\t" + gv.getHoten() + "\t" + gv.getSdt() + "\t" + gv.getBomon() + "\t" + gv.getKhoa() + "\t" + gv.getDiachi() + "\t" + gv.getHocham());
                    }
                }
            }
        } catch (RemoteException ex) {
            System.out.println(ex);
        } catch (NotBoundException ex) {
            System.out.println(ex);
        }
    }
}
