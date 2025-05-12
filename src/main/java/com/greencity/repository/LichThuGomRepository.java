package com.greencity.repository;

import com.greencity.model.LichThuGom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichThuGomRepository extends JpaRepository<LichThuGom, Long> {
    List<LichThuGom> findByNhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<LichThuGom> findByTrangThai(String trangThai);
    List<LichThuGom> findByNgThu(String ngThu);
    List<LichThuGom> findByGioThu(String gioThu);
    List<LichThuGom> findByNgThuNotAndTrangThai(String ngThu, String trangThai);
    List<LichThuGom> findByMaLich(Long maLich);
}