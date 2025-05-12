package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TUYENDUONGTHUGOM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuyenDuongThuGom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tuyen_seq")
    @SequenceGenerator(name = "tuyen_seq", sequenceName = "SEQTUYEN", allocationSize = 1)
    @Column(name = "MATUYEN", nullable = false)
    private Long maTuyen;

    @ManyToOne
    @JoinColumn(name = "MADV", nullable = false)
    private DonViThuGom donViThuGom;

    @Column(name = "TENTUYEN", length = 100)
    private String tenTuyen;

    @Column(name = "KHUVUC", length = 100)
    private String khuVuc;

    @Column(name = "MOTA", length = 255)
    private String moTa;

    @Column(name = "TRANGTHAI", length = 50)
    private String trangThai;

    // Getters and Setters
    public Long getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(Long maTuyen) {
        this.maTuyen = maTuyen;
    }

    public DonViThuGom getDonViThuGom() {
        return donViThuGom;
    }

    public void setDonViThuGom(DonViThuGom donViThuGom) {
        this.donViThuGom = donViThuGom;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
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
} 