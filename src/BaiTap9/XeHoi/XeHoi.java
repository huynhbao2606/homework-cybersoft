package BaiTap9.XeHoi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XeHoi {
    private String hangSanXuat;
    private String mauSac;
    private String namSanXuat;

    public String thongTinXeHoi(){
        return "Hãng Sản Xuất: "  + this.hangSanXuat + "\n"
                + "Màu Sắc: " + this.mauSac + "\n"
                + "Năm Sản Xuất: " +  this.namSanXuat;
    }
}
