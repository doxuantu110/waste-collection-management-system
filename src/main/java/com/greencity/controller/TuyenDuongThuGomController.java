package com.greencity.controller;

import com.greencity.model.TuyenDuongThuGom;
import com.greencity.service.TuyenDuongThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tuyenduong")
public class TuyenDuongThuGomController {
    @Autowired
    private TuyenDuongThuGomService tuyenDuongThuGomService;

    @GetMapping
    public List<TuyenDuongThuGom> getAll() {
        return tuyenDuongThuGomService.getAllTuyenDuongThuGom();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuyenDuongThuGom> getById(@PathVariable Long id) {
        return tuyenDuongThuGomService.getTuyenDuongThuGomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TuyenDuongThuGom create(@RequestBody TuyenDuongThuGom tuyenDuongThuGom) {
        return tuyenDuongThuGomService.createTuyenDuongThuGom(tuyenDuongThuGom);
    }

    @PutMapping("/{id}")
    public TuyenDuongThuGom update(@PathVariable Long id, @RequestBody TuyenDuongThuGom tuyenDuongThuGom) {
        return tuyenDuongThuGomService.updateTuyenDuongThuGom(id, tuyenDuongThuGom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tuyenDuongThuGomService.deleteTuyenDuongThuGom(id);
    }

    @GetMapping("/donvi/{maDonVi}")
    public List<TuyenDuongThuGom> getByDonVi(@PathVariable Long maDonVi) {
        return tuyenDuongThuGomService.findByDonViThuGom(maDonVi);
    }

    @GetMapping("/quanhuyen/{maQuanHuyen}")
    public List<TuyenDuongThuGom> getByQuanHuyen(@PathVariable Long maQuanHuyen) {
        return tuyenDuongThuGomService.findByQuanHuyen(maQuanHuyen);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<TuyenDuongThuGom> getByTrangThai(@PathVariable String trangThai) {
        return tuyenDuongThuGomService.findByTrangThai(trangThai);
    }

    @GetMapping("/search")
    public List<TuyenDuongThuGom> search(@RequestParam(required = false) String tenTuyen,
                                        @RequestParam(required = false) String moTa) {
        return tuyenDuongThuGomService.search(tenTuyen, moTa);
    }
} 