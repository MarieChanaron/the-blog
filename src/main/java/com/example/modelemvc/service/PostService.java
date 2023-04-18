package com.example.modelemvc.service;
import com.example.modelemvc.model.Post;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostService {

    private static long idSequence;

    private static List<Post> posts = new ArrayList<>(PostService.fetchAllPosts());

    public static List<Post> fetchAllPosts() {
        PostDAO postDAO = new PostDAO();
        return postDAO.fetchAll();
    }

    public Post createPost(String title, String author, String content) {
        Post p = new Post(Long.valueOf(posts.size()), title, author, content, ("https://picsum.photos/200/300?random=" + ++PostService.idSequence), LocalDateTime.now());
        posts.add(p);
        PostDAO postDAO = new PostDAO();
        postDAO.insertPost(p);
        return p;
    }
}
