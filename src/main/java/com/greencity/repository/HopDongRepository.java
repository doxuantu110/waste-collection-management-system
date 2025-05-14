package com.greencity.repository;

import com.greencity.model.HopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Long> {
    List<HopDong> findByChuThai_MaChuThai(Long maChuThai);
    List<HopDong> findByDonViThuGom_MaDv(Long maDv);
    List<HopDong> findByTrangThai(String trangThai);
    List<HopDong> findByLoaiHopDong(String loaiHopDong);
    List<HopDong> findByNgBatDauBetween(Date startDate, Date endDate);
    List<HopDong> findByNgKetThucBetween(Date startDate, Date endDate);
    List<HopDong> findByNgBatDauBeforeAndNgKetThucAfter(Date currentDate, Date currentDate2);
    List<HopDong> findByNgKetThucBetweenAndTrangThai(Date startDate, Date endDate, String trangThai);
    List<HopDong> findByNgKetThucBeforeAndTrangThai(Date date, String trangThai);
    
    @Query("SELECT h FROM HopDong h WHERE LOWER(CAST(h.moTa AS string)) LIKE LOWER(CONCAT('%', CAST(:moTa AS string), '%'))")
    List<HopDong> findByMoTaContainingIgnoreCase(@Param("moTa") String moTa);
    
    List<HopDong> findByGiaTriBetween(Double minValue, Double maxValue);
} 
