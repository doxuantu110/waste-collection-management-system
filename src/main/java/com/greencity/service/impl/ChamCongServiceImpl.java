package com.greencity.service.impl;

import com.greencity.model.ChamCong;
import com.greencity.repository.ChamCongRepository;
import com.greencity.service.ChamCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChamCongServiceImpl implements ChamCongService {

    private final ChamCongRepository chamCongRepository;

    @Autowired
    public ChamCongServiceImpl(ChamCongRepository chamCongRepository) {
        this.chamCongRepository = chamCongRepository;
    }

    @Override
    public List<ChamCong> getAllChamCong() {
        return chamCongRepository.findAll();
    }

    @Override
    public Optional<ChamCong> getChamCongById(Long id) {
        return chamCongRepository.findById(id);
    }

    @Override
    public ChamCong createChamCong(ChamCong chamCong) {
        // Validate required fields
        if (chamCong.getNhanVienDieuPhoi() == null) {
            throw new RuntimeException("Nhân viên điều phối không được để trống");
        }
        if (chamCong.getNhanVienThuGom() == null) {
            throw new RuntimeException("Nhân viên thu gom không được để trống");
        }
        if (chamCong.getNgayCong() == null) {
            throw new RuntimeException("Ngày công không được để trống");
        }
        return chamCongRepository.save(chamCong);
    }

    @Override
    public ChamCong updateChamCong(Long id, ChamCong chamCong) {
        return chamCongRepository.findById(id)
                .map(existingChamCong -> {
                    // Validate required fields
                    if (chamCong.getNhanVienDieuPhoi() == null) {
                        throw new RuntimeException("Nhân viên điều phối không được để trống");
                    }
                    if (chamCong.getNhanVienThuGom() == null) {
                        throw new RuntimeException("Nhân viên thu gom không được để trống");
                    }
                    if (chamCong.getNgayCong() == null) {
                        throw new RuntimeException("Ngày công không được để trống");
                    }
                    
                    // Update fields
                    existingChamCong.setNhanVienDieuPhoi(chamCong.getNhanVienDieuPhoi());
                    existingChamCong.setNhanVienThuGom(chamCong.getNhanVienThuGom());
                    existingChamCong.setNgayCong(chamCong.getNgayCong());
                    existingChamCong.setGhiChu(chamCong.getGhiChu());
                    existingChamCong.setTrangThai(chamCong.getTrangThai());
                    
                    return chamCongRepository.save(existingChamCong);
                })
                .orElseThrow(() -> new RuntimeException("ChamCong not found with id: " + id));
    }

    @Override
    public void deleteChamCong(Long id) {
        if (!chamCongRepository.existsById(id)) {
            throw new RuntimeException("ChamCong not found with id: " + id);
        }
        chamCongRepository.deleteById(id);
    }

    @Override
    public List<ChamCong> findByNhanVienDieuPhoi(Long maNvdp) {
        return chamCongRepository.findByNhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<ChamCong> findByNhanVienThuGom(Long maNvtg) {
        return chamCongRepository.findByNhanVienThuGom_MaNvtg(maNvtg);
    }

    @Override
    public List<ChamCong> findByNgayCong(Date ngayCong) {
        return chamCongRepository.findByNgayCong(ngayCong);
    }

    @Override
    public List<ChamCong> findByTrangThai(String trangThai) {
        return chamCongRepository.findByTrangThai(trangThai);
    }

    @Override
    public List<ChamCong> findByNhanVienDieuPhoiAndNgayCong(Long maNvdp, Date ngayCong) {
        return chamCongRepository.findByNhanVienDieuPhoi_MaNvdpAndNgayCong(maNvdp, ngayCong);
    }

    @Override
    public List<ChamCong> findByNhanVienThuGomAndNgayCong(Long maNvtg, Date ngayCong) {
        return chamCongRepository.findByNhanVienThuGom_MaNvtgAndNgayCong(maNvtg, ngayCong);
    }

    @Override
    public List<ChamCong> findByNgayCongBetween(Date startDate, Date endDate) {
        return chamCongRepository.findByNgayCongBetween(startDate, endDate);
    }

    @Override
    public List<ChamCong> search(String ghiChu) {
        if (ghiChu == null || ghiChu.trim().isEmpty()) {
            return chamCongRepository.findAll();
        }
        return chamCongRepository.findByGhiChuContainingIgnoreCase(ghiChu);
    }
} 