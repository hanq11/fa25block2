package com.example.SD20304SOF3012.buoi4.controller;

import com.example.SD20304SOF3012.buoi4.model.GiangVien;
import com.example.SD20304SOF3012.buoi4.model.TruongHoc;
import com.example.SD20304SOF3012.buoi4.repository.GiangVienRepository;
import com.example.SD20304SOF3012.buoi4.repository.TruongHocRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "giangVienController", value = {
        "/giang-vien/hien-thi", // GET
        "/giang-vien/delete", // GET
        "/giang-vien/view-update", // GET
        "/giang-vien/update", // POST
        "/giang-vien/add" // POST
})
public class GiangVienController extends HttpServlet {
    GiangVienRepository giangVienRepository = new GiangVienRepository();
    TruongHocRepository truongHocRepository = new TruongHocRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            deleteGiangVien(req, resp);
        }
    }

    private void deleteGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        giangVienRepository.deleteGiangVien(id);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.setAttribute("giangVien", giangVienRepository.getGiangVienById(id));
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.setAttribute("listGiangVien", giangVienRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addGiangVien(req, resp);
        } else if(uri.contains("update")) {
            updateGiangVien(req, resp);
        }
    }

    private void updateGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idTruong = Integer.valueOf(req.getParameter("idTruong"));
        TruongHoc truongHoc = truongHocRepository.getTruongHocById(idTruong);

        GiangVien giangVien = new GiangVien(id, tenGiangVien, tuoi, gioiTinh, truongHoc);
        giangVienRepository.updateGiangVien(giangVien);

        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void addGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idTruong = Integer.valueOf(req.getParameter("idTruong"));
        TruongHoc truongHoc = truongHocRepository.getTruongHocById(idTruong);

        GiangVien giangVien = new GiangVien(null, tenGiangVien, tuoi, gioiTinh, truongHoc);
        giangVienRepository.addGiangVien(giangVien);

        resp.sendRedirect("/giang-vien/hien-thi");
    }
}
