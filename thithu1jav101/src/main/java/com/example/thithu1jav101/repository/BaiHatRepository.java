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

    public BaiHat getOne(Integer id) {
        String sql = "SELECT * FROM bai_hat WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new BaiHat(
                        rs.getInt("id"),
                        rs.getNString("ten_bai_hat"),
                        rs.getFloat("gia"),
                        rs.getInt("thoi_luong"),
                        rs.getString("ngay_ra_mat")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(BaiHat bh){
        String sql = "INSERT INTO bai_hat(ten_bai_hat,gia,thoi_luong,ngay_ra_mat)VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,bh.getTenBaiHat());
            ps.setFloat(2,bh.getGia());
            ps.setInt(3,bh.getThoiLuong());
            ps.setString(4,bh.getNgayRaMat());
            return ps.executeUpdate()>0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(BaiHat bh){
        String sql = "UPDATE bai_hat SET ten_bai_hat = ?,gia = ?,thoi_luong = ?,ngay_ra_mat = ? WHERE id =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,bh.getTenBaiHat());
            ps.setFloat(2,bh.getGia());
            ps.setInt(3,bh.getThoiLuong());
            ps.setString(4,bh.getNgayRaMat());
            ps.setInt(5,bh.getId());
            return ps.executeUpdate()>0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Integer id) {
        String sql = "DElETE bai_hat WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            return ps.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
