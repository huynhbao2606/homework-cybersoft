package BaiTap11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CongTy congTy = new CongTy();
        int choice;

        do {
            System.out.println("\n====== MENU QUẢN LÝ NHÂN SỰ ======");
            System.out.println("1. Nhập thông tin công ty");
            System.out.println("2. Phân bổ Nhân viên vào Trưởng phòng");
            System.out.println("3. Thêm, xóa thông tin một nhân sự");
            System.out.println("4. Xuất thông tin toàn bộ người trong công ty");
            System.out.println("5. Tính và xuất tổng lương cho toàn công ty");
            System.out.println("6. Tìm Nhân viên thường có lương cao nhất");
            System.out.println("7. Tìm Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
            System.out.println("8. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
            System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
            System.out.println("10. Tìm Giám đốc có số lượng cổ phần nhiều nhất");
            System.out.println("11. Tính và Xuất tổng THU NHẬP của từng Giám đốc");
            System.out.println("12. Tạo dữ liệu giả");
            System.out.println("13. Thoát chương trình");
            System.out.print("→ Nhập lựa chọn của bạn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    congTy.nhapThongTinCongTy(sc);
                    break;
                case 2:
                    congTy.phanBoNhanVienChoTruongPhong(sc);
                    break;
                case 3:
                    congTy.themHoacXoaNhanSu(sc);
                    break;
                case 4:
                    congTy.xuatThongTinToanBoNhanSu();
                    break;
                case 5:
//                    congTy.tinhVaXuatTongLuong();
                    break;
                case 6:
//                    congTy.timNhanVienThuongLuongCaoNhat();
                    break;
                case 7:
//                    congTy.timTruongPhongQuanLyNhieuNhanVienNhat();
                    break;
                case 8:
//                    congTy.sapXepNhanVienTheoTen();
                    break;
                case 9:
//                    congTy.sapXepNhanVienTheoLuongGiamDan();
                    break;
                case 10:
//                    congTy.timGiamDocCoCoPhanNhieuNhat();
                    break;
                case 11:
//                    congTy.tinhVaXuatThuNhapGiamDoc();
                    break;
                case 12:
                    congTy.taoDuLieuGia();
                    break;
                case 13:
                    System.out.println("Đã thoát chương trình.");
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

        } while (choice != 13);

        sc.close();
    }
}
