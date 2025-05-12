package com.greencity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CHUTHAI")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class ChuThai {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chuthai_seq")
    @SequenceGenerator(name = "chuthai_seq", sequenceName = "SEQCHUTHAI", allocationSize = 1)
    @Column(name = "MACHUTHAI", nullable = false)
    private Long maChuThai;

    @Column(name = "HOTEN", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "DIACHI", length = 200)
    private String diaChi;
    
    @Column(name = "SDT", length = 15)
    private String sdt;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "LOAICHUTHAI", length = 50)
    private String loaiChuThai;

    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "TRANGTHAI", length = 20)
    private String trangThai;

    // Getters and Setters
    public Long getMaChuThai() {
        return maChuThai;
    }

    public void setMaChuThai(Long maChuThai) {
        this.maChuThai = maChuThai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getLoaiChuThai() {
        return loaiChuThai;
    }

    public void setLoaiChuThai(String loaiChuThai) {
        this.loaiChuThai = loaiChuThai;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
} 