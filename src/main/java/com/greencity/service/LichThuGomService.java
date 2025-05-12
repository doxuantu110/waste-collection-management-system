package com.greencity.service;

import com.greencity.model.LichThuGom;
import java.util.List;
import java.util.Optional;

public interface LichThuGomService {
    List<LichThuGom> getAllLichThuGom();
    Optional<LichThuGom> getLichThuGomById(Long id);
    LichThuGom createLichThuGom(LichThuGom lichThuGom);
    LichThuGom updateLichThuGom(Long id, LichThuGom lichThuGom);
    void deleteLichThuGom(Long id);
    List<LichThuGom> findByNhanVienDieuPhoi(Long maNvdp);
    List<LichThuGom> findByTrangThai(String trangThai);
    List<LichThuGom> findByNgThu(String ngThu);
    List<LichThuGom> findByGioThu(String gioThu);
    List<LichThuGom> findLichThuGomHienTai();
    List<LichThuGom> findLichThuGomTuongLai();
    List<LichThuGom> findYeuCauDatLichByLich(Long maLich);
    List<LichThuGom> findPhanCongByLich(Long maLich);
} 