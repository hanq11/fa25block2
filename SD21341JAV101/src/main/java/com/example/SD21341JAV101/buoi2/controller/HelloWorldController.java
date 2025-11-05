package com.example.SD21341JAV101.buoi2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloWorldController", value = {
        "/buoi2/hello-world"
})
public class HelloWorldController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ten", "Nguyen Van A");
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }
}
