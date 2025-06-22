package BaiTap10.VanDongVien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VanDongVien{
    private String ten;
    private int tuoi;
    private String monThidau;
    private double canNang;
    private double chieuCao;

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Tên: ");
        ten = sc.nextLine();
        System.out.print("Nhập Tuổi: ");
        tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập Môn Thi Đấu: ");
        monThidau = sc.nextLine();
        System.out.print("Nhập Cân Nặng: ");
        canNang = sc.nextDouble();
        System.out.print("Nhập Chiều Cao: ");
        chieuCao = sc.nextDouble();
    }

    public void xuat(){
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Môn Thi Đấu: " + monThidau);
        System.out.println("Cân Nặng: " + canNang);
        System.out.println("Chiều Cao: " + chieuCao);
    }

    public void soSanh(VanDongVien vdv) {
        if (this.chieuCao > vdv.chieuCao) {
            System.out.println("Vận động viên " + this.ten + " cao hơn " + vdv.ten);
        } else if (this.chieuCao < vdv.chieuCao) {
            System.out.println("Vận động viên " + vdv.ten + " cao hơn " + this.ten);
        } else {
            if (this.canNang > vdv.canNang) {
                System.out.println("Cùng chiều cao, nhưng " + this.ten + " nặng hơn " + vdv.ten);
            } else if (this.canNang < vdv.canNang) {
                System.out.println("Cùng chiều cao, nhưng " + vdv.ten + " nặng hơn " + this.ten);
            } else {
                System.out.println("Cả hai vận động viên " + this.ten + " và " + vdv.ten + " bằng nhau.");
            }
        }
    }

}
