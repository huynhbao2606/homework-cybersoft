package BaiTap10.PhuongTienGiaoThong;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhuongTienGiaoThong {
    private String tenPhuongTien;
    private String hangSanXuat;
    private String namSanXuat;
    private int vanTocToiDa;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tên Phương Tiện: ");
        tenPhuongTien = sc.nextLine();
        System.out.println("Hãng Sản Xuất: ");
        hangSanXuat = sc.nextLine();
        System.out.println("Năm Sản Xuất: ");
        namSanXuat = sc.nextLine();
        System.out.println("Vận Tốc Tối Đa: ");
        vanTocToiDa = Integer.parseInt(sc.nextLine());
    }

    public void xuat(){
        System.out.println("Tên Phương Tiện: " + tenPhuongTien);
        System.out.println("Hãng Sản Xuất: " + hangSanXuat);
        System.out.println("Năm Sản Xuất: " + namSanXuat);
        System.out.println("Vận Tốc Tối Đa: " + vanTocToiDa);
    }
}
