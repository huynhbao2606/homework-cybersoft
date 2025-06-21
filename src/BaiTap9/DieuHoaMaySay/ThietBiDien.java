package BaiTap9.DieuHoaMaySay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThietBiDien {
    private String tenThietBi;
    private double congSuat;
    private  String chucNang;


    public void xuatThongTin(){
        System.out.println("Tên thiết bị: " + tenThietBi);
        System.out.println("Công suất: " + congSuat + " kW");
        System.out.println("Chức năng: " + chucNang);
    }

    public void trangThai(){}

}
