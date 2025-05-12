package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TTPHANLOAIRAC")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TtPhanLoaiRac {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loairac_seq")
    @SequenceGenerator(name = "loairac_seq", sequenceName = "SEQLOAIRAC", allocationSize = 1)
    @Column(name = "MALOAIRAC", nullable = false)
    private Long maLoaiRac;

    @Column(name = "TENLOAIRAC", length = 100)
    private String tenLoaiRac;

    @Column(name = "MOTA", length = 255)
    private String moTa;

    @Column(name = "HDPHANLOAI", length = 100)
    private String hdPhanLoai;

    @Column(name = "HINHANH")
    @Lob
    private byte[] hinhAnh;

    // Getters and Setters
    public Long getMaLoaiRac() {
        return maLoaiRac;
    }

    public void setMaLoaiRac(Long maLoaiRac) {
        this.maLoaiRac = maLoaiRac;
    }

    public String getTenLoaiRac() {
        return tenLoaiRac;
    }

    public void setTenLoaiRac(String tenLoaiRac) {
        this.tenLoaiRac = tenLoaiRac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHdPhanLoai() {
        return hdPhanLoai;
    }

    public void setHdPhanLoai(String hdPhanLoai) {
        this.hdPhanLoai = hdPhanLoai;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
} 