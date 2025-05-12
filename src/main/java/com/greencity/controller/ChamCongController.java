package com.greencity.controller;

import com.greencity.model.ChamCong;
import com.greencity.service.ChamCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/chamcong")
public class ChamCongController {
    @Autowired
    private ChamCongService chamCongService;

    @GetMapping
    public List<ChamCong> getAll() {
        return chamCongService.getAllChamCong();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamCong> getById(@PathVariable Long id) {
        return chamCongService.getChamCongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChamCong create(@RequestBody ChamCong chamCong) {
        return chamCongService.createChamCong(chamCong);
    }

    @PutMapping("/{id}")
    public ChamCong update(@PathVariable Long id, @RequestBody ChamCong chamCong) {
        return chamCongService.updateChamCong(id, chamCong);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chamCongService.deleteChamCong(id);
    }

    @GetMapping("/nhanviendiephoi/{maNvdp}")
    public List<ChamCong> getByNhanVienDieuPhoi(@PathVariable Long maNvdp) {
        return chamCongService.findByNhanVienDieuPhoi(maNvdp);
    }

    @GetMapping("/nhanvienthugom/{maNvtg}")
    public List<ChamCong> getByNhanVienThuGom(@PathVariable Long maNvtg) {
        return chamCongService.findByNhanVienThuGom(maNvtg);
    }

    @GetMapping("/ngaycong")
    public List<ChamCong> getByNgayCong(@RequestParam Date startDate, @RequestParam Date endDate) {
        return chamCongService.findByNgayCongBetween(startDate, endDate);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<ChamCong> getByTrangThai(@PathVariable String trangThai) {
        return chamCongService.findByTrangThai(trangThai);
    }

    @GetMapping("/search")
    public List<ChamCong> search(@RequestParam(required = false) String ghiChu) {
        return chamCongService.search(ghiChu);
    }
} 