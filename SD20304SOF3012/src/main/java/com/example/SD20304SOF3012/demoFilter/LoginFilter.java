package com.example.SD20304SOF3012.demoFilter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = {
        "/nhan-vien/*",
        "/quan-ly/*"
})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
    }

    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest  = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();

        if(session.getAttribute("taiKhoan") != null) {
            if(httpServletRequest.getRequestURI().contains("/nhan-vien")) {
                chain.doFilter(request, response);
            } else if(httpServletRequest.getRequestURI().contains("/quan-ly")) {
                if(session.getAttribute("chucVu").equals("ql")) {
                    chain.doFilter(request, response);
                } else {
                    httpServletRequest.getRequestDispatcher("/demoFilter/403.jsp").forward(httpServletRequest, httpServletResponse);
                }
            }
        } else {
            httpServletRequest.getRequestDispatcher("/demoFilter/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
//        chain.doFilter(request, response);
    }
}
