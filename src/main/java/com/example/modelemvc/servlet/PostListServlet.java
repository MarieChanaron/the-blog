package com.example.modelemvc.servlet;

import com.example.modelemvc.model.Post;
import com.example.modelemvc.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/", "/posts"})
public class PostListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostService();
        List<Post> postList = postService.fetchAllPosts();

        req.setAttribute("posts", postList);
        req
                .getRequestDispatcher("/WEB-INF/post-list.jsp")
                .forward(req, resp);
    }
}


