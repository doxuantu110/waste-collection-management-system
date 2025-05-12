package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HOPDONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hopdong_seq")
    @SequenceGenerator(name = "hopdong_seq", sequenceName = "SEQHOPDONG", allocationSize = 1)
    @Column(name = "MAHOPDONG", nullable = false)
    private Long maHopDong;

    @ManyToOne
    @JoinColumn(name = "MACHUTHAI", nullable = false)
    private ChuThai chuThai;

    @ManyToOne
    @JoinColumn(name = "MADV", nullable = false)
    private DonViThuGom donViThuGom;

    @Column(name = "LOAIHOPDONG", length = 50)
    private String loaiHopDong;

    @Column(name = "NGBATDAU")
    @Temporal(TemporalType.DATE)
    private Date ngBatDau;

    @Column(name = "NGKETTHUC")
    @Temporal(TemporalType.DATE)
    private Date ngKetThuc;

    @Column(name = "GIATRI", precision = 15, scale = 2)
    private BigDecimal giaTri;

    @Column(name = "MOTA")
    @Lob
    private String moTa;

    @Column(name = "TRANGTHAI", length = 50)
    private String trangThai;

    @OneToMany(mappedBy = "hopDong")
    private List<HoaDon> hoaDons;

    // Getters and Setters
    public Long getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(Long maHopDong) {
        this.maHopDong = maHopDong;
    }

    public ChuThai getChuThai() {
        return chuThai;
    }

    public void setChuThai(ChuThai chuThai) {
        this.chuThai = chuThai;
    }

    public String getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(String loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    public Date getNgBatDau() {
        return ngBatDau;
    }

    public void setNgBatDau(Date ngBatDau) {
        this.ngBatDau = ngBatDau;
    }

    public Date getNgKetThuc() {
        return ngKetThuc;
    }

    public void setNgKetThuc(Date ngKetThuc) {
        this.ngKetThuc = ngKetThuc;
    }

    public BigDecimal getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(BigDecimal giaTri) {
        this.giaTri = giaTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public DonViThuGom getDonViThuGom() {
        return donViThuGom;
    }

    public void setDonViThuGom(DonViThuGom donViThuGom) {
        this.donViThuGom = donViThuGom;
    }
} 