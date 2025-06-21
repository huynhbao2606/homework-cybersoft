package BaiTap9.DieuHoaMaySay;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DieuHoa extends ThietBiDien{
    private String cheDo;

    public DieuHoa(String ten, double congSuat, String chucNang, String cheDo) {
        super(ten,congSuat,chucNang);
        this.cheDo = cheDo;
    }

    @Override
    public void xuatThongTin(){
        System.out.println("Điều Hoà");
        super.xuatThongTin();
        System.out.println("Chế độ: " + cheDo);
    }

    @Override
    public void trangThai(){
        System.out.println("Bật Làm Lạnh: " + cheDo);
    }
}
