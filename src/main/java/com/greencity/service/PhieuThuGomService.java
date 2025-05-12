package com.greencity.service;

import com.greencity.model.PhieuThuGom;
import com.greencity.repository.PhieuThuGomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class PhieuThuGomService {
    @Autowired
    private PhieuThuGomRepository phieuThuGomRepository;

    public List<PhieuThuGom> getAllPhieuThuGom() {
        return phieuThuGomRepository.findAll();
    }

    public Optional<PhieuThuGom> getPhieuThuGomById(Long id) {
        return phieuThuGomRepository.findById(id);
    }

    public PhieuThuGom createPhieuThuGom(PhieuThuGom phieuThuGom) {
        return phieuThuGomRepository.save(phieuThuGom);
    }

    public PhieuThuGom updatePhieuThuGom(Long id, PhieuThuGom phieuThuGom) {
        return phieuThuGomRepository.findById(id)
                .map(existingPhieu -> {
                    // Update fields
                    existingPhieu.setNhanVienThuGom(phieuThuGom.getNhanVienThuGom());
                    existingPhieu.setChuThai(phieuThuGom.getChuThai());
                    existingPhieu.setNgThuGom(phieuThuGom.getNgThuGom());
                    existingPhieu.setKhoiLuong(phieuThuGom.getKhoiLuong());
                    existingPhieu.setLoaiRac(phieuThuGom.getLoaiRac());
                    existingPhieu.setTrangThai(phieuThuGom.getTrangThai());
                    return phieuThuGomRepository.save(existingPhieu);
                })
                .orElseThrow(() -> new RuntimeException("PhieuThuGom not found with id: " + id));
    }

    public void deletePhieuThuGom(Long id) {
        phieuThuGomRepository.deleteById(id);
    }

    public List<PhieuThuGom> findByNhanVienThuGom(Long maNvtg) {
        return phieuThuGomRepository.findByNhanVienThuGom_MaNvtg(maNvtg);
    }

    public List<PhieuThuGom> findByChuThai(Long maChuThai) {
        return phieuThuGomRepository.findByChuThai_MaChuThai(maChuThai);
    }

    public List<PhieuThuGom> findByTrangThai(String trangThai) {
        return phieuThuGomRepository.findByTrangThai(trangThai);
    }

    public List<PhieuThuGom> findByNgThuGomBetween(Date startDate, Date endDate) {
        return phieuThuGomRepository.findByNgThuGomBetween(startDate, endDate);
    }

    public List<PhieuThuGom> findByKhoiLuongGreaterThan(Double khoiLuong) {
        return phieuThuGomRepository.findByKhoiLuongGreaterThan(khoiLuong);
    }

    public List<PhieuThuGom> findByLoaiRac(String loaiRac) {
        return phieuThuGomRepository.findByLoaiRac(loaiRac);
    }

    public List<PhieuThuGom> findPhieuThuGomChuaHoanThanh() {
        return phieuThuGomRepository.findByTrangThai("Chưa hoàn thành");
    }

    public List<PhieuThuGom> findPhieuThuGomDaHoanThanh() {
        return phieuThuGomRepository.findByTrangThai("Đã hoàn thành");
    }

    public List<PhieuThuGom> findByNhanVienThuGomAndTrangThai(Long maNvtg, String trangThai) {
        return phieuThuGomRepository.findByNhanVienThuGom_MaNvtgAndTrangThai(maNvtg, trangThai);
    }

    public List<PhieuThuGom> findByChuThaiAndTrangThai(Long maChuThai, String trangThai) {
        return phieuThuGomRepository.findByChuThai_MaChuThaiAndTrangThai(maChuThai, trangThai);
    }

    public List<PhieuThuGom> findByNgThuGomAndTrangThai(Date ngayThuGom, String trangThai) {
        return phieuThuGomRepository.findByNgThuGomAndTrangThai(ngayThuGom, trangThai);
    }

    public List<PhieuThuGom> findByDonViThuGom(Long maDonVi) {
        return phieuThuGomRepository.findByNhanVienThuGom_DonViThuGom_MaDv(maDonVi);
    }

    public List<PhieuThuGom> findByTuyenDuong(Long maTuyen) {
        return phieuThuGomRepository.findByNhanVienThuGom_DonViThuGom_TuyenDuongThuGoms_MaTuyen(maTuyen);
    }

    public List<PhieuThuGom> findByNgayThuGomBetween(Date startDate, Date endDate) {
        return phieuThuGomRepository.findByNgThuGomBetween(startDate, endDate);
    }
} 