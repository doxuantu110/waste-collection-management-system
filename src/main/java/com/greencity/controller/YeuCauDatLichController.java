package com.greencity.controller;

import com.greencity.model.YeuCauDatLich;
import com.greencity.service.YeuCauDatLichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/yeucaudatlich")
public class YeuCauDatLichController {
    @Autowired
    private YeuCauDatLichService yeuCauDatLichService;

    @GetMapping
    public List<YeuCauDatLich> getAll() {
        return yeuCauDatLichService.getAllYeuCauDatLich();
    }

    @GetMapping("/{id}")
    public ResponseEntity<YeuCauDatLich> getById(@PathVariable Long id) {
        return yeuCauDatLichService.getYeuCauDatLichById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public YeuCauDatLich create(@RequestBody YeuCauDatLich yeuCauDatLich) {
        return yeuCauDatLichService.createYeuCauDatLich(yeuCauDatLich);
    }

    @PutMapping("/{id}")
    public YeuCauDatLich update(@PathVariable Long id, @RequestBody YeuCauDatLich yeuCauDatLich) {
        return yeuCauDatLichService.updateYeuCauDatLich(id, yeuCauDatLich);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        yeuCauDatLichService.deleteYeuCauDatLich(id);
    }

    @GetMapping("/chuthai/{maChuThai}")
    public List<YeuCauDatLich> getByChuThai(@PathVariable Long maChuThai) {
        return yeuCauDatLichService.findByChuThai(maChuThai);
    }

    @GetMapping("/lichthugom/{maLich}")
    public List<YeuCauDatLich> getByLichThuGom(@PathVariable Long maLich) {
        return yeuCauDatLichService.findByLichThuGom(maLich);
    }

    @GetMapping("/thoigianyc")
    public List<YeuCauDatLich> getByThoiGianYc(@RequestParam Date startDate, @RequestParam Date endDate) {
        return yeuCauDatLichService.findByThoiGianYcBetween(startDate, endDate);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<YeuCauDatLich> getByTrangThai(@PathVariable String trangThai) {
        return yeuCauDatLichService.findByTrangThai(trangThai);
    }

    @GetMapping("/yeucaumoi")
    public List<YeuCauDatLich> getYeuCauMoi() {
        return yeuCauDatLichService.findYeuCauMoi();
    }

    @GetMapping("/yeucaudaduyet")
    public List<YeuCauDatLich> getYeuCauDaDuyet() {
        return yeuCauDatLichService.findYeuCauDaDuyet();
    }

    @GetMapping("/yeucautuchoi")
    public List<YeuCauDatLich> getYeuCauTuChoi() {
        return yeuCauDatLichService.findYeuCauTuChoi();
    }
} 