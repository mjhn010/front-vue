package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPortfolioId(Integer portfolioId);

    void saveComment(Comment comment);

    void deleteComment(Comment comment);
}
