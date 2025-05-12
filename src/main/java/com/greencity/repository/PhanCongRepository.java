package com.greencity.repository;

import com.greencity.model.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhanCongRepository extends JpaRepository<PhanCong, Long> {
    List<PhanCong> findByNhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<PhanCong> findByLichThuGom_MaLich(Long maLich);
    List<PhanCong> findByNhanVienThuGom_MaNvtg(Long maNvtg);
    List<PhanCong> findByNhanVienDieuPhoi_MaNvdpAndLichThuGom_MaLich(Long maNvdp, Long maLich);
    List<PhanCong> findByNhanVienThuGom_MaNvtgAndLichThuGom_MaLich(Long maNvtg, Long maLich);
    List<PhanCong> findByNhanVienThuGom_TruongNhom_MaNvtg(Long maTruongNhom);
    List<PhanCong> findByNhanVienThuGom_ThanhVienNhom_MaNvtg(Long maThanhVien);
} 
