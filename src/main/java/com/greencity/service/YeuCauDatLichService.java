package com.greencity.service;

import com.greencity.model.YeuCauDatLich;
import com.greencity.repository.YeuCauDatLichRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
@Data
public class YeuCauDatLichService {
    @Autowired
    private YeuCauDatLichRepository yeuCauDatLichRepository;

    public List<YeuCauDatLich> getAllYeuCauDatLich() {
        return yeuCauDatLichRepository.findAll();
    }

    public Optional<YeuCauDatLich> getYeuCauDatLichById(Long id) {
        return yeuCauDatLichRepository.findById(id);
    }

    public YeuCauDatLich createYeuCauDatLich(YeuCauDatLich yeuCauDatLich) {
        return yeuCauDatLichRepository.save(yeuCauDatLich);
    }

    public YeuCauDatLich updateYeuCauDatLich(Long id, YeuCauDatLich yeuCauDatLich) {
        return yeuCauDatLichRepository.findById(id)
                .map(existingYeuCau -> {
                    // Update fields
                    existingYeuCau.setChuThai(yeuCauDatLich.getChuThai());
                    existingYeuCau.setLichThuGom(yeuCauDatLich.getLichThuGom());
                    existingYeuCau.setThoiGianYc(yeuCauDatLich.getThoiGianYc());
                    existingYeuCau.setGhiChu(yeuCauDatLich.getGhiChu());
                    existingYeuCau.setTrangThai(yeuCauDatLich.getTrangThai());
                    return yeuCauDatLichRepository.save(existingYeuCau);
                })
                .orElseThrow(() -> new RuntimeException("YeuCauDatLich not found with id: " + id));
    }

    public void deleteYeuCauDatLich(Long id) {
        yeuCauDatLichRepository.deleteById(id);
    }

    public List<YeuCauDatLich> findByChuThai(Long maChuThai) {
        return yeuCauDatLichRepository.findByChuThai_MaChuThai(maChuThai);
    }

    public List<YeuCauDatLich> findByLichThuGom(Long maLich) {
        return yeuCauDatLichRepository.findByLichThuGom_MaLich(maLich);
    }

    public List<YeuCauDatLich> findByTrangThai(String trangThai) {
        return yeuCauDatLichRepository.findByTrangThai(trangThai);
    }

    public List<YeuCauDatLich> findByThoiGianYcBetween(Date startDate, Date endDate) {
        return yeuCauDatLichRepository.findByThoiGianYcBetween(startDate, endDate);
    }

    public List<YeuCauDatLich> findYeuCauMoi() {
        return yeuCauDatLichRepository.findByTrangThai("Mới");
    }

    public List<YeuCauDatLich> findYeuCauDaDuyet() {
        return yeuCauDatLichRepository.findByTrangThai("Đã duyệt");
    }

    public List<YeuCauDatLich> findYeuCauTuChoi() {
        return yeuCauDatLichRepository.findByTrangThai("Từ chối");
    }
} 