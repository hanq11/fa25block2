package com.example.SD20305SOF3012.scope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "demoServlet2", value = {
        "/demo2"
})
public class DemoServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestMessage = (String) req.getAttribute("requestMessage");
        System.out.println(requestMessage);

        HttpSession httpSession = req.getSession();
        System.out.println((String) httpSession.getAttribute("sessionMessage"));

        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext.getAttribute("applicationMessage"));

        req.getRequestDispatcher("/scope/hien-thi.jsp").forward(req, resp);
    }
}
