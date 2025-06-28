package BaiTap11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien extends NhanSu{
    private TruongPhong truongPhong;

    public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
    }

    @Override
    public double tinhLuong() {
        return 100 * getSoNgayLamViec();
    }
}
