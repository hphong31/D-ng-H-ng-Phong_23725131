package hangthucpham;
import java.time.LocalDate;
public class HangThucPham {
	// Khai báo thuộc tính
    private int id;
    private String maHang = "";
    private String tenHang;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private float gia;
    private static int demSoLuong = 0;

    // Constructor mặc định
    public HangThucPham() {
        this.id = ++demSoLuong;
        this.maHang = "MAC_DINH";
        this.tenHang = "Hàng mặc định";
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = LocalDate.now().plusDays(7);
        this.gia = 1.0f;
    }

    // Phương thức kiểm tra ngày
    private boolean kiemTraNgaySanXuat(LocalDate ngaySX) {
        return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
    }

    private boolean kiemTraNgayHetHan(LocalDate ngaySX, LocalDate ngayHH) {
        return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
    }

    // Constructor có tham số
    public HangThucPham(String maHang, String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) {
        this.id = ++demSoLuong;

        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống!");
        }
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được để trống!");
        }
        if (gia <= 0) {
            throw new IllegalArgumentException("Giá phải lớn hơn 0!");
        }
        if (!kiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày sản xuất không được là ngày trong tương lai!");
        }
        if (!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất!");
        }

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.gia = gia;
    }

    // Getters
    public int getId() { return id; }
    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public LocalDate getNgaySanXuat() { return ngaySanXuat; }
    public LocalDate getNgayHetHan() { return ngayHetHan; }
    public float getGia() { return gia; }

    // Phương thức kiểm tra hàng đã hết hạn chưa
    public boolean isHetHan() {
        return LocalDate.now().isAfter(this.ngayHetHan);
    }
 // In tiêu đề cột dạng bảng
    public static String getTieuDe() {
        return String.format("| %-4s | %-10s | %-20s | %-12s | %-12s | %-12s | %-10s |", 
                "ID", "Mã hàng", "Tên hàng", "Ngày SX", "Ngày HH", "Đơn giá", "Trạng thái");
    }

    // Định dạng dữ liệu thành dòng bảng đẹp mắt
    @Override
    public String toString() {
        String trangThai = isHetHan() ? "Hết hạn" : "Còn hạn";
        return String.format("| %-4d | %-10s | %-20s | %-12s | %-12s | %,12.1f | %-10s |", 
                id, maHang, tenHang, ngaySanXuat, ngayHetHan, gia, trangThai);
    }
}
