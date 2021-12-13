package view;

import controller.IOFile;
import java.util.*;
import model.SinhVien;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class main {

    public static int checkMaSinhVien(String ma, List<SinhVien> list) {
        for (SinhVien s : list) {
            if (s.getMa().equalsIgnoreCase(ma)) {
                return 1;
            }
        }
        return -1;
    }

    public static int valid(String maOld, String maNew, List<SinhVien> list) {
        if (maNew.equalsIgnoreCase(maOld)) {
            return 1;
        }
        for (SinhVien s : list) {
            if (s.getMa().equalsIgnoreCase(maNew) && !maNew.equalsIgnoreCase(maOld)) {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        List<SinhVien> list = new ArrayList<SinhVien>();
        String file = "src/controller/SinhVien.dat";
        list = IOFile.read(file);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa sinh viên");
            System.out.println("4. Thoát");
            System.out.print("Mời bạn chọn:");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 4) {
                System.exit(0);
            } else if (choice == 1) {
                int n = list.size();
                if (n == 0) {
                    System.out.println("Không có sinh viên nào!");
                } else {
                    for (SinhVien s : list) {
                        System.out.println(s.toString());
                    }
                }
            } else if (choice == 2) {
                System.out.print("Nhập mã sinh viên:");
                String ma = sc.nextLine().toUpperCase();
                while (checkMaSinhVien(ma, list) == 1) {
                    System.out.print("Mã sinh viên đã tồn tại.Nhập mã sinh viên mới:");
                    ma = sc.nextLine();
                }
                ma = ma.toUpperCase();
                System.out.print("Nhập tên sinh viên:");
                String ten = sc.nextLine();
                System.out.print("Nhập nhóm sinh viên:");
                int nhom = Integer.parseInt(sc.nextLine());
                list.add(new SinhVien(ma, ten, nhom));
                IOFile.write(file, list);
            } else if (choice == 3) {
                System.out.print("Nhập mã sinh viên cần sửa:");
                String maOld = sc.nextLine().toUpperCase();
                int found = 0;
                for (SinhVien s : list) {
                    if (s.getMa().equalsIgnoreCase(maOld)) {
                        System.out.print("Nhập mã sinh viên mới:");
                        String maNew = sc.nextLine().toUpperCase();
                        while (valid(maOld, maNew, list) == -1) {
                            System.out.print("Mã mới đã tồn tại. Nhập mã khác:");
                            maNew = sc.nextLine().toUpperCase();
                        }
                        found = 1;
                        System.out.print("Nhập tên mới sinh viên:");
                        String ten = sc.nextLine();
                        System.out.print("Nhập nhóm mới:");
                        int nhom = Integer.parseInt(sc.nextLine());
                        s.setMa(maNew);
                        s.setTen(ten);
                        s.setNhom(nhom);
                        IOFile.write(file, list);
                        break;
                    }
                }
                if (found == 0) {
                    System.out.println("Không có sinh viên này!");
                }
            } else {
                System.out.println("Không hợp lệ");
            }
        }

    }

}
