package com.greencity.controller;

import com.greencity.model.PhanCong;
import com.greencity.service.PhanCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phancong")
public class PhanCongController {
    @Autowired
    private PhanCongService phanCongService;

    @GetMapping
    public List<PhanCong> getAll() {
        return phanCongService.getAllPhanCong();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhanCong> getById(@PathVariable Long id) {
        return phanCongService.getPhanCongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhanCong create(@RequestBody PhanCong phanCong) {
        return phanCongService.createPhanCong(phanCong);
    }

    @PutMapping("/{id}")
    public PhanCong update(@PathVariable Long id, @RequestBody PhanCong phanCong) {
        return phanCongService.updatePhanCong(id, phanCong);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        phanCongService.deletePhanCong(id);
    }

    @GetMapping("/nhanviendiephoi/{maNvdp}")
    public List<PhanCong> getByNhanVienDieuPhoi(@PathVariable Long maNvdp) {
        return phanCongService.findByNhanVienDieuPhoi(maNvdp);
    }

    @GetMapping("/nhanvienthugom/{maNvtg}")
    public List<PhanCong> getByNhanVienThuGom(@PathVariable Long maNvtg) {
        return phanCongService.findByNhanVienThuGom(maNvtg);
    }

    @GetMapping("/lichthugom/{maLich}")
    public List<PhanCong> getByLichThuGom(@PathVariable Long maLich) {
        return phanCongService.findByLichThuGom(maLich);
    }

    @GetMapping("/truongnhom/{maTruongNhom}")
    public List<PhanCong> getByTruongNhom(@PathVariable Long maTruongNhom) {
        return phanCongService.findByTruongNhom(maTruongNhom);
    }

    @GetMapping("/thanhviennhom/{maThanhVien}")
    public List<PhanCong> getByThanhVienNhom(@PathVariable Long maThanhVien) {
        return phanCongService.findByThanhVienNhom(maThanhVien);
    }
} 