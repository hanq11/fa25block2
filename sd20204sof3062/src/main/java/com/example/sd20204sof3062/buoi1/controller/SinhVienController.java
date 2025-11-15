package com.example.sd20204sof3062.buoi1.controller;

import com.example.sd20204sof3062.buoi1.entity.SinhVien;
import com.example.sd20204sof3062.buoi1.repository.SinhVienRepository;
import com.example.sd20204sof3062.buoi1.request.SinhVienRequest;
import com.example.sd20204sof3062.buoi1.response.SinhVienResponse;
import com.example.sd20204sof3062.buoi1.service.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;

    @GetMapping("/hien-thi")
    public List<SinhVienResponse> hienThi() {
        return sinhVienService.getAll();
    }

    @PostMapping("/them")
    public void them(@RequestBody @Valid SinhVienRequest sinhVienRequest) {
        sinhVienService.addSinhVien(sinhVienRequest);
    }

    @PutMapping("/sua")
    public void sua(@RequestBody SinhVienRequest sinhVienRequest) {
        sinhVienService.addSinhVien(sinhVienRequest);
    }

    @DeleteMapping("/xoa")
    public void xoa(@RequestParam("id") Integer id) {
        sinhVienService.deleteSinhVien(id);
    }
}
