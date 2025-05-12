package com.greencity.service.impl;

import com.greencity.model.HoaDon;
import com.greencity.repository.HoaDonRepository;
import com.greencity.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    @Override
    public Optional<HoaDon> getHoaDonById(Long id) {
        return hoaDonRepository.findById(id);
    }

    @Override
    public HoaDon createHoaDon(HoaDon hoaDon) {
        // Add validation as needed
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon updateHoaDon(Long id, HoaDon hoaDon) {
        if (hoaDonRepository.existsById(id)) {
            hoaDon.setMaHoaDon(id);
            return hoaDonRepository.save(hoaDon);
        }
        throw new RuntimeException("Hoa don not found with id: " + id);
    }

    @Override
    public void deleteHoaDon(Long id) {
        hoaDonRepository.deleteById(id);
    }

    @Override
    public List<HoaDon> findByHopDong(Long maHopDong) {
        return hoaDonRepository.findByHopDong_MaHopDong(maHopDong);
    }

    @Override
    public List<HoaDon> findByNhanVienDieuPhoi(Long maNvdp) {
        return hoaDonRepository.findByNhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<HoaDon> findByNgLapBetween(Date startDate, Date endDate) {
        return hoaDonRepository.findByNgLapBetween(startDate, endDate);
    }

    @Override
    public List<HoaDon> findByTinhTrang(String tinhTrang) {
        return hoaDonRepository.findByTinhTrang(tinhTrang);
    }

    @Override
    public List<HoaDon> findBySoTienBetween(BigDecimal minAmount, BigDecimal maxAmount) {
        return hoaDonRepository.findBySoTienBetween(minAmount, maxAmount);
    }
} 