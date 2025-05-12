package com.greencity.service;

import com.greencity.model.ChuThai;
import java.util.List;
import java.util.Optional;

public interface ChuThaiService {
    List<ChuThai> getAll();
    Optional<ChuThai> getById(Long id);
    ChuThai create(ChuThai chuThai);
    ChuThai update(Long id, ChuThai chuThai);
    void delete(Long id);
    List<ChuThai> findByHoTenContaining(String hoTen);
    List<ChuThai> findBySdt(String sdt);
    List<ChuThai> findByEmail(String email);
    List<ChuThai> findByDiaChiContaining(String diaChi);
    Optional<ChuThai> findByUsername(String username);
    boolean existsByUsername(String username);
    ChuThai authenticate(String username, String password);
} 
