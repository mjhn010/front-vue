package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.PortfolioImage;
import kr.co.pofo.pofoapiboot3.repository.PortfolioImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPortfolioImageService implements PortfolioImageService {
    private final PortfolioImageRepository repository;

    public DefaultPortfolioImageService(PortfolioImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortfolioImage getMemberImage(Integer memberId) {
        PortfolioImage memberPortfolioImage = repository.findNameByMemberId(memberId);
        return memberPortfolioImage;
    }

    @Override
    public List<PortfolioImage> getImageByPortfolioId(Integer portfolioId) {
        List<PortfolioImage> portfolioImageNames = repository.findNamesByPortfolioId(portfolioId);
        return portfolioImageNames;
    }
}
