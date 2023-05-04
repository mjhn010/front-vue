package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

public interface CommentService {
    List<PortfolioComment> getComments(Integer portfolioId);

    void saveComment(PortfolioComment comment);

    void deleteComment(PortfolioComment comment);
}
