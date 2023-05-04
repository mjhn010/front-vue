package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.repository.PortfolioContentRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DefaultPortfolioContentService implements PortfolioContentsService {
    PortfolioContentRepository portfolioContentRepository;

    public DefaultPortfolioContentService(PortfolioContentRepository portfolioContentRepository) {
        this.portfolioContentRepository = portfolioContentRepository;
    }

    @Override
    public List<PortfolioContents> selectByPortfolioId(Integer portfolioId) {
        List<PortfolioContents> list = portfolioContentRepository.selectByPortfolioId(portfolioId);
        return list;
    }
}
