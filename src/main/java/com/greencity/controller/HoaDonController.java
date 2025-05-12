package com.greencity.controller;

import com.greencity.model.HoaDon;
import com.greencity.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping
    public List<HoaDon> getAll() {
        return hoaDonService.getAllHoaDon();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoaDon> getById(@PathVariable Long id) {
        return hoaDonService.getHoaDonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HoaDon create(@RequestBody HoaDon hoaDon) {
        return hoaDonService.createHoaDon(hoaDon);
    }

    @PutMapping("/{id}")
    public HoaDon update(@PathVariable Long id, @RequestBody HoaDon hoaDon) {
        return hoaDonService.updateHoaDon(id, hoaDon);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hoaDonService.deleteHoaDon(id);
    }

    @GetMapping("/hopdong/{maHopDong}")
    public List<HoaDon> getByHopDong(@PathVariable Long maHopDong) {
        return hoaDonService.findByHopDong(maHopDong);
    }

    @GetMapping("/nhanvien/{maNvdp}")
    public List<HoaDon> getByNhanVien(@PathVariable Long maNvdp) {
        return hoaDonService.findByNhanVienDieuPhoi(maNvdp);
    }

    @GetMapping("/ngaylap")
    public List<HoaDon> getByNgayLap(@RequestParam Date startDate, @RequestParam Date endDate) {
        return hoaDonService.findByNgLapBetween(startDate, endDate);
    }

    @GetMapping("/tinhtrang/{tinhTrang}")
    public List<HoaDon> getByTinhTrang(@PathVariable String tinhTrang) {
        return hoaDonService.findByTinhTrang(tinhTrang);
    }

    @GetMapping("/sotien")
    public List<HoaDon> getBySoTien(@RequestParam Double minAmount, @RequestParam Double maxAmount) {
        return hoaDonService.findBySoTienBetween(
            java.math.BigDecimal.valueOf(minAmount),
            java.math.BigDecimal.valueOf(maxAmount)
        );
    }
} 