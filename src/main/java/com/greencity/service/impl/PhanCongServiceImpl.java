package com.greencity.service.impl;

import com.greencity.model.PhanCong;
import com.greencity.repository.PhanCongRepository;
import com.greencity.service.PhanCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhanCongServiceImpl implements PhanCongService {

    private final PhanCongRepository phanCongRepository;

    @Autowired
    public PhanCongServiceImpl(PhanCongRepository phanCongRepository) {
        this.phanCongRepository = phanCongRepository;
    }

    @Override
    public List<PhanCong> getAllPhanCong() {
        return phanCongRepository.findAll();
    }

    @Override
    public Optional<PhanCong> getPhanCongById(Long id) {
        return phanCongRepository.findById(id);
    }

    @Override
    public PhanCong createPhanCong(PhanCong phanCong) {
        // Validate required fields
        if (phanCong.getNhanVienDieuPhoi() == null) {
            throw new RuntimeException("Nhân viên điều phối không được để trống");
        }
        if (phanCong.getNhanVienThuGom() == null) {
            throw new RuntimeException("Nhân viên thu gom không được để trống");
        }
        if (phanCong.getLichThuGom() == null) {
            throw new RuntimeException("Lịch thu gom không được để trống");
        }
        return phanCongRepository.save(phanCong);
    }

    @Override
    public PhanCong updatePhanCong(Long id, PhanCong phanCong) {
        return phanCongRepository.findById(id)
                .map(existingPhanCong -> {
                    // Validate required fields
                    if (phanCong.getNhanVienDieuPhoi() == null) {
                        throw new RuntimeException("Nhân viên điều phối không được để trống");
                    }
                    if (phanCong.getNhanVienThuGom() == null) {
                        throw new RuntimeException("Nhân viên thu gom không được để trống");
                    }
                    if (phanCong.getLichThuGom() == null) {
                        throw new RuntimeException("Lịch thu gom không được để trống");
                    }
                    
                    // Update fields
                    existingPhanCong.setNhanVienDieuPhoi(phanCong.getNhanVienDieuPhoi());
                    existingPhanCong.setNhanVienThuGom(phanCong.getNhanVienThuGom());
                    existingPhanCong.setLichThuGom(phanCong.getLichThuGom());
                    
                    return phanCongRepository.save(existingPhanCong);
                })
                .orElseThrow(() -> new RuntimeException("PhanCong not found with id: " + id));
    }

    @Override
    public void deletePhanCong(Long id) {
        if (!phanCongRepository.existsById(id)) {
            throw new RuntimeException("PhanCong not found with id: " + id);
        }
        phanCongRepository.deleteById(id);
    }

    @Override
    public List<PhanCong> findByNhanVienDieuPhoi(Long maNvdp) {
        return phanCongRepository.findByNhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<PhanCong> findByNhanVienThuGom(Long maNvtg) {
        return phanCongRepository.findByNhanVienThuGom_MaNvtg(maNvtg);
    }

    @Override
    public List<PhanCong> findByLichThuGom(Long maLich) {
        return phanCongRepository.findByLichThuGom_MaLich(maLich);
    }

    @Override
    public List<PhanCong> findByNhanVienDieuPhoiAndLichThuGom(Long maNvdp, Long maLich) {
        return phanCongRepository.findByNhanVienDieuPhoi_MaNvdpAndLichThuGom_MaLich(maNvdp, maLich);
    }

    @Override
    public List<PhanCong> findByNhanVienThuGomAndLichThuGom(Long maNvtg, Long maLich) {
        return phanCongRepository.findByNhanVienThuGom_MaNvtgAndLichThuGom_MaLich(maNvtg, maLich);
    }

    @Override
    public List<PhanCong> findByTruongNhom(Long maTruongNhom) {
        return phanCongRepository.findByNhanVienThuGom_TruongNhom_MaNvtg(maTruongNhom);
    }

    @Override
    public List<PhanCong> findByThanhVienNhom(Long maThanhVien) {
        return phanCongRepository.findByNhanVienThuGom_ThanhVienNhom_MaNvtg(maThanhVien);
    }
} 