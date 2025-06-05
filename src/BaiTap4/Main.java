package BaiTap4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine();

        SinhVien[] ds = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên " + (i + 1) + ":");
            System.out.print("Tên: ");
            String hoTen = sc.nextLine();

            System.out.print("Mã SV: ");
            int maSV = sc.nextInt();

            System.out.print("Điểm Toán: ");
            float diemToan = sc.nextFloat();

            System.out.print("Điểm Lý: ");
            float diemLy = sc.nextFloat();

            System.out.print("Điểm Hóa: ");
            float diemHoa = sc.nextFloat();

            sc.nextLine();
            ds[i] = new SinhVien(hoTen, maSV, diemToan, diemLy, diemHoa);
        }

        System.out.println("\nKết quả:");
        for (SinhVien sv : ds) {
            System.out.println(sv.ketQua());
        }
    }
}
