package com.greencity.controller;

import com.greencity.model.NhanVienThuGom;
import com.greencity.service.NhanVienThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvienthugom")
public class NhanVienThuGomController {
    @Autowired
    private NhanVienThuGomService nhanVienThuGomService;

    @GetMapping
    public List<NhanVienThuGom> getAll() {
        return nhanVienThuGomService.getAllNhanVienThuGom();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienThuGom> getById(@PathVariable Long id) {
        return nhanVienThuGomService.getNhanVienThuGomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NhanVienThuGom create(@RequestBody NhanVienThuGom nhanVienThuGom) {
        return nhanVienThuGomService.createNhanVienThuGom(nhanVienThuGom);
    }

    @PutMapping("/{id}")
    public NhanVienThuGom update(@PathVariable Long id, @RequestBody NhanVienThuGom nhanVienThuGom) {
        return nhanVienThuGomService.updateNhanVienThuGom(id, nhanVienThuGom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        nhanVienThuGomService.deleteNhanVienThuGom(id);
    }

    @GetMapping("/donvi/{maDonVi}")
    public List<NhanVienThuGom> getByDonVi(@PathVariable Long maDonVi) {
        return nhanVienThuGomService.findByDonViThuGom(maDonVi);
    }

    @GetMapping("/gioitinh/{gioiTinh}")
    public List<NhanVienThuGom> getByGioiTinh(@PathVariable String gioiTinh) {
        return nhanVienThuGomService.findByGioiTinh(gioiTinh);
    }

    @GetMapping("/search")
    public List<NhanVienThuGom> search(@RequestParam(required = false) String tenNvtg,
                                      @RequestParam(required = false) String sdt) {
        return nhanVienThuGomService.search(tenNvtg, sdt);
    }

    @GetMapping("/truongnhom/{maTruongNhom}")
    public List<NhanVienThuGom> getByTruongNhom(@PathVariable Long maTruongNhom) {
        return nhanVienThuGomService.findByTruongNhom(maTruongNhom);
    }

    @GetMapping("/thanhviennhom/{maThanhVien}")
    public List<NhanVienThuGom> getByThanhVienNhom(@PathVariable Long maThanhVien) {
        return nhanVienThuGomService.findByThanhVienNhom(maThanhVien);
    }

    @GetMapping("/phancong/{maNvtg}")
    public List<NhanVienThuGom> getPhanCong(@PathVariable Long maNvtg) {
        return nhanVienThuGomService.findPhanCongByNhanVien(maNvtg);
    }

    @GetMapping("/chamcong/{maNvtg}")
    public List<NhanVienThuGom> getChamCong(@PathVariable Long maNvtg) {
        return nhanVienThuGomService.findChamCongByNhanVien(maNvtg);
    }
} 