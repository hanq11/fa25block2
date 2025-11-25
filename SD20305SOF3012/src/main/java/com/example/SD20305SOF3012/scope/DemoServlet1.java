package com.example.SD20305SOF3012.scope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoServlet1", value = {
        "/demo1"
})
public class DemoServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("requestMessage", "Cai nay la tu request");

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("sessionMessage", "Cai lay la tu session");

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("applicationMessage", "Cai nay lay tu app");

        req.getRequestDispatcher("/demo2").forward(req, resp);
    }
}
