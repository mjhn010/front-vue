package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.entity.PortfolioView;
import kr.co.pofo.pofoapiboot3.entity.Skill;
import kr.co.pofo.pofoapiboot3.entity.UsedSkill;
import kr.co.pofo.pofoapiboot3.entity.WeeklyPopularPortfolioView;
import kr.co.pofo.pofoapiboot3.repository.PortfolioRepository;
import kr.co.pofo.pofoapiboot3.repository.SkillRepository;

@Service
public class DefaultPortfolioService implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private SkillRepository skillRepository;
    // 디폴트 포트폴리오 리스트
    @Override
    public List<PortfolioView> getViewList(Integer page, String sort, Integer collaboration, Integer skillId) {
    	
        int size = 15; // 포트폴리오를 한 번에 15개씩 가져옴
        return portfolioRepository.findViewAll(page, size, sort, collaboration, skillId);
    }

    // 검색된 포트폴리오 리스트
    @Override
    public List<PortfolioView> getViewListByQuery(Integer page, String sort, Integer collaboration, String query) {
        int size = 15; // 포트폴리오를 한 번에 15개씩 가져옴

        // query와 관련된 스택이 있는지 확인함
        int[] skillIds = portfolioRepository.findSkillIdsByQuery(query);

        return portfolioRepository.findViewAllByQuery(page, size, sort, collaboration, query, skillIds);
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

    @Override
    public List<Portfolio> getMorePortfolio(Integer portfolioId) {
        Portfolio currentPortfolio = portfolioRepository.findPortfolioById(portfolioId);
        Integer currentPortfolioId = currentPortfolio.getId();
        Integer memberId = currentPortfolio.getMemberId();

        List<Portfolio> list = portfolioRepository.findMorePortfolio(currentPortfolioId, memberId);

        return list;
    }

    @Override
    public List<Portfolio> getByUserId(int id) {
        return portfolioRepository.findByUserId(id);
    }

    // 조회수 증가
    @Override
    public void updatehitCount(Integer id) {
        portfolioRepository.updatehitCount(id);
    }

    // 등록 (제목,썸네일,스킬)
    public boolean regPofo(Portfolio pofo,UsedSkill skills){
        // 될까 ? last_insert_id 안쓰고 될까 ?
        portfolioRepository.insert(pofo);
        Integer pofoId = pofo.getId();
        skills.setPortfolioId(pofoId);
        int result = portfolioRepository.insert(pofo);
        int skillResult = skillRepository.insertUsedSkill(skills);
        if(result == 1 && skillResult == 1)
            return true;
        else
            return false;
    }

    //등록(이미지, 텍스트)
    public boolean regContent(PortfolioContents pofoContent){
        int result = portfolioRepository.contentInsert(pofoContent);
        if(result == 1)
            return true;
        else
            return false;
    }
}
