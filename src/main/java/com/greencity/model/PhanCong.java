package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PHANCONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhanCong {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phancong_seq")
    @SequenceGenerator(name = "phancong_seq", sequenceName = "SEQPHANCONG", allocationSize = 1)
    @Column(name = "MAPC", nullable = false)
    private Long maPc;

    @ManyToOne
    @JoinColumn(name = "MANVDP", nullable = false)
    private NhanVienDieuPhoi nhanVienDieuPhoi;

    @ManyToOne
    @JoinColumn(name = "MALICH", nullable = false)
    private LichThuGom lichThuGom;

    @ManyToOne
    @JoinColumn(name = "MANVTG", nullable = false)
    private NhanVienThuGom nhanVienThuGom;

    // Getters and Setters
    public Long getMaPc() {
        return maPc;
    }

    public void setMaPc(Long maPc) {
        this.maPc = maPc;
    }

    public NhanVienDieuPhoi getNhanVienDieuPhoi() {
        return nhanVienDieuPhoi;
    }

    public void setNhanVienDieuPhoi(NhanVienDieuPhoi nhanVienDieuPhoi) {
        this.nhanVienDieuPhoi = nhanVienDieuPhoi;
    }

    public LichThuGom getLichThuGom() {
        return lichThuGom;
    }

    public void setLichThuGom(LichThuGom lichThuGom) {
        this.lichThuGom = lichThuGom;
    }

    public NhanVienThuGom getNhanVienThuGom() {
        return nhanVienThuGom;
    }

    public void setNhanVienThuGom(NhanVienThuGom nhanVienThuGom) {
        this.nhanVienThuGom = nhanVienThuGom;
    }
} 