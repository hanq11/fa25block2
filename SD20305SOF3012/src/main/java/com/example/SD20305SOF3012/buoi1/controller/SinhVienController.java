package com.example.SD20305SOF3012.buoi1.controller;

import com.example.SD20305SOF3012.buoi1.model.SinhVien;
import com.example.SD20305SOF3012.buoi1.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sinhVienController", value = {
        "/buoi1/hien-thi",  // GET
        "/buoi1/view-update", // GET
        "/buoi1/add", // POST
        "/buoi1/update", // POST
        "/buoi1/delete", // GET
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

        resp.sendRedirect("/buoi1/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sinhVien", sinhVienRepository.findById(id));
        req.getRequestDispatcher("/buoi1/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSinhVien", sinhVienRepository.findAll());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
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

    private void addSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sv = new SinhVien(null, ten, tuoi, gioiTinh);

        sinhVienRepository.addSinhVien(sv);

        resp.sendRedirect("/buoi1/hien-thi");
    }

    private void updateSinhVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        SinhVien sv = new SinhVien(id, ten, tuoi, gioiTinh);

        sinhVienRepository.updateSinhVien(sv);

        resp.sendRedirect("/buoi1/hien-thi");
    }
}
