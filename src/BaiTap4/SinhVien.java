package BaiTap4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien extends MonHoc {
    private String name;
    private int maSv;


    public SinhVien(String name, int maSv, double toan, double ly, double hoa) {
        super(toan, ly, hoa);
        this.name = name;
        this.maSv = maSv;
    }


    public double diemTrungBinh(){
        return (super.getToan() + super.getLy() +  super.getHoa()) / 3;
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
        return "Tên: " + this.name + "\n" +
                "Mã SV: " + this.maSv + "\n" +
                "Điểm Toán: " + super.getToan() + "\n" +
                "Điểm Lý: " + super.getLy() + "\n" +
                "Điểm Hoá: " + super.getHoa() + "\n" +
                "Điểm Trung Bình: " + diemTrungBinh() + "\n" +
                "Xếp Loại: " + xepLoai();
    }
}
