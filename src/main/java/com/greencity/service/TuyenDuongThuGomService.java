package com.greencity.service;

import com.greencity.model.TuyenDuongThuGom;
import com.greencity.repository.TuyenDuongThuGomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TuyenDuongThuGomService {
    @Autowired
    private TuyenDuongThuGomRepository tuyenDuongThuGomRepository;

    public List<TuyenDuongThuGom> getAllTuyenDuongThuGom() {
        return tuyenDuongThuGomRepository.findAll();
    }

    public Optional<TuyenDuongThuGom> getTuyenDuongThuGomById(Long id) {
        return tuyenDuongThuGomRepository.findById(id);
    }

    public TuyenDuongThuGom createTuyenDuongThuGom(TuyenDuongThuGom tuyenDuongThuGom) {
        return tuyenDuongThuGomRepository.save(tuyenDuongThuGom);
    }

    public TuyenDuongThuGom updateTuyenDuongThuGom(Long id, TuyenDuongThuGom tuyenDuongThuGom) {
        return tuyenDuongThuGomRepository.findById(id)
                .map(existingTuyen -> {
                    // Update fields
                    existingTuyen.setTenTuyen(tuyenDuongThuGom.getTenTuyen());
                    existingTuyen.setKhuVuc(tuyenDuongThuGom.getKhuVuc());
                    existingTuyen.setMoTa(tuyenDuongThuGom.getMoTa());
                    existingTuyen.setTrangThai(tuyenDuongThuGom.getTrangThai());
                    return tuyenDuongThuGomRepository.save(existingTuyen);
                })
                .orElseThrow(() -> new RuntimeException("TuyenDuongThuGom not found with id: " + id));
    }

    public void deleteTuyenDuongThuGom(Long id) {
        tuyenDuongThuGomRepository.deleteById(id);
    }

    public List<TuyenDuongThuGom> findByTenTuyenContaining(String tenTuyen) {
        return tuyenDuongThuGomRepository.findByTenTuyenContaining(tenTuyen);
    }

    public List<TuyenDuongThuGom> findByKhuVuc(String khuVuc) {
        return tuyenDuongThuGomRepository.findByKhuVuc(khuVuc);
    }

    public List<TuyenDuongThuGom> findByTrangThai(String trangThai) {
        return tuyenDuongThuGomRepository.findByTrangThai(trangThai);
    }

    public Optional<TuyenDuongThuGom> findByTenTuyen(String tenTuyen) {
        return tuyenDuongThuGomRepository.findByTenTuyen(tenTuyen);
    }

    public List<TuyenDuongThuGom> findByMoTaContaining(String moTa) {
        return tuyenDuongThuGomRepository.findByMoTaContaining(moTa);
    }

    public List<TuyenDuongThuGom> findTuyenDuongDangHoatDong() {
        return tuyenDuongThuGomRepository.findByTrangThai("Đang hoạt động");
    }

    public List<TuyenDuongThuGom> findTuyenDuongNgungHoatDong() {
        return tuyenDuongThuGomRepository.findByTrangThai("Ngừng hoạt động");
    }

    public List<TuyenDuongThuGom> findByKhuVucAndTrangThai(String khuVuc, String trangThai) {
        return tuyenDuongThuGomRepository.findByKhuVucAndTrangThai(khuVuc, trangThai);
    }

    public List<TuyenDuongThuGom> findByDonViThuGom(Long maDonVi) {
        return tuyenDuongThuGomRepository.findByDonViThuGom_MaDv(maDonVi);
    }

    public List<TuyenDuongThuGom> findByQuanHuyen(Long maQuanHuyen) {
        return tuyenDuongThuGomRepository.findByKhuVuc(maQuanHuyen.toString());
    }

    public List<TuyenDuongThuGom> search(String tenTuyen, String moTa) {
        if (tenTuyen != null && moTa != null) {
            return tuyenDuongThuGomRepository.findByTenTuyenContainingAndMoTaContaining(tenTuyen, moTa);
        } else if (tenTuyen != null) {
            return tuyenDuongThuGomRepository.findByTenTuyenContaining(tenTuyen);
        } else if (moTa != null) {
            return tuyenDuongThuGomRepository.findByMoTaContaining(moTa);
        }
        return getAllTuyenDuongThuGom();
    }
} 