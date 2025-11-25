package com.example.SD20304SOF3012.scope;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoServlet2", value = {
        "/demo2"
})
public class DemoServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = (String) req.getAttribute("message");
        System.out.println(message);

        HttpSession session = req.getSession();
        System.out.println((String) session.getAttribute("fromSession"));

        req.getRequestDispatcher("/scope/hien-thi.jsp").forward(req, resp);
    }
}
