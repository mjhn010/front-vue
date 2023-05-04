package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;

import java.util.List;

public interface PortfolioContentsService {
    List<PortfolioContents> selectByPortfolioId(Integer portfolioId);
}
