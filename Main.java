package hangthucpham;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String line = "--------------------------------------------------------------------------------------------------";
        
        System.out.println("=== DANH SÁCH HÀNG THỰC PHẨM ===");
        System.out.println(line);
        System.out.println(HangThucPham.getTieuDe());
        System.out.println(line);

        // 1. Khởi tạo hợp lệ
        HangThucPham sp1 = new HangThucPham();
        System.out.println(sp1);

        try {
            HangThucPham sp2 = new HangThucPham("TP01", "Sữa tươi Vinamilk", LocalDate.of(2026, 8, 1), LocalDate.of(2026, 9, 15), 28000f);
            System.out.println(sp2);
        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi SP2: " + e.getMessage());
        }

        try {
            HangThucPham sp3 = new HangThucPham("TP02", "Mì gói Hảo Hảo", LocalDate.of(2026, 1, 10), LocalDate.of(2026, 7, 10), 4500f);
            System.out.println(sp3);
        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi SP3: " + e.getMessage());
        }

        System.out.println(line);

        // 2. Test thử trường hợp dữ liệu KHÔNG hợp lệ (bắt lỗi bằng try-catch)
        System.out.println("\n=== KIỂM THỬ XỬ LÝ LỖI (VALIDATION) ===");
        try {
            // Giá <= 0 -> Sẽ ném ra ngoại lệ
            HangThucPham spLoi = new HangThucPham("TP03", "Bánh mì", LocalDate.now(), LocalDate.now().plusDays(2), -1000f);
            System.out.println(spLoi);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Bắt lỗi thành công: " + e.getMessage());
        }
    }
}