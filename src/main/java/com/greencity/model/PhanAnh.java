package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "PHANANH")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhanAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phananh_seq")
    @SequenceGenerator(name = "phananh_seq", sequenceName = "SEQPHANANH", allocationSize = 1)
    @Column(name = "MAPA", nullable = false)
    private Long maPa;

    @ManyToOne
    @JoinColumn(name = "MACHUTHAI", nullable = false)
    private ChuThai chuThai;

    @Column(name = "NOIDUNG", nullable = false)
    @Lob
    private String noiDung;

    @Column(name = "THOIGIANGUI")
    @Temporal(TemporalType.DATE)
    private Date thoiGianGui;

    @Column(name = "TRANGTHAI", length = 50)
    private String trangThai;

    // Getters and Setters
    public Long getMaPa() {
        return maPa;
    }

    public void setMaPa(Long maPa) {
        this.maPa = maPa;
    }

    public ChuThai getChuThai() {
        return chuThai;
    }

    public void setChuThai(ChuThai chuThai) {
        this.chuThai = chuThai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(Date thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
} 