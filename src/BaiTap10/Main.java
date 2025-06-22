package BaiTap10;


import BaiTap10.NhanVien.NhanVien;
import BaiTap10.NhanVien.NhanVienSanXuat;
import BaiTap10.NhanVien.NhanVienVanPhong;
import BaiTap10.PhanSo.PhanSo;
import BaiTap10.PhuongTienGiaoThong.Oto;
import BaiTap10.VanDongVien.VanDongVien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            menu();
            System.out.print("Chọn: ");
            chon = sc.nextInt();

            switch (chon) {
                case 1 -> Bai1(sc);
                case 2 -> Bai2(sc);
                case 3 -> Bai3(sc);
                case 4 -> Bai4(sc);
                case 0 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Vui lòng chọn từ 0 đến 4.");
            }
        } while (chon != 0);

    }


    public static void Bai1(Scanner sc) {
        PhanSo a = new PhanSo();
        PhanSo b = new PhanSo();

        System.out.println("Nhập phân số thứ nhất:");
        a.nhap();

        System.out.println("Nhập phân số thứ hai:");
        b.nhap();

        System.out.println("Tổng: " + a.cong(b).xuat());
        System.out.println("Hiệu: " + a.tru(b).xuat());
        System.out.println("Tích: " + a.nhan(b).xuat());
        System.out.println("Thương: " + a.chia(b).xuat());
    }


    public static void Bai2(Scanner sc) {
        VanDongVien vdv1 = new VanDongVien();
        VanDongVien vdv2 = new VanDongVien();

        System.out.println("Nhập VDV 1:"); vdv1.nhap();
        System.out.println("Nhập VDV 2:"); vdv2.nhap();

        vdv1.xuat();
        vdv2.xuat();

        vdv1.soSanh(vdv2);
    }

    public static void Bai3(Scanner sc) {
        System.out.println("1. Nhân Viên Sản Xuất");
        System.out.println("2. Nhân Viên Văn Phòng");
        System.out.print("Chọn: ");
        int loai = sc.nextInt();

        NhanVien nv = (loai == 1) ? new NhanVienSanXuat() : new NhanVienVanPhong();

        nv.nhap();
        nv.tinhLuong();
        nv.xuat();
    }

    public static void Bai4(Scanner sc) {
        System.out.print("Nhập số lượng ô tô: ");
        int n = sc.nextInt();
        Oto[] ds = new Oto[n];
        boolean[] daIn = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nÔ tô thứ " + (i+1) + ":");
            ds[i] = new Oto();
            ds[i].nhap();
        }

        for (Oto o : ds) o.xuat();

        System.out.println("\nCác ô tô có vận tốc giống nhau:");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (daIn[i]) continue;
            boolean coTrung = false;
            for (int j = i + 1; j < n; j++) {
                if (ds[i].getVanTocToiDa() == ds[j].getVanTocToiDa()) {
                    if (!coTrung) {
                        ds[i].xuat();
                        daIn[i] = true;
                        coTrung = true;
                    }
                    ds[j].xuat();
                    daIn[j] = true;
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không có ô tô nào có vận tốc giống nhau.");
        }
    }

    public static void menu() {
        System.out.println("\n=========== MENU ===========");
        System.out.println("1. Phân Số");
        System.out.println("2. Vận Động Viên");
        System.out.println("3. Nhân Viên");
        System.out.println("4. Phương Tiện Giao Thông");
        System.out.println("0. Thoát chương trình");
        System.out.println("============================");
    }


}
