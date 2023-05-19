package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;
import kr.co.pofo.pofoapiboot3.entity.WeeklyPopularPortfolioView;

@Mapper
public interface PortfolioRepository {
//	Index
	List<PortfolioView> findViewListByRecentHits();

	List<PortfolioView> findViewListByQuery(String query, String order);

	List<PortfolioView> findViewListByType(Integer type, String order);
	
	// 디폴트 포트폴리오 리스트
    List<PortfolioView> findViewAll(Integer offset, 
                                    int size, 
                                    String sort, 
                                    Integer collaboration, 
                                    Integer skillId);
                                    
    // 검색된 포트폴리오 리스트
    List<PortfolioView> findViewAllByQuery(Integer offset, 
                                            int size, 
                                            String sort, 
                                            Integer collaboration, 
                                            String query,
                                            int[] skillIds);

    // 이번주 인기 포트폴리오 리스트
    List<WeeklyPopularPortfolioView> findWeeklyPopularViewAll();
    
    // 스택 검색
    int[] findSkillIdsByQuery(String query);
	
	void insert(Portfolio pf);

	int findId();

	

//	Detail
	Portfolio findPortfolioById(Integer id);

// myprofile
    List<Portfolio> findByUserId(int id);
    Integer countOfhits(int id);
}
