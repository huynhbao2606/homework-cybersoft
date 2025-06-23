package BaiTap4;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonHoc {
    private double toan;
    private double ly;
    private double hoa;


    @Override
    public String toString() {
        return "MonHoc{" +
                "toan=" + toan +
                ", ly=" + ly +
                ", hoa=" + hoa +
                '}';
    }
}
