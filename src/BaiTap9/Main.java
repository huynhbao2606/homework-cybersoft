package BaiTap9;

import BaiTap9.DieuHoaMaySay.DieuHoa;
import BaiTap9.DieuHoaMaySay.MaySay;
import BaiTap9.DieuHoaMaySay.ThietBiDien;
import BaiTap9.HocSinh.HocSinh;
import BaiTap9.HocSinh.MonHoc;
import BaiTap9.TroChoi.TroChoi;
import BaiTap9.XeHoi.XeHoi;
import BaiTap9.XeHoiXeMay.PhuongTienGiaoThong;
import BaiTap9.XeHoiXeMay.XeMay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key;

        do {
            menu();
            key = nhapSoMinMax(sc, "Chọn chương trình (0-5): ", 0, 5);
            switch (key) {
                case 1 -> Bai1(sc);
                case 2 -> Bai2(sc);
                case 3 -> Bai3(sc);
                case 4 -> Bai4(sc);
                case 5 -> Bai5(sc);
                case 0 -> System.out.println("Đã thoát chương trình!!!");
            }
        } while (key != 0);
    }

    public static void menu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Học Sinh");
        System.out.println("2. Xe Hơi");
        System.out.println("3. Trò Chơi");
        System.out.println("4. Xe Hơi Và Xe Máy");
        System.out.println("5. Hệ Thống Điều Hoà Và Máy Sấy");
        System.out.println("0. Thoát chương trình");
        System.out.println("==========================");
    }

    public static void Bai1(Scanner sc) {
        int soluong = nhapSoNguyenDuong(sc, "Nhập số lượng sinh viên: ");

        for (int i = 1; i <= soluong; i++) {
            System.out.printf("\nSinh viên thứ %d:\n", i);
            System.out.print("Nhập tên: ");
            String ten = sc.nextLine();
            int tuoi = nhapSoNguyenDuong(sc, "Nhập tuổi: ");
            double toan = nhapSoMinMax(sc, "Điểm Toán: ", 0, 10);
            double ly = nhapSoMinMax(sc, "Điểm Lý: ", 0, 10);
            double hoa = nhapSoMinMax(sc, "Điểm Hoá: ", 0, 10);

            MonHoc monHoc = new MonHoc(toan, ly, hoa);
            HocSinh hs = new HocSinh(ten, tuoi, monHoc);
            System.out.println("\nKẾT QUẢ:");
            System.out.println(hs.xuatThongTin());
        }
    }

    public static void Bai2(Scanner sc) {
        int soluong = nhapSoNguyenDuong(sc, "Nhập số lượng xe hơi: ");

        for (int i = 1; i <= soluong; i++) {
            System.out.printf("\nXe hơi thứ %d:\n", i);
            System.out.print("Hãng sản xuất: ");
            String hangSX = sc.nextLine();
            System.out.print("Màu sắc: ");
            String mauSac = sc.nextLine();
            System.out.print("Năm sản xuất: ");
            String namSanXuat = sc.nextLine();

            XeHoi xeHoi = new XeHoi(hangSX, mauSac, namSanXuat);
            System.out.println("\nTHÔNG TIN XE HƠI:");
            System.out.println(xeHoi.thongTinXeHoi());
        }
    }

    public static void Bai3(Scanner sc) {
        System.out.print("Nhập tên trò chơi: ");
        TroChoi troChoi = new TroChoi(sc.nextLine());

        while (true) {
            System.out.println("\n--- MENU TRÒ CHƠI ---");
            System.out.println("1. Bắt đầu trò chơi");
            System.out.println("2. Kết thúc trò chơi");
            System.out.println("3. Hiển thị thông tin trò chơi");
            System.out.println("0. Quay lại menu chính");
            int choice = nhapSoMinMax(sc, "Chọn: ", 0, 3);

            switch (choice) {
                case 1 -> troChoi.batDau();
                case 2 -> troChoi.ketThuc();
                case 3 -> troChoi.hienThiThongTin();
                case 0 -> {
                    System.out.println("Quay lại menu chính");
                    return;
                }
            }
        }
    }

    public static void Bai4(Scanner sc) {
        int soLuong = nhapSoNguyenDuong(sc, "Nhập số lượng phương tiện: ");
        List<PhuongTienGiaoThong> ds = new ArrayList<>();

        for (int i = 1; i <= soLuong; i++) {
            System.out.printf("\nPhương tiện thứ %d:\n", i);
            System.out.println("1. Xe Hơi");
            System.out.println("2. Xe Máy");
            System.out.print("Chọn Loại: ");
            int loai = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập Tên " + (loai == 1 ? "Xe Hơi: " : "Xe Máy: "));
            String ten = sc.nextLine();
            System.out.print("Hãng sản xuất: ");
            String hang = sc.nextLine();
            System.out.print("Màu sắc: ");
            String mau = sc.nextLine();
            System.out.print("Năm sản xuất: ");
            String nam = sc.nextLine();

            if (loai == 1)
                ds.add(new BaiTap9.XeHoiXeMay.XeHoi(hang, mau, nam, ten));
            else
                ds.add(new XeMay(hang, mau, nam, ten));
        }

        System.out.println("\nDANH SÁCH PHƯƠNG TIỆN:");
        for (PhuongTienGiaoThong pt : ds) {
            pt.xuat();
            System.out.println("----------------------");
        }
    }

    public static void Bai5(Scanner sc) {
        int soLuong = nhapSoNguyenDuong(sc, "Nhập số lượng thiết bị điện: ");
        List<ThietBiDien> ds = new ArrayList<>();

        for (int i = 1; i <= soLuong; i++) {
            System.out.printf("\nThiết bị thứ %d:\n", i);
            System.out.println("1. Điều Hoà");
            System.out.println("2. Máy Sấy");
            System.out.print("Chọn Loại: ");
            int loai = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập Tên " + (loai == 1 ? "Điều Hoà: " : "Máy Sấy: "));
            String ten = sc.nextLine();
            double congSuat = nhapSoMinMax(sc, "Công suất: ", 0, 100);
            System.out.print("Chức năng: ");
            String chucNang = sc.nextLine();

            if (loai == 1) {
                System.out.print("Chế độ làm lạnh: ");
                String cheDo = sc.nextLine();
                ds.add(new DieuHoa(ten, congSuat, chucNang, cheDo));
            } else {
                System.out.print("Loại sấy: ");
                String loaiSay = sc.nextLine();
                ds.add(new MaySay(ten, congSuat, chucNang, loaiSay));
            }
        }

        System.out.println("\nDANH SÁCH THIẾT BỊ:");
        for (ThietBiDien tb : ds) {
            tb.xuatThongTin();
            System.out.print("Trạng Thái: ");
            tb.trangThai();
            System.out.println("----------------------");
        }
    }

    public static int nhapSoNguyenDuong(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value > 0) return value;
                System.out.println("Giá trị phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng số!");
            }
        }
    }

    public static int nhapSoMinMax(Scanner sc, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value >= min && value <= max) return value;
                System.out.printf("Giá trị phải trong khoảng %d - %d\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng số!");
            }
        }
    }
}
