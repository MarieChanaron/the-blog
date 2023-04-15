package com.example.modelemvc.servlet;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/add-post"})
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            if (session.getAttribute("username").equals("admin")) {
                // Continue la chaine des filtres/navigations
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
