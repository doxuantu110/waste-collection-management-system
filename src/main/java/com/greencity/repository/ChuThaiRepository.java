package com.greencity.repository;

import com.greencity.model.ChuThai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChuThaiRepository extends JpaRepository<ChuThai, Long> {
    List<ChuThai> findByHoTenContaining(String hoTen);
    List<ChuThai> findBySdt(String sdt);
    List<ChuThai> findByEmail(String email);
    List<ChuThai> findByDiaChiContaining(String diaChi);
    List<ChuThai> findByTrangThai(String trangThai);
    Optional<ChuThai> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<ChuThai> findByUsernameAndPassword(String username, String password);
} 