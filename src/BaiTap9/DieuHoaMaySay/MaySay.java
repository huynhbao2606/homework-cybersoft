package BaiTap9.DieuHoaMaySay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaySay extends ThietBiDien{
    private String loaiSay;

    public MaySay(String tenThietBi, double congSuat, String chucNang, String loaiSay) {
        super(tenThietBi, congSuat, chucNang);
        this.loaiSay = loaiSay;
    }

    @Override
    public void xuatThongTin() {
        System.out.println("Máy Sấy");
        super.xuatThongTin();
        System.out.println("Loại Sấy: " + loaiSay);
    }

    @Override
    public void trangThai(){
        System.out.println("Bật Sấy Với Loại Sấy: " + loaiSay);
    }
}
