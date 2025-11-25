package com.example.SD20304SOF3012.scope;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;

@WebServlet(name = "demoServlet1", value = {
        "/demo1"
})
public class DemoServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Hello world");

        HttpSession session = req.getSession();
        session.setAttribute("fromSession", "Cai nay lay tu session");

        ServletContext applicationScope = req.getServletContext();
        applicationScope.setAttribute("applicationMessage", "Cai nay lay tu app");

        req.getRequestDispatcher("/demo2").forward(req, resp);
    }
}
