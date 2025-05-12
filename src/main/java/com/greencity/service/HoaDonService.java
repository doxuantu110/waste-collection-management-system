package com.greencity.service;

import com.greencity.model.HoaDon;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public interface HoaDonService {
    List<HoaDon> getAllHoaDon();
    Optional<HoaDon> getHoaDonById(Long id);
    HoaDon createHoaDon(HoaDon hoaDon);
    HoaDon updateHoaDon(Long id, HoaDon hoaDon);
    void deleteHoaDon(Long id);
    List<HoaDon> findByHopDong(Long maHopDong);
    List<HoaDon> findByNhanVienDieuPhoi(Long maNvdp);
    List<HoaDon> findByNgLapBetween(Date startDate, Date endDate);
    List<HoaDon> findByTinhTrang(String tinhTrang);
    List<HoaDon> findBySoTienBetween(BigDecimal minAmount, BigDecimal maxAmount);
    
} 