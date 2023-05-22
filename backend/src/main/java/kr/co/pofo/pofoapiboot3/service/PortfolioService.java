package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;
import kr.co.pofo.pofoapiboot3.entity.Skill;
import kr.co.pofo.pofoapiboot3.entity.UsedSkill;
import kr.co.pofo.pofoapiboot3.entity.WeeklyPopularPortfolioView;

public interface PortfolioService {
	// 포트폴리오 리스트
    List<PortfolioView> getViewList(Integer page, String sort, Integer collaboration, Integer skillId);

    // 이번주 인기 포트폴리오 리스트
    List<WeeklyPopularPortfolioView> getWeeklyPopularViewList();

    // 검색된 포트폴리오 리스트
    List<PortfolioView> getViewListByQuery(Integer page, String sort, Integer collaboration, String query);
	
	//list 페이지에서 사용하는 getViewList;
	List<PortfolioView> getViewList(String q, String o);
	List<PortfolioView> getViewList(Integer type, String o);
	
	void add(Portfolio pf);

	int getId();

	//  Detail
	Portfolio getPortfolioById(Integer id);

	List<Portfolio> getMorePortfolio(Integer memberId);

	List<Portfolio> getByUserId(int id);

    // 조회수 증가
    void updatehitCount(Integer id);

	// 제목,스킬 등등 
    boolean regPofo(Portfolio pofo, UsedSkill skills);
	//등록 이미지,텍스트
    boolean regContent(PortfolioContents pofoContent);

}
