package BaiTap11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiamDoc extends NhanSu{
    private CongTy congTy;
    private double coPhan;

    public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, double coPhan) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
        this.coPhan = coPhan;
    }

    @Override
    public double tinhLuong() {
        return 300 * getSoNgayLamViec();
    }
}
