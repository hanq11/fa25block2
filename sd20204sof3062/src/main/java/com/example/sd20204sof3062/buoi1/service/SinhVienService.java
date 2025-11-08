package com.example.sd20204sof3062.buoi1.service;

import com.example.sd20204sof3062.buoi1.entity.SinhVien;
import com.example.sd20204sof3062.buoi1.exception.ApiException;
import com.example.sd20204sof3062.buoi1.repository.SinhVienRepository;
import com.example.sd20204sof3062.buoi1.request.SinhVienRequest;
import com.example.sd20204sof3062.buoi1.response.SinhVienResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;

    public List<SinhVienResponse> getAll() {
        return sinhVienRepository
                .findAll()
                .stream()
                .map(SinhVienResponse::new)
                .toList();
    }

    public SinhVienResponse getById(Integer id) {
        SinhVien sinhVien = sinhVienRepository.findById(id).get();
        return new SinhVienResponse(sinhVien);
    }

    public void addSinhVien(SinhVienRequest sinhVienRequest) {
        sinhVienRequest.getGioiTinh().toString();
        SinhVien sinhVien = new SinhVien();
        BeanUtils.copyProperties(sinhVienRequest, sinhVien);
        sinhVienRepository.save(sinhVien);
    }

    public void updateSinhVien(SinhVienRequest sinhVienRequest) {
        SinhVien sinhVien = new SinhVien();
        BeanUtils.copyProperties(sinhVienRequest, sinhVien);
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien(Integer id) {
        sinhVienRepository.findById(id).orElseThrow(
                () -> new ApiException("Id khong ton tai", "ID_NOT_FOUND"));
        sinhVienRepository.deleteById(id);
    }
}
