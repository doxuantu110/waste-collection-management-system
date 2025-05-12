package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "DONVITHUGOM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonViThuGom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donvithugom_seq")
    @SequenceGenerator(name = "donvithugom_seq", sequenceName = "SEQDONVITHUGOM", allocationSize = 1)
    @Column(name = "MADV", nullable = false)
    private Long maDv;

    @Column(name = "TENDV", length = 100, nullable = false)
    private String tenDv;

    @Column(name = "KHUVUCPHUTRACH", length = 100, nullable = false)
    private String khuVucPhuTrach;

    @Column(name = "DIACHI", length = 200)
    private String diaChi;

    @Column(name = "SDT", length = 15)
    private String sdt;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "TRANGTHAI", length = 20)
    private String trangThai;

    @Column(name = "LOAIDV", length = 50)
    private String loaiDv;

    @OneToMany(mappedBy = "donViThuGom")
    private List<TuyenDuongThuGom> tuyenDuongThuGoms;

    // Getters and Setters
    public Long getMaDv() {
        return maDv;
    }

    public void setMaDv(Long maDv) {
        this.maDv = maDv;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public String getKhuVucPhuTrach() {
        return khuVucPhuTrach;
    }

    public void setKhuVucPhuTrach(String khuVucPhuTrach) {
        this.khuVucPhuTrach = khuVucPhuTrach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLoaiDv() {
        return loaiDv;
    }

    public void setLoaiDv(String loaiDv) {
        this.loaiDv = loaiDv;
    }

    public List<TuyenDuongThuGom> getTuyenDuongThuGoms() {
        return tuyenDuongThuGoms;
    }

    public void setTuyenDuongThuGoms(List<TuyenDuongThuGom> tuyenDuongThuGoms) {
        this.tuyenDuongThuGoms = tuyenDuongThuGoms;
    }
} 