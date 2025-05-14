package com.greencity.controller;

import com.greencity.model.HopDong;
import com.greencity.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/hopdong")
public class HopDongController {
    @Autowired
    private HopDongService hopDongService;

    @GetMapping
    public List<HopDong> getAll() {
        return hopDongService.getAllHopDong();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HopDong> getById(@PathVariable Long id) {
        return hopDongService.getHopDongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HopDong create(@RequestBody HopDong hopDong) {
        return hopDongService.createHopDong(hopDong);
    }

    @PutMapping("/{id}")
    public HopDong update(@PathVariable Long id, @RequestBody HopDong hopDong) {
        return hopDongService.updateHopDong(id, hopDong);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hopDongService.deleteHopDong(id);
    }

    @GetMapping("/chuthai/{maChuThai}")
    public List<HopDong> getByChuThai(@PathVariable Long maChuThai) {
        return hopDongService.findByChuThai(maChuThai);
    }

    @GetMapping("/loaihopdong/{loaiHopDong}")
    public List<HopDong> getByLoaiHopDong(@PathVariable String loaiHopDong) {
        return hopDongService.findByLoaiHopDong(loaiHopDong);
    }

    @GetMapping("/thoihan")
    public List<HopDong> getByThoiHan(@RequestParam Date startDate, @RequestParam Date endDate) {
        return hopDongService.findByNgBatDauBetween(startDate, endDate);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<HopDong> getByTrangThai(@PathVariable String trangThai) {
        return hopDongService.findByTrangThai(trangThai);
    }

    @GetMapping("/giatri")
    public List<HopDong> getByGiaTri(@RequestParam Double minValue, @RequestParam Double maxValue) {
        return hopDongService.findByGiaTriBetween(minValue, maxValue);
    }

    @GetMapping("/search")
    public List<HopDong> search(@RequestParam(required = false) String moTa) {
        return hopDongService.search(moTa);
    }
} 
