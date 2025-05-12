package com.greencity.repository;

import com.greencity.model.TuyenDuongThuGom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TuyenDuongThuGomRepository extends JpaRepository<TuyenDuongThuGom, Long> {
    List<TuyenDuongThuGom> findByTenTuyenContaining(String tenTuyen);
    List<TuyenDuongThuGom> findByKhuVuc(String khuVuc);
    List<TuyenDuongThuGom> findByTrangThai(String trangThai);
    Optional<TuyenDuongThuGom> findByTenTuyen(String tenTuyen);
    List<TuyenDuongThuGom> findByMoTaContaining(String moTa);
    List<TuyenDuongThuGom> findByKhuVucAndTrangThai(String khuVuc, String trangThai);
    List<TuyenDuongThuGom> findByDonViThuGom_MaDv(Long maDv);
    List<TuyenDuongThuGom> findByTenTuyenContainingAndMoTaContaining(String tenTuyen, String moTa);
}