package BaiTap5;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = 0;

        SinhVien[] luuDanhSach = new SinhVien[100];

        do {
            menu();
            try {
                key = Integer.parseInt(sc.nextLine());
                if (key < 0 || key > 7) {
                    System.out.println("Vui lòng nhập từ 0 đến 7!");
                    continue;
                }
                switch (key) {
                    case 1:
                        nhapSinhVien(sc, luuDanhSach);

                        System.out.println("Đã Nhập Thành Công!!");
                        System.out.println("Nhấn Enter để quay lại menu...");
                        sc.nextLine();
                        break;
                    case 2:
                        dsDTB(luuDanhSach);

                        System.out.println("Nhấn Enter để quay lại menu...");
                        sc.nextLine();
                        break;
                    case 3:
                        dsYeu(luuDanhSach);

                        System.out.println("Nhấn Enter để quay lại menu...");
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.println("Nhập Tên SV Cần Tìm : ");
                        String tenSv = sc.nextLine();

                        timTenSV(luuDanhSach, tenSv);
                        System.out.println("Nhấn Enter để quay lại menu...");

                        sc.nextLine();
                        break;
                    case 5:
                        System.out.println("Nhập Mã SV Cần Tìm");
                        int maSv = nhapSoNguyenDuong(sc, 1, Integer.MAX_VALUE);

                        timMaSV(luuDanhSach, maSv);

                        System.out.println("Nhấn Enter để quay lại menu...");
                        sc.nextLine();
                        break;
                    case 6:
                        System.out.println("Nhập Mã SV Cần Xoá");
                        int maSvXoa = nhapSoNguyenDuong(sc, 1, Integer.MAX_VALUE);


                        Optional<SinhVien> svXoa = Arrays.stream(luuDanhSach)
                                .filter(Objects::nonNull)
                                .filter(sv -> sv.getMaSv() == maSvXoa)
                                .findFirst();

                        if (svXoa.isPresent()) {
                            System.out.println("Thông tin sinh viên bị xoá:");
                            System.out.println(svXoa.get().ketQua());
                            System.out.println("Đã xoá thành công!!");
                            luuDanhSach = xoaSinhVien(luuDanhSach, maSvXoa);
                        } else {
                            System.out.println("Không tìm thấy sinh viên có mã " + maSvXoa);
                        }

                        System.out.println("Nhấn Enter để quay lại menu...");
                        sc.nextLine();
                    case 7:
                        System.out.println("Danh Sách Sinh Viên: ");
                        for (SinhVien sv : luuDanhSach) {
                            if (sv != null) {
                                System.out.println(sv.ketQua());
                            }
                        }

                        System.out.println("Nhấn Enter để quay lại menu...");
                        sc.nextLine();
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình!!!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            }
        } while (key != 0);
        sc.close();
    }

    public static SinhVien[] nhapSinhVien(Scanner sc, SinhVien[] ds) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = nhapSoNguyenDuong(sc, 1, 100);

        for (int i = 0, j = 0; i < n && j < ds.length; j++) {
            if (ds[j] != null) continue;

            System.out.println("\n--- Nhập thông tin sinh viên ---");

            String hoTen;
            do {
                System.out.print("Tên: ");
                hoTen = sc.nextLine().trim();
                if (hoTen.isEmpty()) {
                    System.out.println("Tên không được để trống!");
                }
            } while (hoTen.isEmpty());

            int maSV;
            while (true) {
                System.out.print("Mã SV (số dương, không trùng): ");
                maSV = nhapSoNguyenDuong(sc, 1, Integer.MAX_VALUE);

                boolean trung = false;
                for (SinhVien sv : ds) {
                    if (sv != null && sv.getMaSv() == maSV) {
                        trung = true;
                        break;
                    }
                }
                if (trung) {
                    System.out.println("Mã SV đã tồn tại. Vui lòng nhập lại.");
                } else {
                    break;
                }
            }

            float toan = nhapDiem(sc, "Toán");
            float ly = nhapDiem(sc, "Lý");
            float hoa = nhapDiem(sc, "Hóa");

            MonHoc monHoc = new MonHoc(toan, ly, hoa);
            ds[j] = new SinhVien(hoTen, maSV, monHoc);
            i++;
        }

        return ds;
    }

    public static SinhVien[] dsDTB(SinhVien[] ds) {
        System.out.println("\n📊 Sinh Viên Có Điểm Trung Bình Cao: ");

        for (SinhVien sv : ds) {
            if (sv != null && sv.diemTrungBinh() >= 8) {
                System.out.println(sv.ketQua());
                System.out.println("------------------------------------");
            }
        }
        return ds;
    }

    public static SinhVien[] dsYeu(SinhVien[] ds) {
        System.out.println("\n📉 Sinh Viên Yếu: ");

        for (SinhVien sv : ds) {
            if (sv != null && sv.diemTrungBinh() <= 4) {
                System.out.println(sv.ketQua());
                System.out.println("------------------------------------");
            }
        }
        return ds;
    }

    public static Optional<SinhVien> timTenSV(SinhVien[] ds, String tenSv) {
        Optional<SinhVien> timTenSinhVien = Arrays.stream(ds)
                .filter(Objects::nonNull)
                .filter(sv -> sv.getName().equalsIgnoreCase(tenSv))
                .findFirst();
        timTenSinhVien.ifPresent(sv -> System.out.println(sv.ketQua()));
        return timTenSinhVien;
    }

    public static Optional<SinhVien> timMaSV(SinhVien[] ds, int maSv) {
        Optional<SinhVien> timTenSinhVien = Arrays.stream(ds)
                .filter(Objects::nonNull)
                .filter(sv -> sv.getMaSv() == maSv)
                .findFirst();
        timTenSinhVien.ifPresent(sv -> System.out.println(sv.ketQua()));
        return timTenSinhVien;
    }

    public static SinhVien[] xoaSinhVien(SinhVien[] ds, int maSv) {
        return Arrays.stream(ds)
                .filter(Objects::nonNull)
                .filter(sv -> sv.getMaSv() != maSv)
                .toArray(SinhVien[]::new);
    }

    public static float nhapDiem(Scanner sc, String mon) {
        float diem;
        while (true) {
            System.out.print("Điểm " + mon + " (0 - 10): ");
            try {
                diem = Float.parseFloat(sc.nextLine());
                if (diem < 0 || diem > 10) {
                    System.out.println("Điểm phải trong khoảng 0 đến 10!");
                } else {
                    return diem;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public static int nhapSoNguyenDuong(Scanner sc, int min, int max) {
        int so;
        while (true) {
            try {
                so = Integer.parseInt(sc.nextLine());
                if (so < min || so > max) {
                    System.out.println("Số phải nằm trong khoảng " + min + " - " + max);
                } else {
                    return so;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    public static void menu(){
        System.out.println("\n════════════════════ MENU ════════════════════");
        System.out.println("│ 1. Nhập Danh Sách Sinh Viên                │");
        System.out.println("│ 2. Danh Sách Điểm Trung Bình Cao           │");
        System.out.println("│ 3. Danh Sách Điểm Yếu                      │");
        System.out.println("│ 4. Tìm Tên                                 │");
        System.out.println("│ 5. Tìm Mã SV                               │");
        System.out.println("│ 6. Xoá SV                                  │");
        System.out.println("│ 7. Danh Sách Sinh Viên                     │");
        System.out.println("│ 0. Thoát chương trình                      │");
        System.out.println("══════════════════════════════════════════════");
        System.out.print("Chọn chương trình (0-7): ");
    }
}
