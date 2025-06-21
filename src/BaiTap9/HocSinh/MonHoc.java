package BaiTap9.HocSinh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonHoc {
    private double toan;
    private double ly;
    private double hoa;

    public String ketQua(){
        return "Toan: " + this.toan + "\n"
                + "Lý: " + this.ly + "\n"
                + "Hoá: " + this.hoa + "\n";
    }
}
