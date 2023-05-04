package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.PortfolioSkill;

import java.util.List;

public interface PortfolioSkillService {
    List<PortfolioSkill> getSkillByPortfolioId(Integer portfolioId);
    void save(PortfolioSkill portfolioSkill);
    void delete(PortfolioSkill portfolioSkill);
}
