package com.greencity.service;

import com.greencity.model.HopDong;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HopDongService {
    List<HopDong> getAllHopDong();
    Optional<HopDong> getHopDongById(Long id);
    HopDong createHopDong(HopDong hopDong);
    HopDong updateHopDong(Long id, HopDong hopDong);
    void deleteHopDong(Long id);
    List<HopDong> findByChuThai(Long maChuThai);
    List<HopDong> findByDonViThuGom(Long maDv);
    List<HopDong> findByTrangThai(String trangThai);
    List<HopDong> findByLoaiHopDong(String loaiHopDong);
    List<HopDong> findByNgBatDauBetween(Date startDate, Date endDate);
    List<HopDong> findByNgKetThucBetween(Date startDate, Date endDate);
    List<HopDong> findHopDongSapHetHan(int daysThreshold);
    List<HopDong> findHopDongDaHetHan();
    List<HopDong> findByGiaTriBetween(Double minValue, Double maxValue);
    List<HopDong> search(String moTa);
} 
