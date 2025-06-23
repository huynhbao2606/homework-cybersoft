package BaiTap9.XeHoiXeMay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class PhuongTienGiaoThong {
    private String hangSanXuat;
    private String mauSac;
    private String namSanXuat;


    public void xuat(){
        System.out.println("Hãng Sản Xuất: " + hangSanXuat);
        System.out.println("Màu Sắc: " + mauSac);
        System.out.println("Năm Sản Xuất: " + namSanXuat);
    }
}
