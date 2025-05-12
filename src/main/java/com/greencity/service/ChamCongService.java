package com.greencity.service;

import com.greencity.model.ChamCong;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface ChamCongService {
    List<ChamCong> getAllChamCong();
    Optional<ChamCong> getChamCongById(Long id);
    ChamCong createChamCong(ChamCong chamCong);
    ChamCong updateChamCong(Long id, ChamCong chamCong);
    void deleteChamCong(Long id);
    List<ChamCong> findByNhanVienDieuPhoi(Long maNvdp);
    List<ChamCong> findByNhanVienThuGom(Long maNvtg);
    List<ChamCong> findByNgayCong(Date ngayCong);
    List<ChamCong> findByTrangThai(String trangThai);
    List<ChamCong> findByNhanVienDieuPhoiAndNgayCong(Long maNvdp, Date ngayCong);
    List<ChamCong> findByNhanVienThuGomAndNgayCong(Long maNvtg, Date ngayCong);
    List<ChamCong> findByNgayCongBetween(Date startDate, Date endDate);
    List<ChamCong> search(String ghiChu);
} 