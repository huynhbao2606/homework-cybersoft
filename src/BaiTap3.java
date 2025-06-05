import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        do {
            System.out.println("\n════════════════════ MENU ════════════════════");
            System.out.println("│ 1. Kéo Búa Bao                             │");
            System.out.println("│ 2. Tìm Số Nguyên Dương Nhỏ Nhất            │");
            System.out.println("│ 3. Tính Tổng Số Lẻ                         │");
            System.out.println("│ 4. Nhập Số và Tính Tổng                    │");
            System.out.println("│ 5. Tính Số Năm Chờ Đợi Cho Anh X           │");
            System.out.println("│ 0. Thoát chương trình                      │");
            System.out.println("══════════════════════════════════════════════");
            System.out.print("Chọn chương trình (0-5): ");
            try {
                key = sc.nextInt();
                if (key < 0 || key > 5) {
                    System.out.println("Vui lòng nhập từ 0 đến 5!");
                    continue;
                }
                switch (key) {
                    case 1:
                        Bai1(sc);
                        break;
                    case 2:
                        Bai2();
                        break;
                    case 3:
                        Bai3(sc);
                        break;
                    case 4:
                        Bai4(sc);
                        break;
                    case 5:
                        Bai5(sc);
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình!!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên!!!");
                sc.next();
            }
        } while (key != 0);
        sc.close();
    }

    public static void Bai1(Scanner sc) {
        Random random = new Random();
        int thang = 0;
        int thua = 0;
        int hoa = 0;
        int nguoiChoi;
        int may;

        System.out.println("═════Trò Chơi═════");
        System.out.println("│   Kéo Búa Bao  │");
        System.out.println("══════════════════");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("| 1 - Bao, 2 - Kéo, 3 - Bao. Nhấn 0 Để Thoát |");
        System.out.println("══════════════════════════════════════════════");

        while (true) {
            System.out.println("Vui Lòng Chọn 1 - 3 (Chọn 0 Để Thoát): ");
            nguoiChoi = sc.nextInt();

            if (nguoiChoi == 0){
                System.out.println("Đã Thoát Trò Chơi");
                break;
            }

            if (nguoiChoi < 1 || nguoiChoi > 3) {
                System.out.println("Vui Lòng Chọn 1 Đến 3. Vui Lòng Chọn Lại!!!");
                continue;
            }

            may = random.nextInt(3) + 1;

            System.out.println("Người Chơi : " + luaChon(nguoiChoi));
            System.out.println("Máy : " + luaChon(may));

            if (nguoiChoi == may) {
                hoa++;
                System.out.println("=> Hòa!\n");
            } else if ((nguoiChoi == 1 && may == 3) || (nguoiChoi == 2 && may == 1) || (nguoiChoi == 3 && may == 2)) {
                thang++;
                System.out.println("=> Bạn thắng!\n");
            } else {
                thua++;
                System.out.println("=> Máy thắng!\n");
            }


            System.out.println("KẾT QUẢ: ");
            System.out.println("Người Chơi Thắng: " + thang);
            System.out.println("Máy Thắng: " + thua );
            System.out.println("Hoà: " + hoa);

            if (thang > thua){
                System.out.println("Người Chơi Chiến Thắng!!");
                System.out.println("Tỉ Số Chung Cuộc: " + thang + " - " + thua);
            }else if (thang < thua){
                System.out.println("Máy Chiến Thắng!!");
                System.out.println("Tỉ Số Chung Cuộc: " + thua + " - " + thang);
            }else{
                System.out.println("Trận Đấu Hoà!!!");
                System.out.println("Tỉ Số Chung Cuộc: " + thang + " - " + thua);
            }
        }
    }

    public static String luaChon(int luaChon) {
        return switch (luaChon) {
            case 1 -> "Kéo";
            case 2 -> "Búa";
            case 3 -> "Bao";
            default -> "Vui Lòng Chọn Lại!!";
        };
    }

    public static void Bai2(){
        int n = 0;
        int s = 0;

        while (s < 10000) {
            n++;
            s += n;
        }

        System.out.println("Số nguyên dương nhỏ nhất là: " + n);
        System.out.println("Tổng từ 1 đến " + n + " là: " + s);
    }

    public static void Bai3(Scanner sc){
        int n;
        do {
            System.out.print("Nhập Số Nguyên Lớn Hơn 0: ");
            n = sc.nextInt();
        }while (n <= 0);

        int s = 0;
        for (int i = 1; i < n; i += 2) {
            s += i;
        }

        System.out.println("Tổng Số Lẻ Nhỏ Hơn " + n + " Là: " + s);
    }

    public static void Bai4(Scanner sc){
        System.out.print("Nhập x: ");
        int x = sc.nextInt();
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += luyThua(x, i);
        }

        System.out.println("Tổng S(n) là: " + sum);
    }

    public static long luyThua(int x, int t) {
        long result = 1;
        for (int i = 0; i < t; i++) {
            result *= x;
        }
        return result;
    }

    public static void Bai5(Scanner sc){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat chuyenDoiVND = NumberFormat.getCurrencyInstance(localeVN);
        System.out.println("Số Tiền Hiện Tại: ");
        double tienHienTai = sc.nextDouble();

        System.out.println("Số Tiền Mong Muốn: ");
        double tienMongMuon = sc.nextDouble();

        System.out.println("Số Lãi Xuất %: ");
        double laiXuat = sc.nextDouble();

        int nam = 0;

        double tienBanDau = tienHienTai;

        while (tienHienTai < tienMongMuon) {
            tienHienTai += tienHienTai * laiXuat / 100;
            nam++;
        }

        System.out.println("Số tiền ban đầu: " + chuyenDoiVND.format(tienBanDau));
        System.out.println("Số tiền mong muốn; " + chuyenDoiVND.format(tienMongMuon));
        System.out.println("Số năm anh X cần chờ đợi để mua chiếc ô tô là: " + nam + " năm");
    }
}
