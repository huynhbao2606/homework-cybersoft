package BaiTap11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    public void taoDuLieuGia() {
        // TruongPhong
        TruongPhong tp1 = new TruongPhong("TP01", "Lê Văn A", "0969026600", 12); // có nhân viên
        TruongPhong tp2 = new TruongPhong("TP02", "Lê Thị B", "0909000002", 20);     // có nhân viên
        TruongPhong tp3 = new TruongPhong("TP03", "Phan Văn C", "0909000010", 18);   // chưa có ai

        // NV
        // Phân bổ cho tp1
        NhanVien nv1 = new NhanVien("NV01", "Trần Văn C", "0909000003", 20);
        NhanVien nv2 = new NhanVien("NV02", "Phạm Thị D", "0909000004", 19);
        nv1.setTruongPhong(tp1);
        nv2.setTruongPhong(tp1);
        tp1.getNhanVien().add(nv1);
        tp1.getNhanVien().add(nv2);

        // Phân bổ cho tp2
        NhanVien nv3 = new NhanVien("NV03", "Hoàng Văn E", "0909000005", 18);
        NhanVien nv4 = new NhanVien("NV04", "Đỗ Thị F", "0909000006", 22);
        nv3.setTruongPhong(tp2);
        nv4.setTruongPhong(tp2);
        tp2.getNhanVien().add(nv3);
        tp2.getNhanVien().add(nv4);

        // NV chưa phân bổ
        NhanVien nv5 = new NhanVien("NV05", "Ngô Văn G", "0909000011", 21);
        NhanVien nv6 = new NhanVien("NV06", "Vũ Thị H", "0909000012", 19);

        // Giám Đốc
        GiamDoc gd1 = new GiamDoc("GD01", "Huỳnh Chí Bảo", "0969026600", 30, 50.0);
        GiamDoc gd2 = new GiamDoc("GD02", "Mai Thị H", "0909000008", 24, 40.0);
        gd1.setCongTy(this);
        gd2.setCongTy(this);

        nhanSu.add(tp1);
        nhanSu.add(tp2);
        nhanSu.add(tp3);

        nhanSu.add(nv1);
        nhanSu.add(nv2);
        nhanSu.add(nv3);
        nhanSu.add(nv4);
        nhanSu.add(nv5);
        nhanSu.add(nv6);

        nhanSu.add(gd1);
        nhanSu.add(gd2);

        System.out.println("Đã tạo dữ liệu giả!");
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

        //lay dsNhanVien chưa phân bổ
        List<NhanVien> dsNhanVien = getNhanSu().stream()
                .filter(ns -> ns instanceof NhanVien)
                .map(ns -> (NhanVien) ns)
                .filter(nv -> nv.getTruongPhong() == null)
                .toList();

        //lấy dsTruongPhong
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

        // Gán 2 bên TP NV
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

    private void themNhanSuMoi(Scanner sc) {
        System.out.println("\n--- THÊM NHÂN SỰ ---");
        System.out.println("1. Nhân viên thường");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Giám đốc");
        System.out.print("Chọn loại nhân sự: ");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Mã số: ");
        String maSo = sc.nextLine().trim();

        // tìm mã trùng
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
                System.out.printf("%d. [%s] %s - SĐT: %s - Ngày LV: %d - Trưởng phòng: %s\n",
                        stt++, nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai(), nv.getSoNgayLamViec(),
                        nv.getTruongPhong() != null ? nv.getTruongPhong().getHoTen() : "Chưa phân");
            }
        }

        stt = 1;
        System.out.println("\n--- Trưởng phòng ---");
        for (NhanSu ns : nhanSu) {
            if (ns instanceof TruongPhong tp) {
                System.out.printf("%d. [%s] %s - SĐT: %s - Ngày LV: %d - SL Nhân viên quản lý: %d\n",
                        stt++, tp.getMaSo(), tp.getHoTen(), tp.getSoDienThoai(), tp.getSoNgayLamViec(),
                        tp.getNhanVien().size());
            }
        }

        stt = 1;
        System.out.println("\n--- Giám đốc ---");
        for (NhanSu ns : nhanSu) {
            if (ns instanceof GiamDoc gd) {
                System.out.printf("%d. [%s] %s - SĐT: %s - Ngày LV: %d - Cổ phần: %.2f%%\n",
                        stt++, gd.getMaSo(), gd.getHoTen(), gd.getSoDienThoai(), gd.getSoNgayLamViec(),
                        gd.getCoPhan());
            }
        }

        System.out.println("========================================================");
    }



}
