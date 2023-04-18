package com.example.modelemvc.service;
import com.example.modelemvc.dbConnection.PostDAO;
import com.example.modelemvc.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private static int idSequence;

    public List<Post> fetchAllPosts() {
        PostDAO postDAO = new PostDAO();
        List<Post> posts = postDAO.fetchAll();
        idSequence = posts.size();
        return posts;
    }

    public Post createPost(String title, String author, String content) {
        Post p = new Post(title, author, content, ("https://picsum.photos/200/300?random=" + ++idSequence), LocalDateTime.now());
        PostDAO postDAO = new PostDAO();
        postDAO.insertPost(p);
        return p;
    }
}
