package com.greencity.repository;

import com.greencity.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    List<HoaDon> findByHopDong_MaHopDong(Long maHopDong);
    List<HoaDon> findByNhanVienDieuPhoi_MaNvdp(Long maNvdp);
    List<HoaDon> findByTinhTrang(String tinhTrang);
    List<HoaDon> findByNgLapBetween(Date startDate, Date endDate);
    List<HoaDon> findBySoTienBetween(BigDecimal min, BigDecimal max);
    List<HoaDon> findByChuThai_MaChuThai(Long maChuThai);
    List<HoaDon> findByNgayThanhToanBetween(Date startDate, Date endDate);
    List<HoaDon> findByTongTienGreaterThanEqual(BigDecimal tongTien);
    List<HoaDon> findByChuThai_MaChuThaiAndTinhTrang(Long maChuThai, String tinhTrang);
    List<HoaDon> findByNgLapBeforeAndTinhTrang(Date date, String tinhTrang);
} 
