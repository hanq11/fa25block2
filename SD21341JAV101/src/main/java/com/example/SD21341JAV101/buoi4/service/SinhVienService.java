package com.example.SD21341JAV101.buoi4.service;

import com.example.SD21341JAV101.buoi4.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> danhSach = new ArrayList<>();

    public SinhVienService() {
        danhSach.add(new SinhVien(1, "Nguyen Van A", 19, true));
        danhSach.add(new SinhVien(2, "Nguyen Thi B", 29, false));
        danhSach.add(new SinhVien(3, "Nguyen Tran C", 39, true));
        danhSach.add(new SinhVien(4, "Nguyen Le D", 49, false));
    }

    public List<SinhVien> getAll() {
        return danhSach;
    }

    public SinhVien getDetailById(Integer id) {
        for(SinhVien sv: danhSach) {
            if(sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }

    public void addSinhVien(SinhVien sinhVien) {
        danhSach.add(sinhVien);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        int indexCanSua = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(sinhVien.getId() == danhSach.get(i).getId()) {
                indexCanSua = i;
            }
        }
        danhSach.set(indexCanSua, sinhVien);
    }

    public void deleteSinhVien(Integer id) {
        danhSach.removeIf(sv -> sv.getId() == id);
    }
}

