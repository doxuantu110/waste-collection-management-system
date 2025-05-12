package com.greencity.service;

import com.greencity.model.NhanVienThuGom;
import java.util.List;
import java.util.Optional;

public interface NhanVienThuGomService {
    List<NhanVienThuGom> getAllNhanVienThuGom();
    Optional<NhanVienThuGom> getNhanVienThuGomById(Long id);
    NhanVienThuGom createNhanVienThuGom(NhanVienThuGom nhanVienThuGom);
    NhanVienThuGom updateNhanVienThuGom(Long id, NhanVienThuGom nhanVienThuGom);
    void deleteNhanVienThuGom(Long id);
    List<NhanVienThuGom> findByDonViThuGom(Long maDv);
    List<NhanVienThuGom> findByTruongNhom(Long maTruongNhom);
    List<NhanVienThuGom> findByGioiTinh(String gioiTinh);
    List<NhanVienThuGom> findByTrangThai(String trangThai);
    List<NhanVienThuGom> findByTenNvtgContainingIgnoreCase(String tenNvtg);
    List<NhanVienThuGom> findBySdt(String sdt);
    List<NhanVienThuGom> findByEmail(String email);
    List<NhanVienThuGom> findByDonViThuGomAndTrangThai(Long maDv, String trangThai);
    List<NhanVienThuGom> findByTruongNhomAndTrangThai(Long maTruongNhom, String trangThai);
    List<NhanVienThuGom> getThanhVienNhom(Long maTruongNhom);
    List<NhanVienThuGom> getTruongNhom();
    List<NhanVienThuGom> search(String tenNvtg, String sdt);
    List<NhanVienThuGom> findByThanhVienNhom(Long maThanhVien);
    List<NhanVienThuGom> findPhanCongByNhanVien(Long maNvtg);
    List<NhanVienThuGom> findChamCongByNhanVien(Long maNvtg);
} 