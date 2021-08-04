package com.assignment.Blog.service;

import com.assignment.Blog.model.Comment;
import com.assignment.Blog.model.Post;
import com.assignment.Blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    public List<User> GetAllUsers() {
        ResponseEntity<List<User>> allUsers =
                restTemplate.exchange(
                        "https://jsonplaceholder.typicode.com/users",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<User>>() {
                        }
                );
        return allUsers.getBody();
    }

    public List<Post> GetAllPosts() {
        ResponseEntity<List<Post>> allPosts =
                restTemplate.exchange(
                        "https://jsonplaceholder.typicode.com/posts",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Post>>() {}
                );

        return allPosts.getBody();
    }

    public List<Comment> GetAllComments() {
        ResponseEntity<List<Comment>> allComments =
                restTemplate.exchange(
                        "https://jsonplaceholder.typicode.com/comments",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Comment>>() {}
                );

        return allComments.getBody();
    }

    public List<Comment> GetAllCommentsForPost(long postId) {
        ResponseEntity<List<Comment>> allComments =
                restTemplate.exchange(
                        "https://jsonplaceholder.typicode.com/comments",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Comment>>() {}
                );

        return allComments.getBody().stream().filter(c -> c.getPostId() == postId).collect(Collectors.toList());
    }
}
