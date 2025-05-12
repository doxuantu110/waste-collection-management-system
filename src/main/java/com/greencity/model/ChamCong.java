package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "CHAMCONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChamCong {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamcong_seq")
    @SequenceGenerator(name = "chamcong_seq", sequenceName = "SEQCHAMCONG", allocationSize = 1)
    @Column(name = "MACC", nullable = false)
    private Long maCc;

    @ManyToOne
    @JoinColumn(name = "MANVDP", nullable = false)
    private NhanVienDieuPhoi nhanVienDieuPhoi;

    @ManyToOne
    @JoinColumn(name = "MANVTG", nullable = false)
    private NhanVienThuGom nhanVienThuGom;

    @Column(name = "NGAYCONG")
    @Temporal(TemporalType.DATE)
    private Date ngayCong;

    @Column(name = "GHICHU", length = 255)
    private String ghiChu;

    @Column(name = "TRANGTHAI", length = 20)
    private String trangThai;

    // Getters and Setters
    public Long getMaCc() {
        return maCc;
    }

    public void setMaCc(Long maCc) {
        this.maCc = maCc;
    }

    public NhanVienDieuPhoi getNhanVienDieuPhoi() {
        return nhanVienDieuPhoi;
    }

    public void setNhanVienDieuPhoi(NhanVienDieuPhoi nhanVienDieuPhoi) {
        this.nhanVienDieuPhoi = nhanVienDieuPhoi;
    }

    public NhanVienThuGom getNhanVienThuGom() {
        return nhanVienThuGom;
    }

    public void setNhanVienThuGom(NhanVienThuGom nhanVienThuGom) {
        this.nhanVienThuGom = nhanVienThuGom;
    }

    public Date getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(Date ngayCong) {
        this.ngayCong = ngayCong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
} 