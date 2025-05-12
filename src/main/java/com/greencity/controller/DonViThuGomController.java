package com.greencity.controller;

import com.greencity.model.DonViThuGom;
import com.greencity.service.DonViThuGomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donvithugom")
public class DonViThuGomController {
    @Autowired
    private DonViThuGomService donViThuGomService;

    @GetMapping
    public List<DonViThuGom> getAll() {
        return donViThuGomService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonViThuGom> getById(@PathVariable Long id) {
        return donViThuGomService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public DonViThuGom create(@RequestBody DonViThuGom donViThuGom) {
        return donViThuGomService.create(donViThuGom);
    }

    @PutMapping("/{id}")
    public DonViThuGom update(@PathVariable Long id, @RequestBody DonViThuGom donViThuGom) {
        return donViThuGomService.update(id, donViThuGom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        donViThuGomService.delete(id);
    }
} 