package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;

@Mapper
public interface PortfolioRepository {
//	Index
	List<PortfolioView> findViewListByRecentHits();

	List<PortfolioView> findViewListByQuery(String query, String order);

	List<PortfolioView> findViewListByType(Integer type, String order);
	
	// Index PortfolioView List
	List<PortfolioView> findViewAll(Integer offset, 
                                    int size, 
                                    String sort, 
                                    Integer collaboration, 
                                    Integer skillId);
	
	void insert(Portfolio pf);

	int findId();

	

//	Detail
	Portfolio findPortfolioById(Integer id);
}
