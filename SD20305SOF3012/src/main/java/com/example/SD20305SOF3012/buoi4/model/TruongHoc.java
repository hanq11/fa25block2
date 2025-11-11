package com.example.SD20305SOF3012.buoi4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//CREATE TABLE truong_hoc (
//        id INT IDENTITY(1,1) PRIMARY KEY,
//        ten_truong NVARCHAR(100) NOT NULL,
//        dia_chi NVARCHAR(255) NOT NULL
//        );
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "truong_hoc")
public class TruongHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_truong")
    private String tenTruong;

    @Column(name = "dia_chi")
    private String diaChi;
}
