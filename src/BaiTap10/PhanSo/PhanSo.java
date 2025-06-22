package BaiTap10.PhanSo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhanSo {
    private double tuSo;
    private double mauSo;

    public PhanSo cong(PhanSo b) {
        double ts = this.tuSo * b.mauSo + b.tuSo * this.mauSo;
        double ms = this.mauSo * b.mauSo;
        return new PhanSo(ts, ms);
    }

    public PhanSo tru(PhanSo b) {
        double ts = this.tuSo * b.mauSo - b.tuSo * this.mauSo;
        double ms = this.mauSo * b.mauSo;
        return new PhanSo(ts, ms);
    }

    public PhanSo nhan(PhanSo b) {
        return new PhanSo(this.tuSo * b.tuSo, this.mauSo * b.mauSo);
    }

    public PhanSo chia(PhanSo b) {
        return new PhanSo(this.tuSo * b.mauSo, this.mauSo * b.tuSo);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tử số: ");
        this.tuSo = sc.nextDouble();
        do {
            System.out.print("Mẫu số (khác 0): ");
            this.mauSo = sc.nextDouble();
        } while (this.mauSo == 0);
    }

    public String xuat() {
        return tuSo + "/" + mauSo;
    }
}
