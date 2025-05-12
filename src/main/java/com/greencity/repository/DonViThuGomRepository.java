package com.greencity.repository;

import com.greencity.model.DonViThuGom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonViThuGomRepository extends JpaRepository<DonViThuGom, Long> {
    List<DonViThuGom> findByKhuVucPhuTrach(String khuVuc);
    List<DonViThuGom> findByTenDvContaining(String tenDv);
    List<DonViThuGom> findByTrangThai(String trangThai);
    List<DonViThuGom> findByLoaiDv(String loaiDv);
    List<DonViThuGom> findByKhuVucPhuTrachAndTrangThai(String khuVuc, String trangThai);
    List<DonViThuGom> findByLoaiDvAndTrangThai(String loaiDv, String trangThai);
} 
