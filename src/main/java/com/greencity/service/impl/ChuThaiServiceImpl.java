package com.greencity.service.impl;

import com.greencity.model.ChuThai;
import com.greencity.repository.ChuThaiRepository;
import com.greencity.service.ChuThaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChuThaiServiceImpl implements ChuThaiService {

    private final ChuThaiRepository chuThaiRepository;

    @Autowired
    public ChuThaiServiceImpl(ChuThaiRepository chuThaiRepository) {
        this.chuThaiRepository = chuThaiRepository;
    }

    @Override
    public List<ChuThai> getAll() {
        return chuThaiRepository.findAll();
    }

    @Override
    public Optional<ChuThai> getById(Long id) {
        return chuThaiRepository.findById(id);
    }

    @Override
    public ChuThai create(ChuThai chuThai) {
        // Validate required fields
        if (chuThai.getHoTen() == null || chuThai.getHoTen().trim().isEmpty()) {
            throw new RuntimeException("Họ tên không được để trống");
        }
        if (chuThai.getUsername() == null || chuThai.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Username không được để trống");
        }
        if (chuThai.getPassword() == null || chuThai.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password không được để trống");
        }
        if (chuThaiRepository.existsByUsername(chuThai.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        return chuThaiRepository.save(chuThai);
    }

    @Override
    public ChuThai update(Long id, ChuThai chuThai) {
        return chuThaiRepository.findById(id)
                .map(existingChuThai -> {
                    // Validate required fields
                    if (chuThai.getHoTen() == null || chuThai.getHoTen().trim().isEmpty()) {
                        throw new RuntimeException("Họ tên không được để trống");
                    }
                    
                    // Update fields
                    existingChuThai.setHoTen(chuThai.getHoTen());
                    existingChuThai.setDiaChi(chuThai.getDiaChi());
                    existingChuThai.setSdt(chuThai.getSdt());
                    existingChuThai.setEmail(chuThai.getEmail());
                    existingChuThai.setLoaiChuThai(chuThai.getLoaiChuThai());
                    
                    // Only update password if provided
                    if (chuThai.getPassword() != null && !chuThai.getPassword().isEmpty()) {
                        existingChuThai.setPassword(chuThai.getPassword());
                    }
                    
                    return chuThaiRepository.save(existingChuThai);
                })
                .orElseThrow(() -> new RuntimeException("ChuThai not found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        if (!chuThaiRepository.existsById(id)) {
            throw new RuntimeException("ChuThai not found with id: " + id);
        }
        chuThaiRepository.deleteById(id);
    }

    @Override
    public List<ChuThai> findByHoTenContaining(String hoTen) {
        return chuThaiRepository.findByHoTenContaining(hoTen);
    }

    @Override
    public List<ChuThai> findBySdt(String sdt) {
        return chuThaiRepository.findBySdt(sdt);
    }

    @Override
    public List<ChuThai> findByEmail(String email) {
        return chuThaiRepository.findByEmail(email);
    }

    @Override
    public List<ChuThai> findByDiaChiContaining(String diaChi) {
        return chuThaiRepository.findByDiaChiContaining(diaChi);
    }

    @Override
    public Optional<ChuThai> findByUsername(String username) {
        return chuThaiRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return chuThaiRepository.existsByUsername(username);
    }

    @Override
    public ChuThai authenticate(String username, String password) {
        return chuThaiRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }
} 