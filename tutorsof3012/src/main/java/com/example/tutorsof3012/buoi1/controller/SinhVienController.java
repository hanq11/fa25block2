package com.example.tutorsof3012.buoi1.controller;

import com.example.tutorsof3012.buoi1.entity.SinhVien;
import com.example.tutorsof3012.buoi1.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.Inet4Address;

@WebServlet(name = "sinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/delete", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/update", // POST
        "/sinh-vien/add" // POST
})
public class SinhVienController extends HttpServlet {
    SinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sinhVienRepository.deleteSinhVien(id);
        resp.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sinhVien", sinhVienRepository.getSinhVienById(id));
        req.getRequestDispatcher("/buoi1/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSinhVien", sinhVienRepository.getAll());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addSinhVien(req, resp);
        } else if(uri.contains("update"))
            updateSinhVien(req, resp);
    }

    private void updateSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        Integer namSinh = Integer.valueOf(req.getParameter("namSinh"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sv = new SinhVien(id, ten, diaChi, namSinh, gioiTinh);

        sinhVienRepository.updateSinhVien(sv);

        resp.sendRedirect("/sinh-vien/hien-thi");
    }

    private void addSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        Integer namSinh = Integer.valueOf(req.getParameter("namSinh"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sv = new SinhVien(null, ten, diaChi, namSinh, gioiTinh);

        sinhVienRepository.addSinhVien(sv);

        resp.sendRedirect("/sinh-vien/hien-thi");
    }
}
