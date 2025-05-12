package com.greencity.repository;

import com.greencity.model.YeuCauDatLich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface YeuCauDatLichRepository extends JpaRepository<YeuCauDatLich, Long> {
    List<YeuCauDatLich> findByChuThai_MaChuThai(Long maChuThai);
    List<YeuCauDatLich> findByLichThuGom_MaLich(Long maLich);
    List<YeuCauDatLich> findByTrangThai(String trangThai);
    List<YeuCauDatLich> findByThoiGianYcBetween(Date startDate, Date endDate);
} 