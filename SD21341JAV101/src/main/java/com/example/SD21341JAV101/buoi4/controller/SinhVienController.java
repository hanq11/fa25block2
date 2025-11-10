package com.example.SD21341JAV101.buoi4.controller;

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
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) {
    }
}
