package com.example.SD20304SOF3012.demoFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginController", value = {
        "/demo-filter/login", // POST
        "/demo-filter/logout" // GET
})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            session.invalidate();
            req.getRequestDispatcher("/demoFilter/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // nv: abc - 123
        // ql: xyz - 234
        if(
                (username.equals("abc") && password.equals("123"))
                        || (username.equals("xyz") && password.equals("234"))
        ) {
            HttpSession session = req.getSession();
            session.setAttribute("taiKhoan", username);

            if(username.equals("abc")) {
                session.setAttribute("chucVu", "nv");
                resp.sendRedirect("/nhan-vien");
            } else {
                session.setAttribute("chucVu", "ql");
                resp.sendRedirect("/quan-ly");
            }
        } else {
            req.setAttribute("message", "Sai thong tin dang nhap");
            req.getRequestDispatcher("/demoFilter/login.jsp").forward(req, resp);
        }
    }
}
