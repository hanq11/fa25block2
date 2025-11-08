package com.example.sd20204sof3062.buoi1.request;

import com.example.sd20204sof3062.buoi1.entity.LopHoc;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SinhVienRequest {
    private Integer id;

    @NotBlank(message = "Ten khong duoc de trong")
    private String ten;

    @NotNull(message = "Tuoi khong duoc de trong")
    @Min(value = 18, message = "Tuoi toi thieu la 18")
    private Integer tuoi;

    @NotNull(message = "Ngay sinh khong duoc de trong")
    private String ngaySinh;

    private Boolean gioiTinh;

    private LopHoc lopHoc;
}
