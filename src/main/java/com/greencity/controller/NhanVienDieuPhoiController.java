 package com.greencity.controller;

import com.greencity.model.NhanVienDieuPhoi;
import com.greencity.service.NhanVienDieuPhoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanviendieuphoi")
public class NhanVienDieuPhoiController {
    @Autowired
    private NhanVienDieuPhoiService nhanVienDieuPhoiService;

    @GetMapping
    public List<NhanVienDieuPhoi> getAll() {
        return nhanVienDieuPhoiService.getAllNhanVienDieuPhoi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienDieuPhoi> getById(@PathVariable Long id) {
        return nhanVienDieuPhoiService.getNhanVienDieuPhoiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NhanVienDieuPhoi create(@RequestBody NhanVienDieuPhoi nhanVienDieuPhoi) {
        return nhanVienDieuPhoiService.createNhanVienDieuPhoi(nhanVienDieuPhoi);
    }

    @PutMapping("/{id}")
    public NhanVienDieuPhoi update(@PathVariable Long id, @RequestBody NhanVienDieuPhoi nhanVienDieuPhoi) {
        return nhanVienDieuPhoiService.updateNhanVienDieuPhoi(id, nhanVienDieuPhoi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        nhanVienDieuPhoiService.deleteNhanVienDieuPhoi(id);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<NhanVienDieuPhoi> getByUsername(@PathVariable String username) {
        return nhanVienDieuPhoiService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/vaitro/{vaiTro}")
    public List<NhanVienDieuPhoi> getByVaiTro(@PathVariable String vaiTro) {
        return nhanVienDieuPhoiService.findByVaiTro(vaiTro);
    }

    @GetMapping("/gioitinh/{gioiTinh}")
    public List<NhanVienDieuPhoi> getByGioiTinh(@PathVariable String gioiTinh) {
        return nhanVienDieuPhoiService.findByGioiTinh(gioiTinh);
    }

    @GetMapping("/search")
    public List<NhanVienDieuPhoi> search(@RequestParam(required = false) String tenNvdp,
                                        @RequestParam(required = false) String sdt) {
        return nhanVienDieuPhoiService.search(tenNvdp, sdt);
    }

    @GetMapping("/lichthugom/{maNvdp}")
    public List<NhanVienDieuPhoi> getLichThuGom(@PathVariable Long maNvdp) {
        return nhanVienDieuPhoiService.findLichThuGomByNhanVien(maNvdp);
    }

    @GetMapping("/hoadon/{maNvdp}")
    public List<NhanVienDieuPhoi> getHoaDon(@PathVariable Long maNvdp) {
        return nhanVienDieuPhoiService.findHoaDonByNhanVien(maNvdp);
    }

    @GetMapping("/phancong/{maNvdp}")
    public List<NhanVienDieuPhoi> getPhanCong(@PathVariable Long maNvdp) {
        return nhanVienDieuPhoiService.findPhanCongByNhanVien(maNvdp);
    }

    @GetMapping("/chamcong/{maNvdp}")
    public List<NhanVienDieuPhoi> getChamCong(@PathVariable Long maNvdp) {
        return nhanVienDieuPhoiService.findChamCongByNhanVien(maNvdp);
    }
}