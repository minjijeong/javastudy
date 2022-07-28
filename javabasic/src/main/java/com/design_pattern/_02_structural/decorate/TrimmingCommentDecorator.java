package com.design_pattern._02_structural.decorate;

public class TrimmingCommentDecorator extends CommentDecorator{
    public TrimmingCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    private String trim(String comment){
        return comment.replace("...","");
    }
}
