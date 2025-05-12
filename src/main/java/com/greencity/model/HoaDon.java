package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "HOADON")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hoadon_seq")
    @SequenceGenerator(name = "hoadon_seq", sequenceName = "SEQHOADON", allocationSize = 1)
    @Column(name = "MAHOADON", nullable = false)
    private Long maHoaDon;

    @ManyToOne
    @JoinColumn(name = "MAHOPDONG", nullable = false)
    private HopDong hopDong;

    @ManyToOne
    @JoinColumn(name = "MACHUTHAI")
    private ChuThai chuThai;

    @ManyToOne
    @JoinColumn(name = "MANVDP")
    private NhanVienDieuPhoi nhanVienDieuPhoi;

    @Column(name = "NGLAP")
    @Temporal(TemporalType.DATE)
    private Date ngLap;

    @Column(name = "NGAYTHANHTOAN")
    @Temporal(TemporalType.DATE)
    private Date ngayThanhToan;

    @Column(name = "SOTIEN", precision = 15, scale = 2)
    private BigDecimal soTien;

    @Column(name = "TONGTIEN", precision = 15, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "TINHTRANG", length = 50)
    private String tinhTrang;

    @Column(name = "GHICHU", length = 255)
    private String ghiChu;

    public void setMaHoaDon(Long maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
} 
