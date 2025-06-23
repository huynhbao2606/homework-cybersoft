package BaiTap4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien{
    private String name;
    private int maSv;
    private MonHoc monHoc;

    public double diemTrungBinh(){
        return (this.monHoc.getToan() + this.monHoc.getLy() +  this.monHoc.getHoa()) / 3;
    }

    public String xepLoai(){
        if (diemTrungBinh() >= 9)
            return "Xuất Sắc";
        else if (diemTrungBinh() >= 8 && diemTrungBinh() <= 9)
            return "Giỏi";
        else if (diemTrungBinh() >= 7 && diemTrungBinh() <= 8)
            return "Khá";
        else if (diemTrungBinh() >= 6 && diemTrungBinh() <= 7)
            return "Trung Bình Khá";
        else if (diemTrungBinh() >= 5 && diemTrungBinh() <= 6)
            return "Trung Bình";
        else
            return "Yếu";
    }

    public String ketQua() {
        return "Tên: " + this.name + "\n"
                + "Mã SV: " + this.maSv + "\n"
                + "Điểm Toán: " + this.monHoc.getToan() + "\n"
                + "Điểm Lý: " +  this.monHoc.getLy() + "\n"
                + "Điểm Hóa: " +  this.monHoc.getHoa() + "\n"
                + "Điểm Trung Bình: " + diemTrungBinh() + "\n"
                + "Xếp Loại: " + xepLoai();
    }
}
