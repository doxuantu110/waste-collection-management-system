package com.greencity.repository;

import com.greencity.model.ChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChamCongRepository extends JpaRepository<ChamCong, Long> {
    List<ChamCong> findByNhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<ChamCong> findByNhanVienThuGom_MaNvtg(Long maNvtg);
    List<ChamCong> findByTrangThai(String trangThai);
    List<ChamCong> findByNgayCongBetween(Date startDate, Date endDate);
    List<ChamCong> findByNhanVienThuGom_MaNvtgAndNgayCong(Long maNvtg, Date ngayCong);
	List<ChamCong> findByNhanVienDieuPhoi_MaNvdpAndNgayCong(Long maNvdp, Date ngayCong);
	List<ChamCong> findByNgayCong(Date ngayCong);
    List<ChamCong> findByGhiChuContainingIgnoreCase(String ghiChu);
} 
