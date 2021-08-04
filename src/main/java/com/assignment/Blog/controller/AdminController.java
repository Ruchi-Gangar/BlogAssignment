package com.assignment.Blog.controller;

import com.assignment.Blog.model.Comment;
import com.assignment.Blog.model.Post;
import com.assignment.Blog.model.User;
import com.assignment.Blog.model.UserPosts;
import com.assignment.Blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    AdminService adminService;

    @GetMapping("/usersAndPosts")
    public ResponseEntity getUsersAndPosts()
    {
        //Get All Users
        List<User> users = adminService.GetAllUsers();

        //Get All Posts
        List<Post> posts = adminService.GetAllPosts();

        List<UserPosts> userPosts=  users.stream().map(u ->{
            return new UserPosts(
                    u.getId(),
                    getFirstName(u.getName(), " "),
                    u.getName(),
                    posts.stream().filter(p -> p.getUserId() == u.getId()).collect(Collectors.toList()));
        }).collect(Collectors.toList());

        if(userPosts.isEmpty() == true)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(userPosts, HttpStatus.OK);

    }

    @GetMapping("/Comments/Post/{postId}")
    public ResponseEntity getComments(@PathVariable("postId") long Id)
    {
        List<Comment> comments = adminService.GetAllCommentsForPost(Id);

        if(comments.isEmpty() == true)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(comments, HttpStatus.OK);
    }

    private String getFirstName(String str, String separatorRegex) {
        String tokens[] = str.split(separatorRegex);
        return tokens[tokens.length - 2];
    }
}