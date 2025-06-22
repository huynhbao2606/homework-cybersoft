package BaiTap10.NhanVien;

import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien{
    private int soNgayLam;

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Số Ngày Làm Việc: ");
        soNgayLam = sc.nextInt();
    }

    @Override
    public void tinhLuong() {
        setLuong(soNgayLam * 100000);
    }
}
