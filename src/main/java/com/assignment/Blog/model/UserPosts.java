package com.assignment.Blog.model;

import java.util.List;

public class UserPosts {

    public UserPosts(long userId, String firstName, String fullName, List<Post> posts) {
        this.userId = userId;
        this.firstName = firstName;
        this.fullName = fullName;
        this.posts = posts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    private long userId;
    private String firstName;
    private String fullName;
    private List<Post> posts;
}
