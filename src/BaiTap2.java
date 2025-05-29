import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key;
        do {
            System.out.println("\n════════════════════ MENU ════════════════════");
            System.out.println("│ 1. Tìm số lớn nhất trong 3 số             │");
            System.out.println("│ 2. Kiểm tra số chẵn hay lẻ                │");
            System.out.println("│ 3. Tính tổng 3 số                         │");
            System.out.println("│ 4. Máy tính cơ bản                        │");
            System.out.println("│ 0. Thoát chương trình                     │");
            System.out.println("═════════════════════════════════════════════");
            System.out.print("Chọn chương trình (0-4): ");
            try {
                key = sc.nextInt();
                if (key < 0 || key > 4) {
                    System.out.println("Vui lòng nhập từ 0 đến 4!");
                    continue;
                }
                switch (key) {
                    case 1:
                        Bai1(sc);
                        break;
                    case 2:
                        Bai2(sc);
                        break;
                    case 3:
                        Bai3(sc);
                        break;
                    case 4:
                        Bai4(sc);
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
        System.out.println("\n=== TÌM SỐ LỚN NHẤT ===");
        try {
            System.out.print("Nhập A: ");
            double a = sc.nextDouble();
            System.out.print("Nhập B: ");
            double b = sc.nextDouble();
            System.out.print("Nhập C: ");
            double c = sc.nextDouble();
            double max = a;
            if (b > max) max = b;
            if (c > max) max = c;
            System.out.printf("Số lớn nhất là: %.2f\n", max);
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số!");
            sc.next();
        }
    }

    public static void Bai2(Scanner sc) {
        System.out.println("\n=== TÌM SỐ CHẴN LẺ ===");
        try {
            System.out.print("Nhập số: ");
            int a = sc.nextInt();
            if (a % 2 == 0) {
                System.out.printf("Số %d là số chẵn!\n", a);
            } else {
                System.out.printf("Số %d là số lẻ!\n", a);
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số nguyên!");
            sc.next();
        }
    }

    public static void Bai3(Scanner sc) {
        System.out.println("\n=== TÍNH TỔNG 3 SỐ ===");
        try {
            System.out.print("Nhập A: ");
            double a = sc.nextDouble();
            System.out.print("Nhập B: ");
            double b = sc.nextDouble();
            System.out.print("Nhập C: ");
            double c = sc.nextDouble();
            double result = a + b + c;
            System.out.printf("Tổng 3 số là: %.2f\n", result);
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số!");
            sc.next();
        }
    }

    public static void Bai4(Scanner sc) {
        System.out.println("\n=== MÁY TÍNH CƠ BẢN ===");
        try {
            System.out.print("Nhập số đầu tiên: ");
            double a = sc.nextDouble();
            System.out.print("Nhập số thứ hai: ");
            double b = sc.nextDouble();
            System.out.println("1: Cộng (+)");
            System.out.println("2: Trừ (-)");
            System.out.println("3: Nhân (*)");
            System.out.println("4: Chia (/)");
            System.out.print("Chọn phép tính (1-4): ");
            int c = sc.nextInt();
            if (c < 1 || c > 4) {
                System.out.println("Phép tính không hợp lệ!");
                return;
            }
            switch (c) {
                case 1:
                    System.out.printf("%.2f + %.2f = %.2f\n", a, b, a + b);
                    break;
                case 2:
                    System.out.printf("%.2f - %.2f = %.2f\n", a, b, a - b);
                    break;
                case 3:
                    System.out.printf("%.2f * %.2f = %.2f\n", a, b, a * b);
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("Không thể chia cho 0!");
                    } else {
                        System.out.printf("%.2f / %.2f = %.2f\n", a, b, a / b);
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
            sc.next();
        }
    }
}