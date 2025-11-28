package com.example.SD21341JAV101.buoi12.controller;

import com.example.SD21341JAV101.buoi12.model.SinhVien;
import com.example.SD21341JAV101.buoi12.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sinhVienController", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/delete",
        "/sinh-vien/view-update",
        "/sinh-vien/update",
        "/sinh-vien/add",
})
public class SinhVienController extends HttpServlet {
    SinhVienRepository sinhVienRepository = new SinhVienRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("delete")) {
            deleteSinhVien(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sinhVien", sinhVienRepository.getSinhVienById(id));
        req.getRequestDispatcher("/buoi12/view-update.jsp").forward(req, resp);
    }

    private void deleteSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sinhVienRepository.deleteSinhVien(id);
        resp.sendRedirect("/sinh-vien/hien-thi");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", sinhVienRepository.getAll());
        req.getRequestDispatcher("/buoi12/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addSinhVien(req, resp);
        } else if(uri.contains("update")) {
            updateSinhVien(req, resp);
        }
    }

    private void updateSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Float diem = Float.valueOf(req.getParameter("diem"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sinhVien = new SinhVien(id, ten, tuoi, diem, gioiTinh);
        sinhVienRepository.updateSinhVien(sinhVien);

        resp.sendRedirect("/sinh-vien/hien-thi");
    }

    private void addSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Float diem = Float.valueOf(req.getParameter("diem"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sinhVien = new SinhVien(null, ten, tuoi, diem, gioiTinh);
        sinhVienRepository.addSinhVien(sinhVien);

        resp.sendRedirect("/sinh-vien/hien-thi");
    }
}
