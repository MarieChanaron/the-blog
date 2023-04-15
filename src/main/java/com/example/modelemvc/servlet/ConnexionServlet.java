package com.example.modelemvc.servlet;

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

        if (surname.equals("admin") && password.equals("admin")) {
            session.setAttribute("username", surname);
        } else if (surname.length() > 0) {
            session.setAttribute("username", surname);
        }

        response.sendRedirect("/");
    }
}
