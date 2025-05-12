package com.greencity.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NHANVIENDIEUPHOI")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVienDieuPhoi {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nvdp_seq")
    @SequenceGenerator(name = "nvdp_seq", sequenceName = "SEQNVDP", allocationSize = 1)
    @Column(name = "MANVDP", nullable = false)
    private Long maNvdp;

    @Column(name = "TENNVDP", length = 100, nullable = false)
    private String tenNvdp;

    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 255)
    private String password;

    @Column(name = "GIOITINH", length = 10)
    private String gioiTinh;

    @Column(name = "SDT", length = 15)
    private String sdt;

    @Column(name = "VAITRO", length = 50)
    private String vaiTro;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVienDieuPhoi")
    private List<LichThuGom> lichThuGoms;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVienDieuPhoi")
    private List<HoaDon> hoaDons;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVienDieuPhoi")
    private List<PhanCong> phanCongs;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanVienDieuPhoi")
    private List<ChamCong> chamCongs;

    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "EMAIL", length = 100)
    private String email;

    // Getters and Setters
    public Long getMaNvdp() {
        return maNvdp;
    }

    public void setMaNvdp(Long maNvdp) {
        this.maNvdp = maNvdp;
    }

    public String getTenNvdp() {
        return tenNvdp;
    }

    public void setTenNvdp(String tenNvdp) {
        this.tenNvdp = tenNvdp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public List<LichThuGom> getLichThuGoms() {
        return lichThuGoms;
    }

    public void setLichThuGoms(List<LichThuGom> lichThuGoms) {
        this.lichThuGoms = lichThuGoms;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public List<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(List<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }

    public List<ChamCong> getChamCongs() {
        return chamCongs;
    }

    public void setChamCongs(List<ChamCong> chamCongs) {
        this.chamCongs = chamCongs;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
} 