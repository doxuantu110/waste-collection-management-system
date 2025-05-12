package com.greencity.service;

import com.greencity.model.PhanCong;
import java.util.List;
import java.util.Optional;

public interface PhanCongService {
    List<PhanCong> getAllPhanCong();
    Optional<PhanCong> getPhanCongById(Long id);
    PhanCong createPhanCong(PhanCong phanCong);
    PhanCong updatePhanCong(Long id, PhanCong phanCong);
    void deletePhanCong(Long id);
    List<PhanCong> findByNhanVienDieuPhoi(Long maNvdp);
    List<PhanCong> findByNhanVienThuGom(Long maNvtg);
    List<PhanCong> findByLichThuGom(Long maLich);
    List<PhanCong> findByNhanVienDieuPhoiAndLichThuGom(Long maNvdp, Long maLich);
    List<PhanCong> findByNhanVienThuGomAndLichThuGom(Long maNvtg, Long maLich);
    List<PhanCong> findByTruongNhom(Long maTruongNhom);
    List<PhanCong> findByThanhVienNhom(Long maThanhVien);
} 
