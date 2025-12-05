package com.example.thithu1jav101.repository;

import com.example.thithu1jav101.model.BaiHat;
import com.example.thithu1jav101.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiHatRepository {
    private Connection con = null;

    public BaiHatRepository() {
        con = DbConnection.getConnection();
    }

    public List<BaiHat> getAll() {
        String sql = "SELECT * FROM bai_hat";
        List<BaiHat> danhSach = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new BaiHat(
                        rs.getInt("id"),
                        rs.getString("ten_bai_hat"),
                        rs.getFloat("gia"),
                        rs.getInt("thoi_luong"),
                        rs.getString("ngay_ra_mat")
                ));
            }
            return danhSach;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
