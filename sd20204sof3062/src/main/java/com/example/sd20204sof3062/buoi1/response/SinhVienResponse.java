package com.example.sd20204sof3062.buoi1.response;

import com.example.sd20204sof3062.buoi1.entity.LopHoc;
import com.example.sd20204sof3062.buoi1.entity.SinhVien;
import lombok.Data;

@Data
public class SinhVienResponse {
    private Integer id;

    private String ten;

    private Integer tuoi;

    private String ngaySinh;

    private Boolean gioiTinh;

    private LopHoc lopHoc;

    public SinhVienResponse(SinhVien sinhVien) {
        this.id = sinhVien.getId();
        this.ten = sinhVien.getTen();
        this.tuoi = sinhVien.getTuoi();
        this.ngaySinh = sinhVien.getNgaySinh();
        this.gioiTinh = sinhVien.getGioiTinh();
        this.lopHoc = sinhVien.getLopHoc();
    }
}
