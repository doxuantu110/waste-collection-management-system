package com.greencity.service.impl;

import com.greencity.model.HopDong;
import com.greencity.repository.HopDongRepository;
import com.greencity.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Service
@Transactional
public class HopDongServiceImpl implements HopDongService {

    private final HopDongRepository hopDongRepository;

    @Autowired
    public HopDongServiceImpl(HopDongRepository hopDongRepository) {
        this.hopDongRepository = hopDongRepository;
    }

    @Override
    public List<HopDong> getAllHopDong() {
        return hopDongRepository.findAll();
    }

    @Override
    public Optional<HopDong> getHopDongById(Long id) {
        return hopDongRepository.findById(id);
    }

    @Override
    public HopDong createHopDong(HopDong hopDong) {
        // Validate contract dates
        if (hopDong.getNgBatDau().after(hopDong.getNgKetThuc())) {
            throw new RuntimeException("Ngày bắt đầu không thể sau ngày kết thúc");
        }
        return hopDongRepository.save(hopDong);
    }

    @Override
    public HopDong updateHopDong(Long id, HopDong hopDong) {
        return hopDongRepository.findById(id)
                .map(existingHopDong -> {
                    // Validate contract dates
                    if (hopDong.getNgBatDau().after(hopDong.getNgKetThuc())) {
                        throw new RuntimeException("Ngày bắt đầu không thể sau ngày kết thúc");
                    }
                    
                    // Update fields
                    existingHopDong.setChuThai(hopDong.getChuThai());
                    existingHopDong.setNgBatDau(hopDong.getNgBatDau());
                    existingHopDong.setNgKetThuc(hopDong.getNgKetThuc());
                    existingHopDong.setGiaTri(hopDong.getGiaTri());
                    existingHopDong.setTrangThai(hopDong.getTrangThai());
                    existingHopDong.setMoTa(hopDong.getMoTa());
                    existingHopDong.setLoaiHopDong(hopDong.getLoaiHopDong());
                    
                    return hopDongRepository.save(existingHopDong);
                })
                .orElseThrow(() -> new RuntimeException("HopDong not found with id: " + id));
    }

    @Override
    public void deleteHopDong(Long id) {
        if (!hopDongRepository.existsById(id)) {
            throw new RuntimeException("HopDong not found with id: " + id);
        }
        hopDongRepository.deleteById(id);
    }

    @Override
    public List<HopDong> findByChuThai(Long maChuThai) {
        return hopDongRepository.findByChuThai_MaChuThai(maChuThai);
    }

    @Override
    public List<HopDong> findByDonViThuGom(Long maDv) {
        return hopDongRepository.findByDonViThuGom_MaDv(maDv);
    }

    @Override
    public List<HopDong> findByTrangThai(String trangThai) {
        return hopDongRepository.findByTrangThai(trangThai);
    }

    @Override
    public List<HopDong> findByNgBatDauBetween(Date startDate, Date endDate) {
        return hopDongRepository.findByNgBatDauBetween(startDate, endDate);
    }

    @Override
    public List<HopDong> findByNgKetThucBetween(Date startDate, Date endDate) {
        return hopDongRepository.findByNgKetThucBetween(startDate, endDate);
    }

    @Override
    public List<HopDong> findHopDongSapHetHan(int daysThreshold) {
        Date today = new Date();
        Date thresholdDate = new Date(today.getTime() + (long) daysThreshold * 24 * 60 * 60 * 1000);
        return hopDongRepository.findByNgKetThucBetweenAndTrangThai(
            today, thresholdDate, "Đang hoạt động");
    }

    @Override
    public List<HopDong> findHopDongDaHetHan() {
        Date today = new Date();
        return hopDongRepository.findByNgKetThucBeforeAndTrangThai(
            today, "Đang hoạt động");
    }
    
    @Override
    public List<HopDong> findByLoaiHopDong(String loaiHopDong) {
        return hopDongRepository.findByLoaiHopDong(loaiHopDong);
    }

    @Override
    public List<HopDong> findByGiaTriBetween(Double minValue, Double maxValue) {
        return hopDongRepository.findByGiaTriBetween(minValue, maxValue);
    }
    @Override
    public List<HopDong> search(String moTa) {
        if (moTa == null || moTa.trim().isEmpty()) {
            return hopDongRepository.findAll();
        }
        return hopDongRepository.findByMoTaContainingIgnoreCase(moTa);
    }
} 