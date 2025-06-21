package BaiTap9.XeHoiXeMay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XeHoi extends PhuongTienGiaoThong{
    private String tenXeHoi;

    public XeHoi(String hangSanXuat, String mauSac, String namSanXuat, String tenXeHoi) {
        super(hangSanXuat, mauSac, namSanXuat);
        this.tenXeHoi = tenXeHoi;
    }

    @Override
    public void xuat(){
        System.out.println("Tên Xe Hơi: " + tenXeHoi);
        super.xuat();
    }
}
