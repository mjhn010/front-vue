package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.PortfolioLike;
import kr.co.pofo.pofoapiboot3.repository.PortfolioLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;

@Service
public class DefaultPortfolioLikeServices implements PortfolioLikeService {
    
    @Autowired
    private PortfolioLikeRepository repository;

    @Override
    public List<Portfolio> getByUserId(int id) {
        return repository.findByUserId(id);
    }

    @Override
    public Integer count(int memberId) {
        Integer count = repository.count(memberId);
        return count;
    }

    @Override
    public Integer countByPortfolioId(Integer portfolioId) {
        Integer count = repository.countByPortfolioId(portfolioId);
        return count;
    }

    @Override
    public void insert(PortfolioLike portfolioLike) {
        repository.insert(portfolioLike);
    }

    @Override
    public void delete(PortfolioLike portfolioLike) {
        repository.delete(portfolioLike);
    }
}
