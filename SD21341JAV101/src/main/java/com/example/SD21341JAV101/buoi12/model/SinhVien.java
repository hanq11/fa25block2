package com.example.SD21341JAV101.buoi12.model;

import lombok.*;

//id INT IDENTITY(1,1) PRIMARY KEY,
//        ten NVARCHAR(100),
//        tuoi INT,
//        diem FLOAT,
//        gioi_tinh BIT -- 0 = Nam, 1 = Nữ
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
    private Integer id;
    private String ten;
    private Integer tuoi;
    private Float diem;
    private Boolean gioiTinh;
}
