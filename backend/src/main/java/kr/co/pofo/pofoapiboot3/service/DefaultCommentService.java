package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Comment;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.repository.CommentRepository;

@Service
public class DefaultCommentService implements CommentService{
    private final CommentRepository repository;

    public DefaultCommentService(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Comment> getCommentsByPortfolioId(Integer portfolioId) {
        List<Comment> portfolioComments = repository.findPortfolioComments(portfolioId);
        return portfolioComments;
    }

    @Override
    public void saveComment(Comment comment) {
        return;
    }

    @Override
    public void deleteComment(Comment comment) {
        return;
    }
}
