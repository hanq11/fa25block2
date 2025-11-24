package com.example.SD21341JAV101.buoi9.repository;

import com.example.SD21341JAV101.buoi9.model.SanPham;
import com.example.SD21341JAV101.buoi9.util.DbConnection;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class SanPhamRepository {
    private Connection connection = null;

    public SanPhamRepository() {
        connection = DbConnection.getConnection();
    }

    public List<SanPham> getAll() {
        String sql = "SELECT * FROM san_pham";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<SanPham> danhSach = new ArrayList<>();
            while(rs.next()) {
                danhSach.add(new SanPham(
                        rs.getString("ma_sp"),
                        rs.getString("ten_sp"),
                        rs.getInt("so_luong"),
                        rs.getBoolean("tinh_trang")
                ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
