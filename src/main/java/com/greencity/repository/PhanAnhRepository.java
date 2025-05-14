package com.greencity.repository;

import com.greencity.model.PhanAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PhanAnhRepository extends JpaRepository<PhanAnh, Long> {
    List<PhanAnh> findByChuThai_MaChuThai(Long maChuThai);
    List<PhanAnh> findByTrangThai(String trangThai);
    List<PhanAnh> findByThoiGianGuiBetween(Date startDate, Date endDate);
    
    @Query("SELECT p FROM PhanAnh p WHERE LOWER(CAST(p.noiDung AS string)) LIKE LOWER(CONCAT('%', CAST(:noiDung AS string), '%'))")
    List<PhanAnh> findByNoiDungContainingIgnoreCase(@Param("noiDung") String noiDung);
    
    List<PhanAnh> findByChuThai_MaChuThaiAndTrangThai(Long maChuThai, String trangThai);
}
