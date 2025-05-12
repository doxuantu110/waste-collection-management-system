package com.greencity.controller;

import com.greencity.model.PhieuThuGom;
import com.greencity.service.PhieuThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/phieuthugom")
public class PhieuThuGomController {
    @Autowired
    private PhieuThuGomService phieuThuGomService;

    @GetMapping
    public List<PhieuThuGom> getAll() {
        return phieuThuGomService.getAllPhieuThuGom();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhieuThuGom> getById(@PathVariable Long id) {
        return phieuThuGomService.getPhieuThuGomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhieuThuGom create(@RequestBody PhieuThuGom phieuThuGom) {
        return phieuThuGomService.createPhieuThuGom(phieuThuGom);
    }

    @PutMapping("/{id}")
    public PhieuThuGom update(@PathVariable Long id, @RequestBody PhieuThuGom phieuThuGom) {
        return phieuThuGomService.updatePhieuThuGom(id, phieuThuGom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        phieuThuGomService.deletePhieuThuGom(id);
    }

    @GetMapping("/donvi/{maDonVi}")
    public List<PhieuThuGom> getByDonVi(@PathVariable Long maDonVi) {
        return phieuThuGomService.findByDonViThuGom(maDonVi);
    }

    @GetMapping("/tuyenduong/{maTuyen}")
    public List<PhieuThuGom> getByTuyenDuong(@PathVariable Long maTuyen) {
        return phieuThuGomService.findByTuyenDuong(maTuyen);
    }

    @GetMapping("/ngaythugom")
    public List<PhieuThuGom> getByNgayThuGom(@RequestParam Date startDate, @RequestParam Date endDate) {
        return phieuThuGomService.findByNgayThuGomBetween(startDate, endDate);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<PhieuThuGom> getByTrangThai(@PathVariable String trangThai) {
        return phieuThuGomService.findByTrangThai(trangThai);
    }
} 