package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.PortfolioSkill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PortfolioSkillRepository {
    List<PortfolioSkill> findByPortfolioId(Integer portfolioId);
    void save(PortfolioSkill portfolioSkill);
    void delete(PortfolioSkill portfolioSkill);
}
