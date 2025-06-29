package BaiTap11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CongTy {
    private String tenCongTy;
    private String maSoThue;
    private double doanhThuThang;
    private ArrayList<NhanSu> nhanSu = new ArrayList<>();

    public void taoDuLieuGia(CongTy congTy) {
        TruongPhong tp1 = new TruongPhong("TP01", "Lê Văn Anh", "0901000001", 20);
        TruongPhong tp2 = new TruongPhong("TP02", "Nguyễn Minh Tuấn", "0901000002", 22);
        TruongPhong tp3 = new TruongPhong("TP03", "Trần Quốc Việt", "0901000003", 21);
        TruongPhong tp4 = new TruongPhong("TP04", "Phạm Thanh Hùng", "0901000004", 19);
        TruongPhong tp5 = new TruongPhong("TP05", "Đỗ Thị Thảo", "0901000005", 18);

        congTy.getNhanSu().add(tp1);
        congTy.getNhanSu().add(tp2);
        congTy.getNhanSu().add(tp3);
        congTy.getNhanSu().add(tp4);
        congTy.getNhanSu().add(tp5);


        NhanVien[] nvs = {
                new NhanVien("NV01", "Nguyễn Thị Mai", "0911000001", 22),
                new NhanVien("NV02", "Trần Văn Hùng", "0911000002", 21),
                new NhanVien("NV03", "Phạm Thị Hương", "0911000003", 20),
                new NhanVien("NV04", "Lê Công Thành", "0911000004", 19),
                new NhanVien("NV05", "Đặng Thị Tuyết", "0911000005", 18),
                new NhanVien("NV06", "Vũ Minh Quang", "0911000006", 20),
                new NhanVien("NV07", "Hoàng Thị Bích", "0911000007", 21),
                new NhanVien("NV08", "Ngô Quang Khải", "0911000008", 22),
                new NhanVien("NV09", "Bùi Thị Lan", "0911000009", 23),
                new NhanVien("NV10", "Lý Quốc Tuấn", "0911000010", 20),
                new NhanVien("NV11", "Đinh Thị Hồng", "0911000011", 19),
                new NhanVien("NV12", "Nguyễn Văn Hiếu", "0911000012", 22),
                new NhanVien("NV13", "Trần Thị Ngọc", "0911000013", 20),
                new NhanVien("NV14", "Phạm Văn An", "0911000014", 21),
                new NhanVien("NV15", "Lê Thị Mỹ", "0911000015", 22),
                new NhanVien("NV16", "Đỗ Minh Châu", "0911000016", 20),
                new NhanVien("NV17", "Vũ Thị Trang", "0911000017", 21),
                new NhanVien("NV18", "Hoàng Văn Phúc", "0911000018", 22),
                new NhanVien("NV19", "Ngô Minh Tú", "0911000019", 23),
                new NhanVien("NV20", "Bùi Thị Kiều", "0911000020", 20),
                new NhanVien("NV21", "Tống Thị Hà", "0911000021", 20),
                new NhanVien("NV22", "Trịnh Văn Cường", "0911000022", 21),
                new NhanVien("NV23", "Nguyễn Hữu Đạt", "0911000023", 19),
                new NhanVien("NV24", "Phạm Thị Yến", "0911000024", 22),
                new NhanVien("NV25", "Lê Quốc Huy", "0911000025", 20)
        };

        TruongPhong[] tps = {tp1, tp2, tp3, tp4, tp5};

        for (int i = 0; i < 20; i++) {
            NhanVien nv = nvs[i];
            TruongPhong tp = tps[i % tps.length];
            nv.setTruongPhong(tp);
            tp.getNhanVien().add(nv);
            congTy.getNhanSu().add(nv);
        }

        for (int i = 20; i < nvs.length; i++) {
            congTy.getNhanSu().add(nvs[i]);
        }

        GiamDoc gd1 = new GiamDoc("GD01", "Huỳnh Chí Bảo", "0988000001", 30, 25.0);
        GiamDoc gd2 = new GiamDoc("GD02", "Mai Thị Hạnh", "0988000002", 25, 20.0);
        GiamDoc gd3 = new GiamDoc("GD03", "Lê Minh Khoa", "0988000003", 28, 15.0);
        GiamDoc gd4 = new GiamDoc("GD04", "Nguyễn Hữu Nhân", "0988000004", 27, 25.0);
        GiamDoc gd5 = new GiamDoc("GD05", "Trần Quốc Đạt", "0988000005", 26, 15.0);

        gd1.setCongTy(congTy);
        gd2.setCongTy(congTy);
        gd3.setCongTy(congTy);
        gd4.setCongTy(congTy);
        gd5.setCongTy(congTy);

        congTy.getNhanSu().add(gd1);
        congTy.getNhanSu().add(gd2);
        congTy.getNhanSu().add(gd3);
        congTy.getNhanSu().add(gd4);
        congTy.getNhanSu().add(gd5);

        System.out.println("\nĐã tạo dữ liệu giả!!!");
    }


    public void nhapThongTinCongTy(Scanner sc) {
        System.out.println("\n--- Nhập thông tin công ty ---");

        System.out.print("Tên công ty: ");
        tenCongTy = sc.nextLine();

        System.out.print("Mã số thuế: ");
        maSoThue = sc.nextLine();

        System.out.print("Doanh thu tháng: ");
        while (true) {
            try {
                doanhThuThang = Double.parseDouble(sc.nextLine());
                if (doanhThuThang < 0) {
                    System.out.println("Doanh thu không được âm. Vui long nhập lại:");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Nhập lại doanh thu:");
            }
        }

        System.out.println("Nhập thông tin công ty thành công.");
    }

    public void phanBoNhanVienChoTruongPhong(Scanner sc) {

        List<NhanVien> dsNhanVien = getNhanSu().stream()
                .filter(ns -> ns instanceof NhanVien)
                .map(ns -> (NhanVien) ns)
                .filter(nv -> nv.getTruongPhong() == null)
                .toList();

        List<TruongPhong> dsTruongPhong = getNhanSu().stream()
                .filter(ns -> ns instanceof TruongPhong)
                .map(ns -> (TruongPhong) ns)
                .toList();

        if (dsNhanVien.isEmpty()) {
            System.out.println("Không có nhân viên nào chưa phân bổ.");
            return;
        }

        if (dsTruongPhong.isEmpty()) {
            System.out.println("Không có trưởng phòng nào để phân bổ.");
            return;
        }

        System.out.println("\n--- Danh sách Nhân viên chưa phân bổ ---");
        for (int i = 0; i < dsNhanVien.size(); i++) {
            System.out.printf("%d. %s (Mã: %s)\n", i + 1, dsNhanVien.get(i).getHoTen(), dsNhanVien.get(i).getMaSo());
        }

        System.out.print("Nhập số thứ tự nhân viên cần phân bổ: ");
        int nvIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (nvIndex < 0 || nvIndex >= dsNhanVien.size()) {
            System.out.println("Lựa chọn nhân viên không hợp lệ.");
            return;
        }

        NhanVien nvChon = dsNhanVien.get(nvIndex);

        System.out.println("\n--- Danh sách Trưởng phòng ---");
        for (int i = 0; i < dsTruongPhong.size(); i++) {
            System.out.printf("%d. %s (Mã: %s)\n", i + 1, dsTruongPhong.get(i).getHoTen(), dsTruongPhong.get(i).getMaSo());
        }

        System.out.print("Nhập số thứ tự trưởng phòng để thêm nhân viên: ");
        int tpIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (tpIndex < 0 || tpIndex >= dsTruongPhong.size()) {
            System.out.println("Lựa chọn trưởng phòng không hợp lệ.");
            return;
        }

        TruongPhong tpChon = dsTruongPhong.get(tpIndex);

        nvChon.setTruongPhong(tpChon);
        tpChon.getNhanVien().add(nvChon);

        System.out.printf("phân bổ nhân viên %s cho trưởng phòng %s.\n", nvChon.getHoTen(), tpChon.getHoTen());
    }

    public void themHoacXoaNhanSu(Scanner sc) {
        System.out.println("\n--- THÊM / XÓA NHÂN SỰ ---");
        System.out.println("1. Thêm nhân sự");
        System.out.println("2. Xóa nhân sự theo mã số");
        System.out.print("→ Nhập lựa chọn của bạn: ");
        int luaChon = Integer.parseInt(sc.nextLine());

        switch (luaChon) {
            case 1 -> themNhanSuMoi(sc);
            case 2 -> xoaNhanSuTheoMa(sc);
            default -> System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public void tinhVaXuatTongLuong(){
        System.out.println("\n======= TÍNH LƯƠNG TOÀN CÔNG TY =======");

        double tongLuong = 0;
        int stt = 1;

        for (NhanSu ns : nhanSu) {
            double luong = ns.tinhLuong();
            System.out.printf("%d. [%s] %s - Lương: %.2f\n",
                    stt++, ns.getMaSo(), ns.getHoTen(), luong);
            tongLuong += luong;
        }

        System.out.printf("\nTổng lương toàn công ty: %.2f\n", tongLuong);
        System.out.println("========================================");
    }

    public void timNhanVienLuongCaoNhat() {
        System.out.println("\n======= NHÂN VIÊN CÓ LƯƠNG CAO NHẤT =======");

        double maxLuong = -1;
        List<NhanVien> topNhanVien = new ArrayList<>();

        for (NhanSu ns : nhanSu) {
            if(ns instanceof NhanVien nv) {
                double luong = ns.tinhLuong();
                if (luong > maxLuong) {
                    maxLuong = luong;
                    topNhanVien.clear();
                    topNhanVien.add(nv);
                }else if(luong == maxLuong) {
                    topNhanVien.add(nv);
                }
            }
        }

        if(topNhanVien.isEmpty()){
            System.out.println("Không có nhân viên nào trong công ty.");
        }

        System.out.printf("Lương cao nhất: %.2f\n", maxLuong);

        for (int i = 0; i< topNhanVien.size(); i++){
            NhanVien nv = topNhanVien.get(i);
            System.out.printf("%d. [%s] %s - SĐT: %s - Ngày làm: %d\n",
                    i + 1, nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai(), nv.getSoNgayLamViec());
        }

        System.out.println("============================================");
    }

    public void timTruongPhongQuanLyNhieuNhanVienNhat(){
        System.out.println("\n======= TRƯỞNG PHÒNG QUẢN LÝ NHIỀU NHÂN VIÊN NHẤT =======");

        int maxSoLuong = -1;
        List<TruongPhong> topTP = new ArrayList<>();

        for (NhanSu ns : nhanSu) {
            if(ns instanceof TruongPhong tp) {
                int soLuong = tp.getNhanVien().size();
                if (soLuong > maxSoLuong) {
                    maxSoLuong = soLuong;
                    topTP.clear();
                    topTP.add(tp);
                } else if (soLuong == maxSoLuong) {
                    topTP.add(tp);
                }
            }
        }

        if(topTP.isEmpty()){
            System.out.println("Không có trưởng phòng nào trong công ty.");
        }

        System.out.printf("Số lượng nhân viên dưới quyền nhiều nhất: %d\n", maxSoLuong);
        for(int i = 0; i < topTP.size(); i++){
            TruongPhong tp = topTP.get(i);
            System.out.printf("%d. [%s] %s - SĐT: %s - Ngày làm: %d - Số lượng NV: %d\n",
                    i + 1, tp.getMaSo(), tp.getHoTen(), tp.getSoDienThoai(), tp.getSoNgayLamViec(), tp.getNhanVien().size());

        }

        System.out.println("==========================================================");
    }

    public void sapXepNhanVienTheoABC(){
        System.out.println("\n======= DANH SÁCH NHÂN SỰ THEO THỨ TỰ TÊN =======");

        List<NhanSu> sortNhanSu = new ArrayList<>(nhanSu);

        sortNhanSu.sort(Comparator.comparing(ns -> ns.getHoTen().toLowerCase()));

        int stt = 1;

        for (NhanSu ns : sortNhanSu) {
            String loai = ns instanceof NhanVien ? "Nhân Viên"
                    : ns instanceof TruongPhong ? "Trưởng Phòng"
                    : "Giám Đốc";

            System.out.printf("%d. [%s] %s - (%s)\n", stt++, ns.getMaSo(), ns.getHoTen(), loai);
        }

        System.out.println("====================================================");
    }

    public void sapXepNhanSuTheoLuongGiamDan(){
        System.out.println("\n======= DANH SÁCH NHÂN SỰ THEO LƯƠNG GIẢM DẦN =======");

        List<NhanSu> sortNhanSu = new ArrayList<>(nhanSu);

        sortNhanSu.sort((a,b) -> Double.compare(b.tinhLuong(), a.tinhLuong()));

        int stt = 1;
        for (NhanSu ns : sortNhanSu) {
            String loai = ns instanceof NhanVien ? "Nhân Viên"
                    : ns instanceof TruongPhong ? "Trưởng Phòng"
                    : "Giám Đốc";


            System.out.printf("%d. [%s] %s - Lương: %.2f - (%s)\n",
                    stt++, ns.getMaSo(), ns.getHoTen(), ns.tinhLuong(), loai);
        }

        System.out.println("======================================================");

    }

    public void timGiamDocCoCoPhanNhieuNhat(){
        System.out.println("\n======= GIÁM ĐỐC CÓ CỔ PHẦN CAO NHẤT =======");

        List<GiamDoc> giamDoc = nhanSu.stream()
                .filter(ns -> ns instanceof GiamDoc)
                .map(ns -> (GiamDoc) ns)
                .toList();

        if(giamDoc.isEmpty()){
            System.out.println("Không có giám đốc nào trong công ty.");
        }

        double maxCoPhan = giamDoc.stream()
                .mapToDouble(GiamDoc::getCoPhan)
                .max()
                .orElse(0);

        List<GiamDoc> topGD = giamDoc.stream()
                .filter(gd -> gd.getCoPhan() == maxCoPhan)
                .toList();


        System.out.printf("Mức cổ phần cao nhất: %.2f%%\n", maxCoPhan);

        int stt = 1;
        for (GiamDoc gd : topGD) {
            System.out.printf("%d. [%s] %s - SĐT: %s - Ngày làm: %d - Cổ phần: %.2f%%\n",
                    stt++, gd.getMaSo(), gd.getHoTen(), gd.getSoDienThoai(),
                    gd.getSoNgayLamViec(), gd.getCoPhan());
        }

        System.out.println("=============================================");
    }

    public void tinhVaXuatThuNhapCuaGiamDoc(){
        System.out.println("\n======= THU NHẬP CỦA CÁC GIÁM ĐỐC =======");

        List<GiamDoc> giamDoc = getNhanSu().stream()
                .filter(ns -> ns instanceof GiamDoc)
                .map(ns  -> (GiamDoc) ns)
                .toList();

        double tongLuongCongTy = 0;

        double tongLuong = nhanSu.stream().mapToDouble(NhanSu::tinhLuong).sum();
        double loiNhuanCongTy = doanhThuThang - tongLuong;

        if(giamDoc.isEmpty()){
            System.out.println("Không có giám đốc nào trong công ty.");
        }

        int stt = 1;
        for (GiamDoc gd : giamDoc) {
            double luong = gd.tinhLuong();
            double thuNhap = luong + gd.getCoPhan() * loiNhuanCongTy;

            System.out.printf("%d. Lợi Nhuân Công Ty: [%.2f] [%s] %s - Lương: %.2f - Cổ phần: %.2f%% → Tổng thu nhập: %.2f\n",
                    stt++, loiNhuanCongTy, gd.getMaSo(), gd.getHoTen(), luong, gd.getCoPhan(), thuNhap);
        }
    }

    private void themNhanSuMoi(Scanner sc) {
        System.out.println("\n--- THÊM NHÂN SỰ ---");
        System.out.println("1. Nhân viên thường");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Giám đốc");
        System.out.print("Chọn loại nhân sự: ");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Mã số: ");
        String maSo = sc.nextLine().trim();

        if (nhanSu.stream().anyMatch(ns -> ns.getMaSo().equalsIgnoreCase(maSo))) {
            System.out.println("Mã số đã tồn tại!");
            return;
        }

        System.out.print("Họ tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Số điện thoại: ");
        String sdt = sc.nextLine();
        System.out.print("Số ngày làm việc: ");
        int soNgay = Integer.parseInt(sc.nextLine());

        NhanSu nsMoi;

        switch (loai) {
            case 1 -> nsMoi = new NhanVien(maSo, hoTen, sdt, soNgay);
            case 2 -> nsMoi = new TruongPhong(maSo, hoTen, sdt, soNgay);
            case 3 -> {
                System.out.print("Cổ phần (%): ");
                double coPhan = Double.parseDouble(sc.nextLine());

                double coPhanHienTai = nhanSu.stream()
                        .filter(ns -> ns instanceof GiamDoc)
                        .mapToDouble(ns -> ((GiamDoc) ns).getCoPhan())
                        .sum();

                if(coPhanHienTai + coPhan > 100){
                    System.out.println("Cổ phần hiện tại là %.2f%%. Nếu thêm sẽ vượt quá 100% cố phần!!!");
                }

                nsMoi = new GiamDoc(maSo, hoTen, sdt, soNgay, coPhan);
                ((GiamDoc) nsMoi).setCongTy(this);
            }
            default -> {
                System.out.println("Xoá nhân sự không hợp lệ.");
                return;
            }
        }

        nhanSu.add(nsMoi);
        System.out.println("Đã thêm nhân sự: " + hoTen);
    }

    private void xoaNhanSuTheoMa(Scanner sc) {
        System.out.println("\n--- Danh sách nhân sự đã có ---");
        for (NhanSu ns : nhanSu) {
            System.out.printf("[%s] %s - %s\n", ns.getMaSo(), ns.getHoTen(), ns.getClass().getSimpleName());
        }

        System.out.print("Nhập mã số nhân sự cần xóa: ");
        String maSo = sc.nextLine().trim();

        NhanSu ns = nhanSu.stream()
                .filter(n -> n.getMaSo().equalsIgnoreCase(maSo))
                .findFirst().orElse(null);

        if (ns == null) {
            System.out.println("Không tìm thấy nhân sự có mã: " + maSo);
            return;
        }

        // Nếu là nhân viên gỡ trưởng phòng
        if (ns instanceof NhanVien nv) {
            TruongPhong tp = nv.getTruongPhong();
            if (tp != null) {
                tp.getNhanVien().remove(nv);
            }
        }

        // Nếu là trưởng phòng gỡ tất cả nhân viên
        if (ns instanceof TruongPhong tp) {
            for (NhanVien nv : tp.getNhanVien()) {
                nv.setTruongPhong(null);
            }
            tp.getNhanVien().clear();
        }

        nhanSu.remove(ns);
        System.out.println("Đã xóa nhân sự: " + ns.getHoTen());
    }

    public void xuatThongTinToanBoNhanSu() {
        System.out.println("\n======= DANH SÁCH TOÀN BỘ NHÂN SỰ TRONG CÔNG TY =======");

        int stt = 1;

        System.out.println("\n--- Nhân viên thường ---");
        for (NhanSu ns : nhanSu) {
            if (ns instanceof NhanVien nv) {
                System.out.printf("%d. [%s] %s - SĐT: %s - Ngày Làm Việc: %d - Trưởng phòng: %s\n",
                        stt++, nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai(), nv.getSoNgayLamViec(),
                        nv.getTruongPhong() != null ? nv.getTruongPhong().getHoTen() : "Chưa phân");
            }
        }

        stt = 1;
        System.out.println("\n--- Trưởng phòng ---");
        for (NhanSu ns : nhanSu) {
            if (ns instanceof TruongPhong tp) {
                System.out.printf("%d. [%s] %s - SĐT: %s - Ngày Ngày Làm Việc: %d - SL Nhân viên quản lý: %d\n",
                        stt++, tp.getMaSo(), tp.getHoTen(), tp.getSoDienThoai(), tp.getSoNgayLamViec(),
                        tp.getNhanVien().size());
            }
        }

        stt = 1;
        System.out.println("\n--- Giám đốc ---");
        for (NhanSu ns : nhanSu) {
            if (ns instanceof GiamDoc gd) {
                System.out.printf("%d. [%s] %s - SĐT: %s - Ngày Làm Việc1: %d - Cổ phần: %.2f%%\n",
                        stt++, gd.getMaSo(), gd.getHoTen(), gd.getSoDienThoai(), gd.getSoNgayLamViec(),
                        gd.getCoPhan());
            }
        }

        System.out.println("========================================================");
    }
}
