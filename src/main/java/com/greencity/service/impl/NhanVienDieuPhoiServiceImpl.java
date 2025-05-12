package com.greencity.service.impl;

import com.greencity.model.NhanVienDieuPhoi;
import com.greencity.repository.NhanVienDieuPhoiRepository;
import com.greencity.service.NhanVienDieuPhoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NhanVienDieuPhoiServiceImpl implements NhanVienDieuPhoiService {

    private final NhanVienDieuPhoiRepository nhanVienDieuPhoiRepository;

    @Autowired
    public NhanVienDieuPhoiServiceImpl(NhanVienDieuPhoiRepository nhanVienDieuPhoiRepository) {
        this.nhanVienDieuPhoiRepository = nhanVienDieuPhoiRepository;
    }

    @Override
    public List<NhanVienDieuPhoi> getAllNhanVienDieuPhoi() {
        return nhanVienDieuPhoiRepository.findAll();
    }

    @Override
    public Optional<NhanVienDieuPhoi> getNhanVienDieuPhoiById(Long id) {
        return nhanVienDieuPhoiRepository.findById(id);
    }

    @Override
    public NhanVienDieuPhoi createNhanVienDieuPhoi(NhanVienDieuPhoi nhanVienDieuPhoi) {
        if (nhanVienDieuPhoiRepository.existsByUsername(nhanVienDieuPhoi.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return nhanVienDieuPhoiRepository.save(nhanVienDieuPhoi);
    }

    @Override
    public NhanVienDieuPhoi updateNhanVienDieuPhoi(Long id, NhanVienDieuPhoi nhanVienDieuPhoi) {
        return nhanVienDieuPhoiRepository.findById(id)
                .map(existingNhanVien -> {
                    // Update fields
                    existingNhanVien.setNgaySinh(nhanVienDieuPhoi.getNgaySinh());
                    existingNhanVien.setGioiTinh(nhanVienDieuPhoi.getGioiTinh());
                    existingNhanVien.setSdt(nhanVienDieuPhoi.getSdt());
                    existingNhanVien.setEmail(nhanVienDieuPhoi.getEmail());
                    existingNhanVien.setVaiTro(nhanVienDieuPhoi.getVaiTro());
                    // Only update password if provided
                    if (nhanVienDieuPhoi.getPassword() != null && !nhanVienDieuPhoi.getPassword().isEmpty()) {
                        existingNhanVien.setPassword(nhanVienDieuPhoi.getPassword());
                    }
                    return nhanVienDieuPhoiRepository.save(existingNhanVien);
                })
                .orElseThrow(() -> new RuntimeException("NhanVienDieuPhoi not found with id: " + id));
    }

    @Override
    public void deleteNhanVienDieuPhoi(Long id) {
        if (!nhanVienDieuPhoiRepository.existsById(id)) {
            throw new RuntimeException("NhanVienDieuPhoi not found with id: " + id);
        }
        nhanVienDieuPhoiRepository.deleteById(id);
    }

    @Override
    public Optional<NhanVienDieuPhoi> findByUsername(String username) {
        return nhanVienDieuPhoiRepository.findByUsername(username);
    }

    @Override
    public List<NhanVienDieuPhoi> findByVaiTro(String vaiTro) {
        return nhanVienDieuPhoiRepository.findByVaiTro(vaiTro);
    }

    @Override
    public boolean existsByUsername(String username) {
        return nhanVienDieuPhoiRepository.existsByUsername(username);
    }

    @Override
    public NhanVienDieuPhoi authenticate(String username, String password) {
        return nhanVienDieuPhoiRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    @Override
    public List<NhanVienDieuPhoi> search(String tenNvdp, String sdt) {
        if (tenNvdp != null && !tenNvdp.isEmpty()) {
            return nhanVienDieuPhoiRepository.findByTenNvdpContainingIgnoreCase(tenNvdp);
        }
        if (sdt != null && !sdt.isEmpty()) {
            return nhanVienDieuPhoiRepository.findBySdt(sdt);
        }
        return nhanVienDieuPhoiRepository.findAll();
    }

    @Override
    public List<NhanVienDieuPhoi> findByGioiTinh(String gioiTinh) {
        return nhanVienDieuPhoiRepository.findByGioiTinh(gioiTinh);
    }

    @Override
    public List<NhanVienDieuPhoi> findLichThuGomByNhanVien(Long maNvdp) {
        return nhanVienDieuPhoiRepository.findByLichThuGoms_NhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<NhanVienDieuPhoi> findHoaDonByNhanVien(Long maNvdp) {
        return nhanVienDieuPhoiRepository.findByHoaDons_NhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<NhanVienDieuPhoi> findPhanCongByNhanVien(Long maNvdp) {
        return nhanVienDieuPhoiRepository.findByPhanCongs_NhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<NhanVienDieuPhoi> findChamCongByNhanVien(Long maNvdp) {
        return nhanVienDieuPhoiRepository.findByChamCongs_NhanVienDieuPhoi_MaNvdp(maNvdp);
    }

    @Override
    public List<NhanVienDieuPhoi> findByTenNvdpContainingIgnoreCase(String tenNvdp) {
        return nhanVienDieuPhoiRepository.findByTenNvdpContainingIgnoreCase(tenNvdp);
    }
    
    @Override
    public List<NhanVienDieuPhoi> findBySdt(String sdt) {
        return nhanVienDieuPhoiRepository.findBySdt(sdt);
    }
} 