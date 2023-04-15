package com.example.modelemvc.service;
import com.example.modelemvc.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostService {

    private static long idSequence = 0;

    private static List<Post> posts = new ArrayList<>(
        Arrays.asList(
            new Post(1L, "title 1", "author 1", "content 1", ("https://picsum.photos/200/300?random=" + ++idSequence)), // Lettre L pour signifier que le id est un Long (sinon Java le considère comme un int)
            new Post(2L, "title 2", "author 2", "content 2", ("https://picsum.photos/200/300?random=" + ++idSequence)),
            new Post(3L, "title 3", "author 3", "content 3", ("https://picsum.photos/200/300?random=" + ++idSequence))
        )
    );


    public List<Post> fetchAllPosts() {
        return this.posts;
    }

    public Post createPost(String title, String author, String content) {
        Post p = new Post(Long.valueOf(posts.size()), title, author, content, ("https://picsum.photos/200/300?random=" + ++idSequence));
        posts.add(p);
        return p;
    }
}
