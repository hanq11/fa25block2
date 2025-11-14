package com.example.SD21341JAV101.buoi4.controller;

import com.example.SD21341JAV101.buoi4.model.SinhVien;
import com.example.SD21341JAV101.buoi4.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/delete", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/update", // POST
        "/sinh-vien/add" // POST
})
public class SinhVienController extends HttpServlet {
    SinhVienService sinhVienService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        SinhVien sinhVien = sinhVienService.getDetailById(id);
        req.setAttribute("sinhVien", sinhVien);
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", sinhVienService.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addSinhVien(req, resp);
        }
    }

    private void addSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sinhVien = new SinhVien(id, ten, tuoi, gioiTinh);
        sinhVienService.addSinhVien(sinhVien);

        resp.sendRedirect("/sinh-vien/hien-thi");
    }
}
