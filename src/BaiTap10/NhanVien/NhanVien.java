package BaiTap10.NhanVien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class NhanVien {
    private String hoTen;
    private String ngaySinh;
    private double luong;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Họ Tên: ");
        hoTen = sc.nextLine();
        System.out.print("Ngày Sinh: ");
        ngaySinh = sc.nextLine();
    }

    public void tinhLuong(){}

    public void xuat(){
        System.out.println("Họ Tên: " + hoTen);
        System.out.println("Ngày Sinh: " + ngaySinh);
        System.out.println("Lương: " + luong);
    }
}
