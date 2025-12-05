package com.example.thithu1jav101.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHat {
    private Integer id;
    private String tenBaiHat;
    private Float gia;
    private Integer thoiLuong;
    private String ngayRaMat;
}
