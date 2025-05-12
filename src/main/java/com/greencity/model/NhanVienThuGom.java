package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "NHANVIENTHUGOM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVienThuGom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nvtg_seq")
    @SequenceGenerator(name = "nvtg_seq", sequenceName = "SEQNVTG", allocationSize = 1)
    @Column(name = "MANVTG", nullable = false)
    private Long maNvtg;

    @ManyToOne
    @JoinColumn(name = "MADV", nullable = false)
    private DonViThuGom donViThuGom;

    @Column(name = "TENNVTG", length = 100, nullable = false)
    private String tenNvtg;

    @Column(name = "GIOITINH", length = 10)
    private String gioiTinh;

    @Column(name = "SDT", length = 15)
    private String sdt;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "TRANGTHAI", length = 50)
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "MATRUONGNHOM")
    private NhanVienThuGom truongNhom;

    @OneToMany(mappedBy = "truongNhom")
    private List<NhanVienThuGom> thanhVienNhom;

    @OneToMany(mappedBy = "nhanVienThuGom")
    private List<PhanCong> phanCongs;

    @OneToMany(mappedBy = "nhanVienThuGom")
    private List<ChamCong> chamCongs;

    // Getters and Setters
    public Long getMaNvtg() {
        return maNvtg;
    }

    public void setMaNvtg(Long maNvtg) {
        this.maNvtg = maNvtg;
    }

    public DonViThuGom getDonViThuGom() {
        return donViThuGom;
    }

    public void setDonViThuGom(DonViThuGom donViThuGom) {
        this.donViThuGom = donViThuGom;
    }

    public String getTenNvtg() {
        return tenNvtg;
    }

    public void setTenNvtg(String tenNvtg) {
        this.tenNvtg = tenNvtg;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public NhanVienThuGom getTruongNhom() {
        return truongNhom;
    }

    public void setTruongNhom(NhanVienThuGom truongNhom) {
        this.truongNhom = truongNhom;
    }

    public List<NhanVienThuGom> getThanhVienNhom() {
        return thanhVienNhom;
    }

    public void setThanhVienNhom(List<NhanVienThuGom> thanhVienNhom) {
        this.thanhVienNhom = thanhVienNhom;
    }
} 