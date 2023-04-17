package com.example.modelemvc.service;

import com.example.modelemvc.model.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    private final Connection connectionToPostDb = ConnectionManager.openConnection();


    public void insertPost(Post post) {
        String title = post.getTitle();
        String author = post.getAuthor();
        String content = post.getContent();
        String pictureUrl = post.getPictureUrl();
        LocalDateTime dateTime = post.getCreatedAt();
        try {
            String query = "INSERT INTO post (title, author, content, pictureUrl, createdAt) VALUES (?,?,?,?,?)";
            PreparedStatement myPreparedStatement = connectionToPostDb.prepareStatement(query);
            myPreparedStatement.setString(1, title);
            myPreparedStatement.setString(2, author);
            myPreparedStatement.setString(3, content);
            myPreparedStatement.setString(4, pictureUrl);
            myPreparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(dateTime));
            myPreparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


    public List<Post> fetchAll() {
        List<Post> allPosts = new ArrayList<>();
        try {
            Statement statement = connectionToPostDb.createStatement();
            String query = "SELECT * FROM post";
            ResultSet results = statement.executeQuery(query);
            while(results.next()) {
                Long id = results.getLong(1);
                String title = results.getString(2);
                String author = results.getString(3);
                String content = results.getString(4);
                String pictureUrl = results.getString(5);
                Post post = new Post(id, title, author, content, pictureUrl);
                allPosts.add(post);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return allPosts;
    }
}
