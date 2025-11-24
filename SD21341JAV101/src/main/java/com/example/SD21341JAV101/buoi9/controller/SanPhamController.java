package com.example.SD21341JAV101.buoi9.controller;

import com.example.SD21341JAV101.buoi9.model.SanPham;
import com.example.SD21341JAV101.buoi9.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sanPhamController", value = {
        "/san-pham/hien-thi", // GET
        "/san-pham/view-update", // GET
        "/san-pham/xoa", // GET
        "/san-pham/sua", // POST
        "/san-pham/them", // POST
})
public class SanPhamController extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer maSP = Integer.valueOf(req.getParameter("masp"));
        sanPhamRepository.xoaSanPham(maSP);
        resp.sendRedirect("/san-pham/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer maSP = Integer.valueOf(req.getParameter("masp"));
        req.setAttribute("sanPham", sanPhamRepository.chiTiet(maSP));
        req.getRequestDispatcher("/buoi9/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", sanPhamRepository.getAll());
        req.getRequestDispatcher("/buoi9/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themSanPham(req, resp);
        } else if(uri.contains("sua")) {
            suaSanPham(req, resp);
        }
    }

    private void suaSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer maSP = Integer.valueOf(req.getParameter("maSP"));
        String tenSP = req.getParameter("tenSP");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean tinhTrang = Boolean.valueOf(req.getParameter("tinhTrang"));

        SanPham sp = new SanPham(maSP, tenSP, soLuong, tinhTrang);
        sanPhamRepository.suaSanPham(sp);

        resp.sendRedirect("/san-pham/hien-thi");
    }

    private void themSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenSP = req.getParameter("tenSP");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean tinhTrang = Boolean.valueOf(req.getParameter("tinhTrang"));

        SanPham sp = new SanPham(null, tenSP, soLuong, tinhTrang);
        sanPhamRepository.themSanPham(sp);

        resp.sendRedirect("/san-pham/hien-thi");
    }
}
