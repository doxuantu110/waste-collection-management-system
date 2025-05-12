package com.greencity.controller;

import com.greencity.model.PhanAnh;
import com.greencity.service.PhanAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/phananh")
public class PhanAnhController {
    @Autowired
    private PhanAnhService phanAnhService;

    @GetMapping
    public List<PhanAnh> getAll() {
        return phanAnhService.getAllPhanAnh();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhanAnh> getById(@PathVariable Long id) {
        return phanAnhService.getPhanAnhById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhanAnh create(@RequestBody PhanAnh phanAnh) {
        return phanAnhService.createPhanAnh(phanAnh);
    }

    @PutMapping("/{id}")
    public PhanAnh update(@PathVariable Long id, @RequestBody PhanAnh phanAnh) {
        return phanAnhService.updatePhanAnh(id, phanAnh);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        phanAnhService.deletePhanAnh(id);
    }

    @GetMapping("/chuthai/{maChuThai}")
    public List<PhanAnh> getByChuThai(@PathVariable Long maChuThai) {
        return phanAnhService.findByChuThai(maChuThai);
    }

    @GetMapping("/thoigiangui")
    public List<PhanAnh> getByThoiGianGui(@RequestParam Date startDate, @RequestParam Date endDate) {
        return phanAnhService.findByThoiGianGuiBetween(startDate, endDate);
    }

    @GetMapping("/trangthai/{trangThai}")
    public List<PhanAnh> getByTrangThai(@PathVariable String trangThai) {
        return phanAnhService.findByTrangThai(trangThai);
    }

    @GetMapping("/search")
    public List<PhanAnh> search(@RequestParam(required = false) String noiDung) {
        return phanAnhService.search(noiDung);
    }
} 