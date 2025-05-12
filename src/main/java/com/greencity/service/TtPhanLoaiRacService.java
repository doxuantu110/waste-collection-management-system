package com.greencity.service;

import com.greencity.model.TtPhanLoaiRac;
import com.greencity.repository.TtPhanLoaiRacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TtPhanLoaiRacService {
    @Autowired
    private TtPhanLoaiRacRepository ttPhanLoaiRacRepository;

    public List<TtPhanLoaiRac> getAllTtPhanLoaiRac() {
        return ttPhanLoaiRacRepository.findAll();
    }

    public Optional<TtPhanLoaiRac> getTtPhanLoaiRacById(Long id) {
        return ttPhanLoaiRacRepository.findById(id);
    }

    public TtPhanLoaiRac createTtPhanLoaiRac(TtPhanLoaiRac ttPhanLoaiRac) {
        return ttPhanLoaiRacRepository.save(ttPhanLoaiRac);
    }

    public TtPhanLoaiRac updateTtPhanLoaiRac(Long id, TtPhanLoaiRac ttPhanLoaiRac) {
        return ttPhanLoaiRacRepository.findById(id)
                .map(existingTt -> {
                    // Update fields
                    existingTt.setTenLoaiRac(ttPhanLoaiRac.getTenLoaiRac());
                    existingTt.setHdPhanLoai(ttPhanLoaiRac.getHdPhanLoai());
                    existingTt.setMoTa(ttPhanLoaiRac.getMoTa());
                    return ttPhanLoaiRacRepository.save(existingTt);
                })
                .orElseThrow(() -> new RuntimeException("TtPhanLoaiRac not found with id: " + id));
    }

    public void deleteTtPhanLoaiRac(Long id) {
        ttPhanLoaiRacRepository.deleteById(id);
    }

    public List<TtPhanLoaiRac> findByTenLoaiRacContaining(String tenLoaiRac) {
        return ttPhanLoaiRacRepository.findByTenLoaiRacContaining(tenLoaiRac);
    }

    public List<TtPhanLoaiRac> findByHdPhanLoai(String hdPhanLoai) {
        return ttPhanLoaiRacRepository.findByHdPhanLoai(hdPhanLoai);
    }

    public Optional<TtPhanLoaiRac> findByTenLoaiRac(String tenLoaiRac) {
        return ttPhanLoaiRacRepository.findByTenLoaiRac(tenLoaiRac);
    }

    public List<TtPhanLoaiRac> findByMoTaContaining(String moTa) {
        return ttPhanLoaiRacRepository.findByMoTaContaining(moTa);
    }
} 