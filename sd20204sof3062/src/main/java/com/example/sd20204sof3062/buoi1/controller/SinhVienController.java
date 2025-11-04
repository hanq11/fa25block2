package com.example.sd20204sof3062.buoi1.controller;

import com.example.sd20204sof3062.buoi1.entity.SinhVien;
import com.example.sd20204sof3062.buoi1.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienRepository sinhVienRepository;

    @GetMapping("/hien-thi")
    public List<SinhVien> hienThi() {
        return sinhVienRepository.findAll();
    }

    @PostMapping("/them")
    public void them(@RequestBody SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    @PutMapping("/sua")
    public void sua(@RequestBody SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    @DeleteMapping("/xoa")
    public void xoa(@RequestParam("id") Integer id) {
        sinhVienRepository.deleteById(id);
    }
}
