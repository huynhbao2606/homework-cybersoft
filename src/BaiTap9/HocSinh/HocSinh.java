package BaiTap9.HocSinh;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HocSinh {
    private String ten;
    private int tuoi;
    private MonHoc monHoc;

    public double diemTrungBinh(){
        return this.monHoc.getToan() + this.monHoc.getLy() + this.monHoc.getHoa() / 3;
    }

    public String xuatThongTin() {
        return "Tên: " + this.ten + "\n"
                + "Điểm Toán: " + this.monHoc.getToan() + "\n"
                + "Điểm Lý: " + this.monHoc.getLy() + "\n"
                + "Điểm Hóa: " + this.monHoc.getHoa() + "\n"
                + "Điểm Trung Bình: " + diemTrungBinh() + "\n";
    }
}
