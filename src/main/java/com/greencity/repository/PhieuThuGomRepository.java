package com.greencity.repository;

import com.greencity.model.PhieuThuGom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PhieuThuGomRepository extends JpaRepository<PhieuThuGom, Long> {
    List<PhieuThuGom> findByNhanVienThuGom_MaNvtg(Long maNvtg);
    List<PhieuThuGom> findByChuThai_MaChuThai(Long maChuThai);
    List<PhieuThuGom> findByTrangThai(String trangThai);
    List<PhieuThuGom> findByNgThuGomBetween(Date startDate, Date endDate);
    List<PhieuThuGom> findByKhoiLuongGreaterThan(Double khoiLuong);
    List<PhieuThuGom> findByLoaiRac(String loaiRac);
    List<PhieuThuGom> findByNhanVienThuGom_MaNvtgAndTrangThai(Long maNvtg, String trangThai);
    List<PhieuThuGom> findByChuThai_MaChuThaiAndTrangThai(Long maChuThai, String trangThai);
    List<PhieuThuGom> findByNgThuGomAndTrangThai(Date ngayThuGom, String trangThai);
    List<PhieuThuGom> findByNgThuGomBeforeAndTrangThai(Date date, String trangThai);
    List<PhieuThuGom> findByNhanVienThuGom_DonViThuGom_MaDv(Long maDv);
    List<PhieuThuGom> findByNhanVienThuGom_DonViThuGom_TuyenDuongThuGoms_MaTuyen(Long maTuyen);
} 
