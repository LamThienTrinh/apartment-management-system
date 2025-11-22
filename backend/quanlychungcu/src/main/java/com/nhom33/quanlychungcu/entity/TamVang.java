package com.nhom33.quanlychungcu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TamVang")
public class TamVang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TamVang")
    private Integer id;

    @NotNull(message = "ID nhân khẩu không được để trống")
    @Column(name = "ID_NhanKhau", nullable = false)
    private Integer idNhanKhau;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    @Column(name = "NgayBatDau", nullable = false)
    private LocalDate ngayBatDau;

    @NotNull(message = "Ngày kết thúc không được để trống")
    @Column(name = "NgayKetThuc", nullable = false)
    private LocalDate ngayKetThuc;

    @Size(max = 255, message = "Nơi đến không được vượt quá 255 ký tự")
    @Column(name = "NoiDen", length = 255)
    private String noiDen;

    @Column(name = "LyDo", length = 255)
    private String lyDo;

    @Column(name = "NgayDangKy")
    private LocalDateTime ngayDangKy;

    //  Lifecycle Callbacks 
    
    @PrePersist
    protected void onCreate() {
        if (ngayDangKy == null) {
            ngayDangKy = LocalDateTime.now();
        }
    }

    //  Constructors 
    
    public TamVang() {
    }
    
    public TamVang(Integer idNhanKhau, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.idNhanKhau = idNhanKhau;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    //  Getter & Setter 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(Integer idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
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

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public LocalDateTime getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDateTime ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    //  Utility Methods 
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TamVang tamVang = (TamVang) o;
        return Objects.equals(id, tamVang.id) && 
               Objects.equals(idNhanKhau, tamVang.idNhanKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idNhanKhau);
    }

    @Override
    public String toString() {
        return "TamVang{" +
                "id=" + id +
                ", idNhanKhau=" + idNhanKhau +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", noiDen='" + noiDen + '\'' +
                ", ngayDangKy=" + ngayDangKy +
                '}';
    }
}
