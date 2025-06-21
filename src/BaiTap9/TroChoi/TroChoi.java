package BaiTap9.TroChoi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TroChoi {
    private String tenTroChoi;
    private int soLuotChoi;
    private boolean trangThai;

    public TroChoi(String tenTroChoi) {
        this.tenTroChoi = tenTroChoi;
        this.soLuotChoi = 0;
        this.trangThai = false;
    }

    public void batDau(){
        if(!trangThai){
            trangThai = true;
            soLuotChoi++;
            System.out.println("Bắt Đầu Trò Chơi: " + tenTroChoi);
        } else {
            System.out.println("Đã chơi rồi!!");
        }
    }

    public void ketThuc(){
        if(trangThai){
            trangThai = false;
            System.out.println("Trò Chơi Kết Thúc: " + tenTroChoi);
        }else {
            System.out.println("Trò Chơi Chưa Được Chơi");
        }
    }

    public void hienThiThongTin() {
        System.out.println("Tên trò chơi: " + tenTroChoi);
        System.out.println("Số lượt chơi: " + soLuotChoi);
        System.out.println("Trạng thái: " + (trangThai ? "Đang chơi" : "Không chơi"));
    }
}
