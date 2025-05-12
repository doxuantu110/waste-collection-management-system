package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "LICHTHUGOM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LichThuGom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lichthugom_seq")
    @SequenceGenerator(name = "lichthugom_seq", sequenceName = "SEQLICHTHUGOM", allocationSize = 1)
    @Column(name = "MALICH", nullable = false)
    private Long maLich;

    @ManyToOne
    @JoinColumn(name = "MANVDP", nullable = false)
    private NhanVienDieuPhoi nhanVienDieuPhoi;

    @Column(name = "NGTHU", length = 20)
    private String ngThu;

    @Column(name = "GIOTHU", length = 5)
    private String gioThu;

    @Column(name = "TRANGTHAI", length = 50)
    private String trangThai;

    @OneToMany(mappedBy = "lichThuGom")
    private List<YeuCauDatLich> yeuCauDatLichs;

    @OneToMany(mappedBy = "lichThuGom")
    private List<PhanCong> phanCongs;

    // Getters and Setters
    public Long getMaLich() {
        return maLich;
    }

    public void setMaLich(Long maLich) {
        this.maLich = maLich;
    }

    public NhanVienDieuPhoi getNhanVienDieuPhoi() {
        return nhanVienDieuPhoi;
    }

    public void setNhanVienDieuPhoi(NhanVienDieuPhoi nhanVienDieuPhoi) {
        this.nhanVienDieuPhoi = nhanVienDieuPhoi;
    }

    public String getNgThu() {
        return ngThu;
    }

    public void setNgThu(String ngThu) {
        this.ngThu = ngThu;
    }

    public String getGioThu() {
        return gioThu;
    }

    public void setGioThu(String gioThu) {
        this.gioThu = gioThu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<YeuCauDatLich> getYeuCauDatLichs() {
        return yeuCauDatLichs;
    }

    public void setYeuCauDatLichs(List<YeuCauDatLich> yeuCauDatLichs) {
        this.yeuCauDatLichs = yeuCauDatLichs;
    }

    public List<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(List<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }
} 