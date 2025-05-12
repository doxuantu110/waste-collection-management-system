package com.greencity.service.impl;

import com.greencity.model.DonViThuGom;
import com.greencity.repository.DonViThuGomRepository;
import com.greencity.service.DonViThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonViThuGomServiceImpl implements DonViThuGomService {

    private final DonViThuGomRepository donViThuGomRepository;

    @Autowired
    public DonViThuGomServiceImpl(DonViThuGomRepository donViThuGomRepository) {
        this.donViThuGomRepository = donViThuGomRepository;
    }

    @Override
    public List<DonViThuGom> getAll() {
        return donViThuGomRepository.findAll();
    }

    @Override
    public Optional<DonViThuGom> getById(Long id) {
        return donViThuGomRepository.findById(id);
    }

    @Override
    public DonViThuGom create(DonViThuGom donViThuGom) {
        // Validate required fields
        if (donViThuGom.getTenDv() == null || donViThuGom.getTenDv().trim().isEmpty()) {
            throw new RuntimeException("Tên đơn vị không được để trống");
        }
        if (donViThuGom.getKhuVucPhuTrach() == null || donViThuGom.getKhuVucPhuTrach().trim().isEmpty()) {
            throw new RuntimeException("Khu vực phụ trách không được để trống");
        }
        return donViThuGomRepository.save(donViThuGom);
    }

    @Override
    public DonViThuGom update(Long id, DonViThuGom donViThuGom) {
        return donViThuGomRepository.findById(id)
                .map(existingDv -> {
                    // Validate required fields
                    if (donViThuGom.getTenDv() == null || donViThuGom.getTenDv().trim().isEmpty()) {
                        throw new RuntimeException("Tên đơn vị không được để trống");
                    }
                    if (donViThuGom.getKhuVucPhuTrach() == null || donViThuGom.getKhuVucPhuTrach().trim().isEmpty()) {
                        throw new RuntimeException("Khu vực phụ trách không được để trống");
                    }
                    
                    // Update fields
                    existingDv.setTenDv(donViThuGom.getTenDv());
                    existingDv.setKhuVucPhuTrach(donViThuGom.getKhuVucPhuTrach());
                    existingDv.setDiaChi(donViThuGom.getDiaChi());
                    existingDv.setSdt(donViThuGom.getSdt());
                    existingDv.setEmail(donViThuGom.getEmail());
                    existingDv.setTrangThai(donViThuGom.getTrangThai());
                    existingDv.setLoaiDv(donViThuGom.getLoaiDv());
                    
                    return donViThuGomRepository.save(existingDv);
                })
                .orElseThrow(() -> new RuntimeException("DonViThuGom not found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!donViThuGomRepository.existsById(id)) {
            throw new RuntimeException("DonViThuGom not found with id: " + id);
        }
        donViThuGomRepository.deleteById(id);
    }

    @Override
    public List<DonViThuGom> findByKhuVucPhuTrach(String khuVuc) {
        return donViThuGomRepository.findByKhuVucPhuTrach(khuVuc);
    }

    @Override
    public List<DonViThuGom> findByTenDvContaining(String tenDv) {
        return donViThuGomRepository.findByTenDvContaining(tenDv);
    }

    @Override
    public List<DonViThuGom> findByTrangThai(String trangThai) {
        return donViThuGomRepository.findByTrangThai(trangThai);
    }

    @Override
    public List<DonViThuGom> findByLoaiDv(String loaiDv) {
        return donViThuGomRepository.findByLoaiDv(loaiDv);
    }

    @Override
    public List<DonViThuGom> findByKhuVucPhuTrachAndTrangThai(String khuVuc, String trangThai) {
        return donViThuGomRepository.findByKhuVucPhuTrachAndTrangThai(khuVuc, trangThai);
    }

    @Override
    public List<DonViThuGom> findByLoaiDvAndTrangThai(String loaiDv, String trangThai) {
        return donViThuGomRepository.findByLoaiDvAndTrangThai(loaiDv, trangThai);
    }
} 