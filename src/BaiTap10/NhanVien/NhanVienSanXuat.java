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
public class NhanVienSanXuat extends NhanVien {
    private int soSanPham;
    private double luongCanBan;


    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Lương Căn Bản: ");
        luongCanBan = sc.nextDouble();
        System.out.print("Số Sản Phẩm: ");
        soSanPham = sc.nextInt();
    }

    @Override
    public void tinhLuong() {
        setLuong(luongCanBan + soSanPham * 5000);
    }
}
