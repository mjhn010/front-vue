package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.repository.PortfolioDetailRepository;
import kr.co.pofo.pofoapiboot3.entity.PortfolioDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class DefaultPortfolioDetailService implements PortfolioDetailService {
    private final PortfolioDetailRepository repository;

    public DefaultPortfolioDetailService(PortfolioDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    @ResponseBody
    public PortfolioDetail get(Integer id) {
        PortfolioDetail portfolioDetail = repository.findPortfolioDetail(id);
        return portfolioDetail;
    }
}
