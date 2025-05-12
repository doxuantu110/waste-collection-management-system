package com.greencity.service;

import com.greencity.model.PhanAnh;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PhanAnhService {
    List<PhanAnh> getAllPhanAnh();
    Optional<PhanAnh> getPhanAnhById(Long id);
    PhanAnh createPhanAnh(PhanAnh phanAnh);
    PhanAnh updatePhanAnh(Long id, PhanAnh phanAnh);
    void deletePhanAnh(Long id);
    List<PhanAnh> findByChuThai(Long maChuThai);
    List<PhanAnh> findByThoiGianGuiBetween(Date startDate, Date endDate);
    List<PhanAnh> findByTrangThai(String trangThai);
    List<PhanAnh> search(String noiDung);
    List<PhanAnh> findPhanAnhMoi();
    List<PhanAnh> findPhanAnhDaXuLy();
    List<PhanAnh> findPhanAnhDangXuLy();
    List<PhanAnh> findByChuThaiAndTrangThai(Long maChuThai, String trangThai);
} 