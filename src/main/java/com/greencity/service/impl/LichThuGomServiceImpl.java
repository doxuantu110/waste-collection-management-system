package com.greencity.service.impl;

import com.greencity.model.LichThuGom;
import com.greencity.repository.LichThuGomRepository;
import com.greencity.service.LichThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
@Transactional
public class LichThuGomServiceImpl implements LichThuGomService {

    private final LichThuGomRepository lichThuGomRepository;

    @Autowired
    public LichThuGomServiceImpl(LichThuGomRepository lichThuGomRepository) {
        this.lichThuGomRepository = lichThuGomRepository;
    }

    @Override
    public List<LichThuGom> getAllLichThuGom() {
        return lichThuGomRepository.findAll();
    }

    @Override
    public Optional<LichThuGom> getLichThuGomById(Long id) {
        return lichThuGomRepository.findById(id);
    }

    @Override
    public LichThuGom createLichThuGom(LichThuGom lichThuGom) {
        // Validate schedule time
        validateScheduleTime(lichThuGom.getNgThu(), lichThuGom.getGioThu());
        return lichThuGomRepository.save(lichThuGom);
    }

    @Override
    public LichThuGom updateLichThuGom(Long id, LichThuGom lichThuGom) {
        return lichThuGomRepository.findById(id)
                .map(existingLich -> {
                    // Validate schedule time
                    validateScheduleTime(lichThuGom.getNgThu(), lichThuGom.getGioThu());
                    
                    // Update fields
                    existingLich.setNhanVienDieuPhoi(lichThuGom.getNhanVienDieuPhoi());
                    existingLich.setNgThu(lichThuGom.getNgThu());
                    existingLich.setGioThu(lichThuGom.getGioThu());
                    existingLich.setTrangThai(lichThuGom.getTrangThai());
                    
                    return lichThuGomRepository.save(existingLich);
                })
                .orElseThrow(() -> new RuntimeException("LichThuGom not found with id: " + id));
    }

    @Override
    public void deleteLichThuGom(Long id) {
        if (!lichThuGomRepository.existsById(id)) {
            throw new RuntimeException("LichThuGom not found with id: " + id);
        }
        lichThuGomRepository.deleteById(id);
    }

    @Override
    public List<LichThuGom> findByNhanVienDieuPhoi(Long maNvdp) {
        return lichThuGomRepository.findByNhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<LichThuGom> findByTrangThai(String trangThai) {
        return lichThuGomRepository.findByTrangThai(trangThai);
    }

    @Override
    public List<LichThuGom> findByNgThu(String ngThu) {
        return lichThuGomRepository.findByNgThu(ngThu);
    }

    @Override
    public List<LichThuGom> findByGioThu(String gioThu) {
        return lichThuGomRepository.findByGioThu(gioThu);
    }

    @Override
    public List<LichThuGom> findLichThuGomHienTai() {
        LocalDate today = LocalDate.now();
        DayOfWeek currentDay = today.getDayOfWeek();
        String ngayHienTai = currentDay.getDisplayName(TextStyle.FULL, new Locale("vi"));
        return lichThuGomRepository.findByNgThu(ngayHienTai);
    }

    @Override
    public List<LichThuGom> findLichThuGomTuongLai() {
        LocalDate today = LocalDate.now();
        DayOfWeek currentDay = today.getDayOfWeek();
        String ngayHienTai = currentDay.getDisplayName(TextStyle.FULL, new Locale("vi"));
        return lichThuGomRepository.findByNgThuNotAndTrangThai(ngayHienTai, "Chưa thực hiện");
    }

    private void validateScheduleTime(String ngThu, String gioThu) {
        // Validate day of week
        try {
            DayOfWeek.valueOf(ngThu.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Ngày thu gom không hợp lệ");
        }

        // Validate time format (HH:mm)
        if (!gioThu.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            throw new RuntimeException("Giờ thu gom không hợp lệ (định dạng HH:mm)");
        }
    }

    @Override
    public List<LichThuGom> findYeuCauDatLichByLich(Long maLich) {
        return lichThuGomRepository.findByMaLich(maLich);
    }

    @Override
    public List<LichThuGom> findPhanCongByLich(Long maLich) {
        return lichThuGomRepository.findByMaLich(maLich);
    } 
}
