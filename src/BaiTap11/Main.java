package BaiTap11;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CongTy congTy = new CongTy();
        int key;

        while (true) {
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║             MENU QUẢN LÝ NHÂN SỰ              ║");
            System.out.println("╠═══════════════════════════════════════════════╣");
            System.out.println("║ 1. Nhập thông tin công ty                     ║");
            System.out.println("║ 2. Phân bổ Nhân viên vào Trưởng phòng         ║");
            System.out.println("║ 3. Thêm, xóa thông tin một nhân sự            ║");
            System.out.println("║ 4. Xuất thông tin toàn bộ người trong công ty ║");
            System.out.println("║ 5. Tính và xuất tổng lương toàn công ty       ║");
            System.out.println("║ 6. Tìm Nhân viên có lương cao nhất            ║");
            System.out.println("║ 7. Trưởng phòng có nhiều nhân viên nhất       ║");
            System.out.println("║ 8. Sắp xếp theo tên (A -> Z)                  ║");
            System.out.println("║ 9. Sắp xếp theo lương giảm dần                ║");
            System.out.println("║ 10. Giám đốc có cổ phần nhiều nhất            ║");
            System.out.println("║ 11. Tổng thu nhập từng Giám đốc               ║");
            System.out.println("║ 12. Tạo dữ liệu giả                           ║");
            System.out.println("║ 0. Thoát chương trình                         ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            try {
                System.out.print("-> Nhập lựa chọn của bạn (1–12) - 0 Để Thoát: ");
                key = Integer.parseInt(sc.nextLine());

                switch (key) {
                    case 1 -> congTy.nhapThongTinCongTy(sc);
                    case 2 -> congTy.phanBoNhanVienChoTruongPhong(sc);
                    case 3 -> congTy.themHoacXoaNhanSu(sc);
                    case 4 -> congTy.xuatThongTinToanBoNhanSu();
                    case 5 -> congTy.tinhVaXuatTongLuong();
                    case 6 -> congTy.timNhanVienLuongCaoNhat();
                    case 7 -> congTy.timTruongPhongQuanLyNhieuNhanVienNhat();
                    case 8 -> congTy.sapXepNhanVienTheoABC();
                    case 9 -> congTy.sapXepNhanSuTheoLuongGiamDan();
                    case 10 -> congTy.timGiamDocCoCoPhanNhieuNhat();
                    case 11 -> congTy.tinhVaXuatThuNhapCuaGiamDoc();
                    case 12 -> congTy.taoDuLieuGia(congTy);
                    case 0 -> {
                        System.out.println("Đã thoát chương trình!!!");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập từ 1–13.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên từ 1 đến 13.");
            }
        }
    }
}
