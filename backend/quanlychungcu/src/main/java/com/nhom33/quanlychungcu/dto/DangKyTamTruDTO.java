package com.nhom33.quanlychungcu.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * DTO cho việc Đăng ký Tạm trú.
 * 
 * LOGIC NGHIỆP VỤ:
 * - Tạm trú = Người từ nơi khác đến ở tạm tại hộ gia đình.
 * - Bắt buộc: Người tạm trú PHẢI được insert vào bảng NhanKhau trước.
 * - Sau đó mới lưu thông tin giấy tờ vào bảng TamTru.
 * 
 * QUY TRÌNH XỬ LÝ (Transaction):
 * 1. Insert NhanKhau với TrangThai = "Tạm trú"
 * 2. Insert TamTru liên kết với NhanKhau vừa tạo
 */
public class DangKyTamTruDTO {

    // ========== THÔNG TIN HỘ GIA ĐÌNH ==========
    
    @NotNull(message = "ID hộ gia đình không được để trống")
    private Integer hoGiaDinhId;

    // ========== THÔNG TIN CÁ NHÂN NGƯỜI TẠM TRÚ ==========

    @NotBlank(message = "Họ tên không được để trống")
    @Size(max = 100, message = "Họ tên không được vượt quá 100 ký tự")
    private String hoTen;

    @NotBlank(message = "Số CCCD không được để trống")
    @Pattern(regexp = "^[0-9]{12}$", message = "Số CCCD phải có đúng 12 chữ số")
    private String soCCCD;

    @NotNull(message = "Ngày sinh không được để trống")
    @PastOrPresent(message = "Ngày sinh không được là ngày trong tương lai")
    private LocalDate ngaySinh;

    @NotBlank(message = "Giới tính không được để trống")
    @Pattern(regexp = "^(Nam|Nữ)$", message = "Giới tính phải là 'Nam' hoặc 'Nữ'")
    private String gioiTinh;

    @Pattern(regexp = "^(0[0-9]{9,10})?$", message = "Số điện thoại không hợp lệ")
    private String soDienThoai;

    @Email(message = "Email không hợp lệ")
    @Size(max = 100, message = "Email không được vượt quá 100 ký tự")
    private String email;

    /**
     * Quan hệ với chủ hộ (ví dụ: Họ hàng, Bạn bè, Người thuê...).
     */
    @NotBlank(message = "Quan hệ với chủ hộ không được để trống")
    @Size(max = 50, message = "Quan hệ với chủ hộ không được vượt quá 50 ký tự")
    private String quanHeVoiChuHo;

    // ========== THÔNG TIN GIẤY TẠM TRÚ ==========

    /**
     * Địa chỉ thường trú (nơi đăng ký hộ khẩu gốc).
     */
    @NotBlank(message = "Địa chỉ thường trú không được để trống")
    @Size(max = 200, message = "Địa chỉ không được vượt quá 200 ký tự")
    private String diaChiThuongTru;

    /**
     * Mã giấy tạm trú (nếu có - do cơ quan cấp).
     */
    @Size(max = 50, message = "Mã giấy tạm trú không được vượt quá 50 ký tự")
    private String maGiayTamTru;

    @NotNull(message = "Ngày bắt đầu tạm trú không được để trống")
    private LocalDate ngayBatDau;

    /**
     * Ngày hết hạn tạm trú (có thể null nếu chưa xác định).
     * Nếu có, phải sau ngày bắt đầu.
     */
    private LocalDate ngayKetThuc;

    @NotBlank(message = "Lý do tạm trú không được để trống")
    @Size(max = 500, message = "Lý do không được vượt quá 500 ký tự")
    private String lyDo;

    // ========== Constructors ==========

    public DangKyTamTruDTO() {
    }

    // ========== Getters & Setters ==========

    public Integer getHoGiaDinhId() {
        return hoGiaDinhId;
    }

    public void setHoGiaDinhId(Integer hoGiaDinhId) {
        this.hoGiaDinhId = hoGiaDinhId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }

    public String getMaGiayTamTru() {
        return maGiayTamTru;
    }

    public void setMaGiayTamTru(String maGiayTamTru) {
        this.maGiayTamTru = maGiayTamTru;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}
