package com.example.modelemvc.servlet;

import com.example.modelemvc.service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (AdminService.checkAdminCredentials(surname, password)) {
            session.setAttribute("username", surname);
        } else if (surname.length() > 0) {
            session.setAttribute("username", surname);
        }

        response.sendRedirect("/");
    }
}
