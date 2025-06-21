package BaiTap9.XeHoiXeMay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XeMay extends PhuongTienGiaoThong{
    private String tenXeMay;

    public XeMay(String hangSanXuat, String mauSac, String namSanXuat, String tenXeMay) {
        super(hangSanXuat, mauSac, namSanXuat);
        this.tenXeMay = tenXeMay;
    }

    @Override
    public void xuat(){
        System.out.println("Tên Xe Máy: " + tenXeMay);
        super.xuat();
    }
}
