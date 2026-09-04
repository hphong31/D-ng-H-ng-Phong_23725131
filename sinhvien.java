package tuan2;

	import java.util.Scanner;

	public class sinhvien {
	    private int maSV;
	    private String hoTen;
	    private float diemLT, diemTH;

	    public int getMaSV() {
	        return maSV;
	    }

	    public void setMaSV(int ma) throws Exception {
	        if (ma > 0) {
	            this.maSV = ma;
	        } else {
	            throw new Exception("Loi ma SV");
	        }
	    }

	    public String getHoTen() {
	        return hoTen;
	    }

	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }

	    public float getDiemLT() {
	        return diemLT;
	    }

	    public void setDiemLT(float diemLT) {
	        this.diemLT = diemLT;
	    }

	    public float getDiemTH() {
	        return diemTH;
	    }

	    public void setDiemTH(float diemTH) {
	        this.diemTH = diemTH;
	    }

	    public sinhvien() {
	        this.maSV = 1;
	        this.hoTen = "Chua co";
	        this.diemLT = 0.0f;
	        this.diemTH = 0.0f;
	    }

	    public sinhvien(int ms, String hoten, float diemLT, float diemTH) throws Exception {
	        if (ms > 0) {
	            this.maSV = ms;
	        } else {
	            throw new Exception("Loi ma SV");
	        }
	        this.hoTen = hoten;
	        this.diemLT = diemLT;
	        this.diemTH = diemTH;
	    }

	    public double getDiemTB() {
	        return (getDiemLT() + getDiemTH()) / 2;
	    }

	    public static final void tieuDe() {
	        for (int i = 0; i < 76; i++) {
	            System.out.printf("-");
	        }
	        System.out.println();
	        String s = "";
	        s = s + String.format("%-10s | %-20s | %-10s | %-10s | %-10s |", "Ma sinh vien", "Ho ten", "Diem LT", "Diem TH", "Diem TB");
	        System.out.println(s);
	        for (int i = 0; i < 76; i++) {
	            System.out.printf("-");
	        }
	        System.out.println();
	    }

	    @Override
	    public String toString() {
	        String s = "";
	        s = s + String.format("%-10s   | %-20s | %-10.1f | %-10.1f | %-10.1f |", getMaSV(), getHoTen(), getDiemLT(), getDiemTH(), getDiemTB());
	        return s;
	    }

	    public static sinhvien nhap() throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int maSV;
	        String hoTen;
	        float diemLT, diemTH;
	        System.out.println("Nhap ma sinh vien:");
	        maSV = sc.nextInt();
	        sc.nextLine();
	        System.out.println("Nhap ho ten:");
	        hoTen = sc.nextLine();
	        System.out.println("Nhap diem LT:");
	        diemLT = sc.nextFloat();
	        System.out.println("Nhap diem TH:");
	        diemTH = sc.nextFloat();
	        sinhvien s = new sinhvien(maSV, hoTen, diemLT, diemTH);
	        return s;
	    }

	    public static void xuat(sinhvien s) {
	        tieuDe();
	        System.out.println(s.toString());
	    }

	    public static void main(String[] args) throws Exception {
	        tieuDe();
	        sinhvien s1 = new sinhvien(2, "Tran Thu Suong", 7, 9);
	        System.out.println(s1.toString());
	        System.out.println("Nhap tu ban phim");
	        tieuDe();
	xuat(nhap());
	    }
	}

