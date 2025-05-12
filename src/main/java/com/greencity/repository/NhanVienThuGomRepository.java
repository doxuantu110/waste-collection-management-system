package com.greencity.repository;

import com.greencity.model.NhanVienThuGom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienThuGomRepository extends JpaRepository<NhanVienThuGom, Long> {
    List<NhanVienThuGom> findByDonViThuGom_MaDv(Long maDv);
    List<NhanVienThuGom> findByTruongNhom_MaNvtg(Long maTruongNhom);
    List<NhanVienThuGom> findByGioiTinh(String gioiTinh);
    List<NhanVienThuGom> findByTrangThai(String trangThai);
    List<NhanVienThuGom> findBySdt(String sdt);
    List<NhanVienThuGom> findByEmail(String email);
    List<NhanVienThuGom> findByDonViThuGom_MaDvAndTrangThai(Long maDv, String trangThai);
    List<NhanVienThuGom> findByTruongNhom_MaNvtgAndTrangThai(Long maTruongNhom, String trangThai);
    List<NhanVienThuGom> findByTruongNhomIsNull();
    List<NhanVienThuGom> findByThanhVienNhom_MaNvtg(Long maThanhVien);
    List<NhanVienThuGom> findByTenNvtgContainingIgnoreCase(String tenNvtg);
    List<NhanVienThuGom> findByTenNvtg(String tenNvtg);
    List<NhanVienThuGom> findByPhanCongs_NhanVienThuGom_MaNvtg(Long maNvtg);
    List<NhanVienThuGom> findByChamCongs_NhanVienThuGom_MaNvtg(Long maNvtg);
} 