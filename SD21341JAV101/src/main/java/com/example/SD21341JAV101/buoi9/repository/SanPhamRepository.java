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
                        rs.getInt("ma_sp"),
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

    public void themSanPham(SanPham sanPham) {
        String sql = "INSERT INTO san_pham (ten_sp, so_luong, tinh_trang) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sanPham.getTenSP());
            ps.setInt(2, sanPham.getSoLuong());
            ps.setBoolean(3, sanPham.getTinhTrang());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaSanPham(SanPham sanPham) {
        String sql = "UPDATE san_pham SET ten_sp = ?, so_luong = ?, tinh_trang = ? WHERE ma_sp = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sanPham.getTenSP());
            ps.setInt(2, sanPham.getSoLuong());
            ps.setBoolean(3, sanPham.getTinhTrang());
            ps.setInt(4, sanPham.getMaSP());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoaSanPham(Integer maSP) {
        String sql = "DELETE FROM san_pham WHERE ma_sp = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSP);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SanPham chiTiet(Integer maSP) {
        String sql = "SELECT * FROM san_pham WHERE ma_sp = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSP);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new SanPham(
                    rs.getInt("ma_sp"),
                    rs.getString("ten_sp"),
                    rs.getInt("so_luong"),
                    rs.getBoolean("tinh_trang")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
