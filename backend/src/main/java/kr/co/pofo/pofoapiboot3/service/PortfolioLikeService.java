package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioLike;

public interface PortfolioLikeService {
    List<Portfolio> getByUserId(int id);

    Integer count(Integer portfolioId);

    void insert(PortfolioLike portfolioLike);

    void delete(PortfolioLike portfolioLike);
}
