package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;
import kr.co.pofo.pofoapiboot3.entity.WeeklyPopularPortfolioView;
import kr.co.pofo.pofoapiboot3.repository.PortfolioRepository;

@Service
public class DefaultPortfolioService implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    
    // 포트폴리오 리스트
    @Override
    public List<PortfolioView> getViewList(Integer page, String sort, Integer collaboration, Integer skillId) {
    	
        int size = 15; // 포트폴리오를 한 번에 15개씩 가져옴
        return portfolioRepository.findViewAll(page, size, sort, collaboration, skillId);
    }

    // 이번주 인기 포트폴리오 리스트
    @Override
    public List<WeeklyPopularPortfolioView> getWeeklyPopularViewList() {

        return portfolioRepository.findWeeklyPopularViewAll();
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
