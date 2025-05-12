package com.greencity.repository;

import com.greencity.model.NhanVienDieuPhoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienDieuPhoiRepository extends JpaRepository<NhanVienDieuPhoi, Long> {
    Optional<NhanVienDieuPhoi> findByUsername(String username);
    Optional<NhanVienDieuPhoi> findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    List<NhanVienDieuPhoi> findByVaiTro(String vaiTro);
    List<NhanVienDieuPhoi> findByTenNvdpContainingIgnoreCase(String tenNvdp);
    List<NhanVienDieuPhoi> findBySdt(String sdt);
    List<NhanVienDieuPhoi> findByGioiTinh(String gioiTinh);
    List<NhanVienDieuPhoi> findByLichThuGoms_NhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<NhanVienDieuPhoi> findByHoaDons_NhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<NhanVienDieuPhoi> findByPhanCongs_NhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<NhanVienDieuPhoi> findByChamCongs_NhanVienDieuPhoi_MaNvdp(Long maNvdp);
} 