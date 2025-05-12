package com.greencity.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "phieu_thu_gom")
@Data
public class PhieuThuGom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_phieu")
    private Long maPhieu;

    @ManyToOne
    @JoinColumn(name = "ma_nvtg", nullable = false)
    private NhanVienThuGom nhanVienThuGom;

    @ManyToOne
    @JoinColumn(name = "ma_chu_thai", nullable = false)
    private ChuThai chuThai;

    @Column(name = "ng_thu_gom", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngThuGom;

    @Column(name = "khoi_luong", nullable = false)
    private Double khoiLuong;

    @Column(name = "loai_rac", nullable = false)
    private String loaiRac;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ghi_chu")
    private String ghiChu;

    // Getters and Setters
    public Long getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(Long maPhieu) {
        this.maPhieu = maPhieu;
    }

    public NhanVienThuGom getNhanVienThuGom() {
        return nhanVienThuGom;
    }

    public void setNhanVienThuGom(NhanVienThuGom nhanVienThuGom) {
        this.nhanVienThuGom = nhanVienThuGom;
    }

    public ChuThai getChuThai() {
        return chuThai;
    }

    public void setChuThai(ChuThai chuThai) {
        this.chuThai = chuThai;
    }

    public Date getNgThuGom() {
        return ngThuGom;
    }

    public void setNgThuGom(Date ngThuGom) {
        this.ngThuGom = ngThuGom;
    }

    public Double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(Double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getLoaiRac() {
        return loaiRac;
    }

    public void setLoaiRac(String loaiRac) {
        this.loaiRac = loaiRac;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
} 