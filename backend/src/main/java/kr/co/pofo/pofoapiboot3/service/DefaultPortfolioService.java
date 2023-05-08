package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;
import kr.co.pofo.pofoapiboot3.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPortfolioService implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<PortfolioView> getViewList() {
        List<PortfolioView> indexPortfolioViewList = portfolioRepository.findViewListByRecentHits();
        return indexPortfolioViewList;
    }

    // Index PortfolioView List
    @Override
    public List<PortfolioView> getViewList(Integer page, String sort, Integer collaboration, Integer skillId) {
    	
        int size = 15; // 포트폴리오를 한 번에 15개씩 가져옴
        return portfolioRepository.findViewAll(page, size, sort, collaboration, skillId);
    }

    //  Index
    @Override
    public List<PortfolioView> getViewList(String query, String order) {
        List<PortfolioView> list = portfolioRepository.findViewListByQuery(query, order);

        //좋아요로 정렬 시
        return list;
    }

    @Override
    public List<PortfolioView> getViewList(Integer type, String order) {
        List<PortfolioView> list = portfolioRepository.findViewListByType(type, order);

        //좋아요로 정렬 시
        return list;
    }

    @Override
    public void add(Portfolio pf) {
        portfolioRepository.insert(pf);
    }

    @Override
    public int getId() {
        return portfolioRepository.findId();
    }

//  Detail
    @Override
    public Portfolio getPortfolioById(Integer id) {
        return portfolioRepository.findPortfolioById(id);
    }
}
