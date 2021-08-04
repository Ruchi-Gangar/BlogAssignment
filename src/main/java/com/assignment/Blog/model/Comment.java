package com.assignment.Blog.model;

public class Comment {

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private long Id;
    private long postId;
    private String name;
    private String body;
    private String email;
}
