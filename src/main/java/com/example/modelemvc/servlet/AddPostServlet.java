package com.example.modelemvc.servlet;

import com.example.modelemvc.service.ConnectionManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.modelemvc.service.PostService;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AddPostServlet", value = "/add-post")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Affiche la vue
        request
                .getRequestDispatcher("/WEB-INF/add-post-form.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recupere les données provenant du formulaire
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");

        // Ajoute l'article via le service
        new PostService().createPost(title, author, content);

        // Redirige vers la page /posts
        resp.sendRedirect("posts");
    }

}
