package com.greencity.service;

import com.greencity.model.NhanVienDieuPhoi;
import java.util.List;
import java.util.Optional;

public interface NhanVienDieuPhoiService {
    List<NhanVienDieuPhoi> getAllNhanVienDieuPhoi();
    Optional<NhanVienDieuPhoi> getNhanVienDieuPhoiById(Long id);
    NhanVienDieuPhoi createNhanVienDieuPhoi(NhanVienDieuPhoi nhanVienDieuPhoi);
    NhanVienDieuPhoi updateNhanVienDieuPhoi(Long id, NhanVienDieuPhoi nhanVienDieuPhoi);
    void deleteNhanVienDieuPhoi(Long id);
    Optional<NhanVienDieuPhoi> findByUsername(String username);
    List<NhanVienDieuPhoi> findByVaiTro(String vaiTro);
    boolean existsByUsername(String username);
    NhanVienDieuPhoi authenticate(String username, String password);
    List<NhanVienDieuPhoi> search(String tenNvdp, String sdt);
    List<NhanVienDieuPhoi> findByGioiTinh(String gioiTinh);
    List<NhanVienDieuPhoi> findLichThuGomByNhanVien(Long maNvdp);
    List<NhanVienDieuPhoi> findHoaDonByNhanVien(Long maNvdp);
    List<NhanVienDieuPhoi> findPhanCongByNhanVien(Long maNvdp);
    List<NhanVienDieuPhoi> findChamCongByNhanVien(Long maNvdp);
    List<NhanVienDieuPhoi> findByTenNvdpContainingIgnoreCase(String tenNvdp);
    List<NhanVienDieuPhoi> findBySdt(String sdt);
} 