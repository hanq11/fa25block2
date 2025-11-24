package com.example.tutorsof3012.buoi2.controller;

import com.example.tutorsof3012.buoi2.entity.HocSinh;
import com.example.tutorsof3012.buoi2.entity.TruongHoc;
import com.example.tutorsof3012.buoi2.repository.HocSinhRepository;
import com.example.tutorsof3012.buoi2.repository.TruongHocRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "hocSinhController", value = {
        "/hoc-sinh/hien-thi", // GET
        "/hoc-sinh/view-update", // GET
        "/hoc-sinh/xoa", // GET
        "/hoc-sinh/sua", // POST
        "/hoc-sinh/them", // POST
})
public class HocSinhController extends HttpServlet {
    HocSinhRepository hocSinhRepository = new HocSinhRepository();
    TruongHocRepository truongHocRepository = new TruongHocRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoaHocSinh(req, resp);
        }
    }

    private void xoaHocSinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        hocSinhRepository.deleteHocSinh(id);
        resp.sendRedirect("/hoc-sinh/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("hocSinh", hocSinhRepository.getHocSinhById(id));
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi2/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listHocSinh", hocSinhRepository.getAll());
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themHocSinh(req, resp);
        } else if(uri.contains("sua")) {
            updateHocSinh(req, resp);
        }
    }

    private void updateHocSinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenHocSinh = req.getParameter("tenHocSinh");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean dangHoc = Boolean.valueOf(req.getParameter("dangHoc"));
        Integer idTruongHoc = Integer.valueOf(req.getParameter("truongHoc"));

        TruongHoc truongHoc = truongHocRepository.getTruongHocById(idTruongHoc);
        HocSinh hocSinhMoi = new HocSinh(id, tenHocSinh, tuoi, dangHoc, truongHoc);
        hocSinhRepository.updateHocSinh(hocSinhMoi);
        resp.sendRedirect("/hoc-sinh/hien-thi");
    }

    private void themHocSinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenHocSinh = req.getParameter("tenHocSinh");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean dangHoc = Boolean.valueOf(req.getParameter("dangHoc"));
        Integer idTruongHoc = Integer.valueOf(req.getParameter("truongHoc"));

        TruongHoc truongHoc = truongHocRepository.getTruongHocById(idTruongHoc);

        HocSinh hocSinhMoi = new HocSinh(null, tenHocSinh, tuoi, dangHoc, truongHoc);

        hocSinhRepository.addHocSinh(hocSinhMoi);

        resp.sendRedirect("/hoc-sinh/hien-thi");
    }
}
