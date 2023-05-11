package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Comment;
import kr.co.pofo.pofoapiboot3.entity.CommentView;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(Integer portfolioId);

    List<CommentView> getCommentViews(Integer portfolioId);

    void saveComment(Comment comment);

    void deleteComment(Comment comment);
}
