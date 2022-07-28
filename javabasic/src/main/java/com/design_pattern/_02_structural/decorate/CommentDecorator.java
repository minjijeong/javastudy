package com.design_pattern._02_structural.decorate;

public class CommentDecorator implements CommentService {
    private CommentService commentService;

    public CommentDecorator(CommentService commentService){
        this.commentService = commentService;
    }
    @Override
    public void addComment(String comment) {
        commentService.addComment(comment);
    }
}
