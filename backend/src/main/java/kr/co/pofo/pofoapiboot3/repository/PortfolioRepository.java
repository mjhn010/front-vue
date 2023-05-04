package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;

@Mapper
public interface PortfolioRepository {

	List<PortfolioView> findViewListByRecentHits();

	List<PortfolioView> findViewListByQuery(String query, String order);

	List<PortfolioView> findViewListByType(Integer type, String order);
	
	void insert(Portfolio pf);

	int findId();
	
}
