package com.greencity.repository;

import com.greencity.model.TtPhanLoaiRac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TtPhanLoaiRacRepository extends JpaRepository<TtPhanLoaiRac, Long> {
    List<TtPhanLoaiRac> findByTenLoaiRacContaining(String tenLoaiRac);
    List<TtPhanLoaiRac> findByHdPhanLoai(String hdPhanLoai);
    Optional<TtPhanLoaiRac> findByTenLoaiRac(String tenLoaiRac);
    List<TtPhanLoaiRac> findByMoTaContaining(String moTa);
}