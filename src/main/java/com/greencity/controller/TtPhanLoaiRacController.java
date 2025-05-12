package com.greencity.controller;

import com.greencity.model.TtPhanLoaiRac;
import com.greencity.service.TtPhanLoaiRacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/phanloairac")
public class TtPhanLoaiRacController {
    @Autowired
    private TtPhanLoaiRacService ttPhanLoaiRacService;

    @GetMapping
    public List<TtPhanLoaiRac> getAll() {
        return ttPhanLoaiRacService.getAllTtPhanLoaiRac();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TtPhanLoaiRac> getById(@PathVariable Long id) {
        return ttPhanLoaiRacService.getTtPhanLoaiRacById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TtPhanLoaiRac create(@RequestBody TtPhanLoaiRac ttPhanLoaiRac) {
        return ttPhanLoaiRacService.createTtPhanLoaiRac(ttPhanLoaiRac);
    }

    @PutMapping("/{id}")
    public TtPhanLoaiRac update(@PathVariable Long id, @RequestBody TtPhanLoaiRac ttPhanLoaiRac) {
        return ttPhanLoaiRacService.updateTtPhanLoaiRac(id, ttPhanLoaiRac);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ttPhanLoaiRacService.deleteTtPhanLoaiRac(id);
    }
} 