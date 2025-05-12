package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "YEUCAUDATLICH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YeuCauDatLich {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yeucaudatlich_seq")
    @SequenceGenerator(name = "yeucaudatlich_seq", sequenceName = "SEQYEUCAUDATLICH", allocationSize = 1)
    @Column(name = "MAYC", nullable = false)
    private Long maYc;

    @ManyToOne
    @JoinColumn(name = "MACHUTHAI", nullable = false)
    private ChuThai chuThai;

    @ManyToOne
    @JoinColumn(name = "MALICH", nullable = false)
    private LichThuGom lichThuGom;

    @Column(name = "THOIGIANYC")
    @Temporal(TemporalType.DATE)
    private Date thoiGianYc;

    @Column(name = "GHICHU")
    @Lob
    private String ghiChu;

    @Column(name = "TRANGTHAI", length = 50)
    private String trangThai;

    // Getters and Setters
    public Long getMaYc() {
        return maYc;
    }

    public void setMaYc(Long maYc) {
        this.maYc = maYc;
    }

    public ChuThai getChuThai() {
        return chuThai;
    }

    public void setChuThai(ChuThai chuThai) {
        this.chuThai = chuThai;
    }

    public LichThuGom getLichThuGom() {
        return lichThuGom;
    }

    public void setLichThuGom(LichThuGom lichThuGom) {
        this.lichThuGom = lichThuGom;
    }

    public Date getThoiGianYc() {
        return thoiGianYc;
    }

    public void setThoiGianYc(Date thoiGianYc) {
        this.thoiGianYc = thoiGianYc;
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