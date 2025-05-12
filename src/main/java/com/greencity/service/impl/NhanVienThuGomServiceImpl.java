package com.greencity.service.impl;

import com.greencity.model.NhanVienThuGom;
import com.greencity.repository.NhanVienThuGomRepository;
import com.greencity.service.NhanVienThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NhanVienThuGomServiceImpl implements NhanVienThuGomService {

    private final NhanVienThuGomRepository nhanVienThuGomRepository;

    @Autowired
    public NhanVienThuGomServiceImpl(NhanVienThuGomRepository nhanVienThuGomRepository) {
        this.nhanVienThuGomRepository = nhanVienThuGomRepository;
    }

    @Override
    public List<NhanVienThuGom> getAllNhanVienThuGom() {
        return nhanVienThuGomRepository.findAll();
    }

    @Override
    public Optional<NhanVienThuGom> getNhanVienThuGomById(Long id) {
        return nhanVienThuGomRepository.findById(id);
    }

    @Override
    public NhanVienThuGom createNhanVienThuGom(NhanVienThuGom nhanVienThuGom) {
        return nhanVienThuGomRepository.save(nhanVienThuGom);
    }

    @Override
    public NhanVienThuGom updateNhanVienThuGom(Long id, NhanVienThuGom nhanVienThuGom) {
        return nhanVienThuGomRepository.findById(id)
                .map(existingNhanVien -> {
                    // Update fields
                    existingNhanVien.setDonViThuGom(nhanVienThuGom.getDonViThuGom());
                    existingNhanVien.setTruongNhom(nhanVienThuGom.getTruongNhom());
                    existingNhanVien.setTenNvtg(nhanVienThuGom.getTenNvtg());
                    existingNhanVien.setGioiTinh(nhanVienThuGom.getGioiTinh());
                    existingNhanVien.setSdt(nhanVienThuGom.getSdt());
                    return nhanVienThuGomRepository.save(existingNhanVien);
                })
                .orElseThrow(() -> new RuntimeException("NhanVienThuGom not found with id: " + id));
    }

    @Override
    public void deleteNhanVienThuGom(Long id) {
        nhanVienThuGomRepository.deleteById(id);
    }

    @Override
    public List<NhanVienThuGom> findByDonViThuGom(Long maDv) {
        return nhanVienThuGomRepository.findByDonViThuGom_MaDv(maDv);
    }

    @Override
    public List<NhanVienThuGom> findByTruongNhom(Long maTruongNhom) {
        return nhanVienThuGomRepository.findByTruongNhom_MaNvtg(maTruongNhom);
    }

    @Override
    public List<NhanVienThuGom> findByGioiTinh(String gioiTinh) {
        return nhanVienThuGomRepository.findByGioiTinh(gioiTinh);
    }

    @Override
    public List<NhanVienThuGom> getThanhVienNhom(Long maTruongNhom) {
        Optional<NhanVienThuGom> truongNhom = nhanVienThuGomRepository.findById(maTruongNhom);
        return truongNhom.map(NhanVienThuGom::getThanhVienNhom)
                .orElseThrow(() -> new RuntimeException("TruongNhom not found with id: " + maTruongNhom));
    }

    @Override
    public List<NhanVienThuGom> getTruongNhom() {
        return nhanVienThuGomRepository.findAll().stream()
                .filter(nv -> nv.getTruongNhom() == null)
                .toList();
    }
    @Override
    public List<NhanVienThuGom> search(String tenNvtg, String sdt) {
        if (tenNvtg != null && !tenNvtg.isEmpty()) {
            return nhanVienThuGomRepository.findByTenNvtgContainingIgnoreCase(tenNvtg);
        }
        if (sdt != null && !sdt.isEmpty()) {
            return nhanVienThuGomRepository.findBySdt(sdt);
        }
        return nhanVienThuGomRepository.findAll();
    }
    public List<NhanVienThuGom> findByTenNvtg(String tenNvtg) {
        return nhanVienThuGomRepository.findByTenNvtg(tenNvtg);
    }   
    @Override
    public List<NhanVienThuGom> findBySdt(String sdt) {
        return nhanVienThuGomRepository.findBySdt(sdt);
    }   
    @Override
    public List<NhanVienThuGom> findByEmail(String email) {
        return nhanVienThuGomRepository.findByEmail(email);
    }   
        @Override
    public List<NhanVienThuGom> findByDonViThuGomAndTrangThai(Long maDv, String trangThai) {
        return nhanVienThuGomRepository.findByDonViThuGom_MaDvAndTrangThai(maDv, trangThai);
    }   
    @Override
    public List<NhanVienThuGom> findByTruongNhomAndTrangThai(Long maTruongNhom, String trangThai) {
        return nhanVienThuGomRepository.findByTruongNhom_MaNvtgAndTrangThai(maTruongNhom, trangThai);
    }   
    @Override
    public List<NhanVienThuGom> findByTrangThai(String trangThai) {
        return nhanVienThuGomRepository.findByTrangThai(trangThai);
    }   
    @Override
    public List<NhanVienThuGom> findByTenNvtgContainingIgnoreCase(String tenNvtg) {
        return nhanVienThuGomRepository.findByTenNvtgContainingIgnoreCase(tenNvtg);
    }
    @Override
    public List<NhanVienThuGom> findByThanhVienNhom(Long maThanhVien) {
        return nhanVienThuGomRepository.findByThanhVienNhom_MaNvtg(maThanhVien);
    }   
    @Override
    public List<NhanVienThuGom> findPhanCongByNhanVien(Long maNvtg) {
        return nhanVienThuGomRepository.findByPhanCongs_NhanVienThuGom_MaNvtg(maNvtg);
    }   
    @Override
    public List<NhanVienThuGom> findChamCongByNhanVien(Long maNvtg) {
        return nhanVienThuGomRepository.findByChamCongs_NhanVienThuGom_MaNvtg(maNvtg);
    }   
    
} 