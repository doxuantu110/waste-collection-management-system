package com.greencity.service.impl;

import com.greencity.model.PhanAnh;
import com.greencity.repository.PhanAnhRepository;
import com.greencity.service.PhanAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhanAnhServiceImpl implements PhanAnhService {

    @Autowired
    private PhanAnhRepository phanAnhRepository;

    @Override
    public List<PhanAnh> getAllPhanAnh() {
        return phanAnhRepository.findAll();
    }

    @Override
    public Optional<PhanAnh> getPhanAnhById(Long id) {
        return phanAnhRepository.findById(id);
    }

    @Override
    public PhanAnh createPhanAnh(PhanAnh phanAnh) {
        // Validate required fields
        if (phanAnh.getChuThai() == null) {
            throw new RuntimeException("Chủ thải không được để trống");
        }
        if (phanAnh.getNoiDung() == null || phanAnh.getNoiDung().trim().isEmpty()) {
            throw new RuntimeException("Nội dung phản ánh không được để trống");
        }
        // Set default values
        if (phanAnh.getThoiGianGui() == null) {
            phanAnh.setThoiGianGui(new Date());
        }
        if (phanAnh.getTrangThai() == null) {
            phanAnh.setTrangThai("Mới");
        }
        return phanAnhRepository.save(phanAnh);
    }

    @Override
    public PhanAnh updatePhanAnh(Long id, PhanAnh phanAnh) {
        if (phanAnhRepository.existsById(id)) {
            phanAnh.setMaPa(id);
            return phanAnhRepository.save(phanAnh);
        }
        throw new RuntimeException("Phan anh not found with id: " + id);
    }

    @Override
    public void deletePhanAnh(Long id) {
        phanAnhRepository.deleteById(id);
    }

    @Override
    public List<PhanAnh> findByChuThai(Long maChuThai) {
        return phanAnhRepository.findByChuThai_MaChuThai(maChuThai);
    }

    @Override
    public List<PhanAnh> findByThoiGianGuiBetween(Date startDate, Date endDate) {
        return phanAnhRepository.findByThoiGianGuiBetween(startDate, endDate);
    }

    @Override
    public List<PhanAnh> findByTrangThai(String trangThai) {
        return phanAnhRepository.findByTrangThai(trangThai);
    }

    @Override
    public List<PhanAnh> search(String noiDung) {
        if (noiDung == null || noiDung.trim().isEmpty()) {
            return getAllPhanAnh();
        }
        return phanAnhRepository.findByNoiDungContainingIgnoreCase(noiDung);
    }

    @Override
    public List<PhanAnh> findPhanAnhMoi() {
        return phanAnhRepository.findByTrangThai("Mới");
    }

    @Override
    public List<PhanAnh> findPhanAnhDaXuLy() {
        return phanAnhRepository.findByTrangThai("Đã xử lý");
    }

    @Override
    public List<PhanAnh> findPhanAnhDangXuLy() {
        return phanAnhRepository.findByTrangThai("Đang xử lý");
    }

    @Override
    public List<PhanAnh> findByChuThaiAndTrangThai(Long maChuThai, String trangThai) {
        return phanAnhRepository.findByChuThai_MaChuThaiAndTrangThai(maChuThai, trangThai);
    }
} 