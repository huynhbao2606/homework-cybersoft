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
public class Oto extends PhuongTienGiaoThong {
    private int choNgoi;
    private String dongCo;

    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Số Chỗ Ngồi");
        choNgoi = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập Động Cơ: ");
        dongCo = sc.nextLine();
    }

    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Chỗ Ngồi: " + choNgoi);
        System.out.println("Động Cơ: " + dongCo);
    }

}
