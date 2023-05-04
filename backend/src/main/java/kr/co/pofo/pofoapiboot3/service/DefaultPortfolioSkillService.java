package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.PortfolioSkill;
import kr.co.pofo.pofoapiboot3.repository.PortfolioSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPortfolioSkillService implements PortfolioSkillService {
    private final PortfolioSkillRepository repository;

    public DefaultPortfolioSkillService(PortfolioSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PortfolioSkill> getSkillByPortfolioId(Integer portfolioId) {
        List<PortfolioSkill> skills = repository.findByPortfolioId(portfolioId);
        return skills;
    }

    @Override
    public void save(PortfolioSkill portfolioSkill) {
        repository.save(portfolioSkill);
    }

    @Override
    public void delete(PortfolioSkill portfolioSkill) {
        repository.delete(portfolioSkill);
    }

}
