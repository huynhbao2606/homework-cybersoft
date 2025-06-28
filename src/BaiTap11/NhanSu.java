package BaiTap11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class NhanSu {
    private String maSo;
    private String hoTen;
    private String soDienThoai;
    private int soNgayLamViec;

    public abstract double tinhLuong();
}
