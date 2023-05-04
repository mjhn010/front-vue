package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.PortfolioComment;
import kr.co.pofo.pofoapiboot3.repository.CommentRepository;

@Service
public class DefaultCommentService implements CommentService{
    private final CommentRepository repository;

    public DefaultCommentService(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PortfolioComment> getComments(Integer portfolioId) {
        List<PortfolioComment> portfolioComments = repository.findPortfolioComments(portfolioId);
        return portfolioComments;
    }

    @Override
    public void saveComment(PortfolioComment comment) {

    }

    @Override
    public void deleteComment(PortfolioComment comment) {

    }
}
