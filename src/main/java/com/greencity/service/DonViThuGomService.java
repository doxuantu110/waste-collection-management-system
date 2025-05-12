package com.greencity.service;

import com.greencity.model.DonViThuGom;
import java.util.List;
import java.util.Optional;

public interface DonViThuGomService {
    List<DonViThuGom> getAll();
    Optional<DonViThuGom> getById(Long id);
    DonViThuGom create(DonViThuGom donViThuGom);
    DonViThuGom update(Long id, DonViThuGom donViThuGom);
    void delete(Long id);
    List<DonViThuGom> findByKhuVucPhuTrach(String khuVuc);
    List<DonViThuGom> findByTenDvContaining(String tenDv);
    List<DonViThuGom> findByTrangThai(String trangThai);
    List<DonViThuGom> findByLoaiDv(String loaiDv);
    List<DonViThuGom> findByKhuVucPhuTrachAndTrangThai(String khuVuc, String trangThai);
    List<DonViThuGom> findByLoaiDvAndTrangThai(String loaiDv, String trangThai);
} 

	