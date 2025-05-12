package com.greencity.controller;

import com.greencity.model.LichThuGom;
import com.greencity.service.LichThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lichthugom")
public class LichThuGomController {
    @Autowired
    private LichThuGomService lichThuGomService;

    @GetMapping
    public List<LichThuGom> getAll() {
        return lichThuGomService.getAllLichThuGom();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichThuGom> getById(@PathVariable Long id) {
        return lichThuGomService.getLichThuGomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LichThuGom create(@RequestBody LichThuGom lichThuGom) {
        return lichThuGomService.createLichThuGom(lichThuGom);
    }

    @PutMapping("/{id}")
    public LichThuGom update(@PathVariable Long id, @RequestBody LichThuGom lichThuGom) {
        return lichThuGomService.updateLichThuGom(id, lichThuGom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lichThuGomService.deleteLichThuGom(id);
    }

    @GetMapping("/nhanvien/{maNvdp}")
    public List<LichThuGom> getByNhanVien(@PathVariable Long maNvdp) {
        return lichThuGomService.findByNhanVienDieuPhoi(maNvdp);
    }

    @GetMapping("/ngaythu/{ngayThu}")
    public List<LichThuGom> getByNgayThu(@PathVariable String ngayThu) {
        return lichThuGomService.findByNgThu(ngayThu);
    }

    @GetMapping("/giothu/{gioThu}")
    public List<LichThuGom> getByGioThu(@PathVariable String gioThu) {
        return lichThuGomService.findByGioThu(gioThu);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<LichThuGom> getByTrangThai(@PathVariable String trangThai) {
        return lichThuGomService.findByTrangThai(trangThai);
    }

    @GetMapping("/yeucaudatlich/{maLich}")
    public List<LichThuGom> getYeuCauDatLich(@PathVariable Long maLich) {
        return lichThuGomService.findYeuCauDatLichByLich(maLich);
    }

    @GetMapping("/phancong/{maLich}")
    public List<LichThuGom> getPhanCong(@PathVariable Long maLich) {
        return lichThuGomService.findPhanCongByLich(maLich);
    }
} 