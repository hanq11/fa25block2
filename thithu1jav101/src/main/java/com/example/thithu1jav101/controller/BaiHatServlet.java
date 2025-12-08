package com.example.thithu1jav101.controller;

import com.example.thithu1jav101.model.BaiHat;
import com.example.thithu1jav101.repository.BaiHatRepository;
import com.example.thithu1jav101.repository.interfaceDemo.BaiHatRepositoryDemo;
import com.example.thithu1jav101.repository.interfaceDemo.BaiHatRepositoryDemoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "baiHatServlet", value = {
        "/bai-hat/hien-thi", // GET
        "/bai-hat/view-update", // GET
        "/bai-hat/delete", // GET
        "/bai-hat/add", // POST
        "/bai-hat/update", // POST
})
public class BaiHatServlet extends HttpServlet {
//    BaiHatRepositoryDemo baiHatRepositoryDemo = new BaiHatRepositoryDemoImpl();

    BaiHatRepository baiHatRepository = new BaiHatRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);

        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", baiHatRepository.getAll());
        req.getRequestDispatcher("/bai-hat/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addBaiHat(req, resp);
        }
    }

    private void addBaiHat(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean errorFlag = false;
        if(req.getParameter("tenBaiHat").isEmpty()) {
            req.setAttribute("errorTenBaiHat", "Ten bai hat khong duoc de trong");
            errorFlag = true;
        }
        if(req.getParameter("gia").isEmpty()) {
            req.setAttribute("errorGia", "Gia khong duoc de trong");
            errorFlag = true;
        }

        if(errorFlag) {
            req.setAttribute("danhSach", baiHatRepository.getAll());
            req.getRequestDispatcher("/bai-hat/hien-thi.jsp").forward(req, resp);
        } else {
            String tenBaiHat = req.getParameter("tenBaiHat");
            Float gia = Float.valueOf(req.getParameter("gia"));
            Integer thoiLuong = Integer.valueOf(req.getParameter("thoiLuong"));
            String ngayRaMat = req.getParameter("ngayRaMat");

            baiHatRepository.add(new BaiHat(null, tenBaiHat, gia, thoiLuong, ngayRaMat));
            resp.sendRedirect("/bai-hat/hien-thi");
        }

    }
}
