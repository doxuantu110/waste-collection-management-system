package com.greencity.repository;

import com.greencity.model.PhanAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PhanAnhRepository extends JpaRepository<PhanAnh, Long> {
    List<PhanAnh> findByChuThai_MaChuThai(Long maChuThai);
    List<PhanAnh> findByTrangThai(String trangThai);
    List<PhanAnh> findByThoiGianGuiBetween(Date startDate, Date endDate);
    List<PhanAnh> findByNoiDungContainingIgnoreCase(String noiDung);
    List<PhanAnh> findByChuThai_MaChuThaiAndTrangThai(Long maChuThai, String trangThai);
}
