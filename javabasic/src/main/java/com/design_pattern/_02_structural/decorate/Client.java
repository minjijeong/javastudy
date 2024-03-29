package com.design_pattern._02_structural.decorate;

public class Client {
    private CommentService commentService;
    public Client(CommentService commentService){
        this.commentService = commentService;
    }

    public void writeComment(String comment){
        commentService.addComment(comment);
    }
}
