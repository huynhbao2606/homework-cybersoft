package BaiTap11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TruongPhong extends NhanSu{
    private ArrayList<NhanVien>  nhanVien  = new ArrayList<>();

    public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec);
    }

    @Override
    public double tinhLuong() {
        return 200 * getSoNgayLamViec() + 100 * nhanVien.size();
    }
}
