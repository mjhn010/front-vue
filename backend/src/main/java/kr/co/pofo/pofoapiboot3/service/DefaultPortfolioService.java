package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;
import kr.co.pofo.pofoapiboot3.repository.PortfolioRepository;
import kr.co.pofo.pofoapiboot3.repository.SkillRepository;

@Service
public class DefaultPortfolioService implements PortfolioService {
	
	@Autowired
	private PortfolioRepository portfolioRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Override
	public List<PortfolioView> getViewList() {
		List<PortfolioView> indexPortfolioViewList = portfolioRepository.findViewListByRecentHits();
		return indexPortfolioViewList;
	}

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
}
