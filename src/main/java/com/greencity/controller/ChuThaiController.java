package com.greencity.controller;

import com.greencity.model.ChuThai;
import com.greencity.service.ChuThaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chuthai")
public class ChuThaiController {
    @Autowired
    private ChuThaiService chuThaiService;

    @GetMapping
    public List<ChuThai> getAll() {
        return chuThaiService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChuThai> getById(@PathVariable Long id) {
        return chuThaiService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChuThai create(@RequestBody ChuThai chuThai) {
        return chuThaiService.create(chuThai);
    }

    @PutMapping("/{id}")
    public ChuThai update(@PathVariable Long id, @RequestBody ChuThai chuThai) {
        return chuThaiService.update(id, chuThai);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chuThaiService.delete(id);
    }
} 