package com.example.SD21341JAV101.buoi12.repository;

import com.example.SD21341JAV101.buoi12.model.SinhVien;
import com.example.SD21341JAV101.buoi12.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository {
    private Connection connection = null;

    public SinhVienRepository() {
        connection = DbConnection.getConnection();
    }

    public List<SinhVien> getAll() {
        String sql = "SELECT * FROM sinh_vien";

        try {
            List<SinhVien> danhSach = new ArrayList();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new SinhVien(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getInt("tuoi"),
                        rs.getFloat("diem"),
                        rs.getBoolean("gioi_tinh")
                ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SinhVien getSinhVienById(Integer id) {
        String sql = "SELECT * FROM sinh_vien WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new SinhVien(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getInt("tuoi"),
                        rs.getFloat("diem"),
                        rs.getBoolean("gioi_tinh")
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteSinhVien(Integer id) {
        String sql = "DELETE FROM sinh_vien WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSinhVien(SinhVien sinhVien) {
        String sql = "INSERT INTO sinh_vien (ten, tuoi, diem, gioi_tinh) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sinhVien.getTen());
            ps.setInt(2, sinhVien.getTuoi());
            ps.setFloat(3, sinhVien.getDiem());
            ps.setBoolean(4, sinhVien.getGioiTinh());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSinhVien(SinhVien sinhVien) {
        String sql = "UPDATE sinh_vien SET ten = ?, tuoi = ?, diem = ?, gioi_tinh = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sinhVien.getTen());
            ps.setInt(2, sinhVien.getTuoi());
            ps.setFloat(3, sinhVien.getDiem());
            ps.setBoolean(4, sinhVien.getGioiTinh());
            ps.setInt(5, sinhVien.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
