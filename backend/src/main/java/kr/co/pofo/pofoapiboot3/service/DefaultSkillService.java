package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.repository.SkillRepository;


import java.util.List;


@Service
public class DefaultSkillService implements SkillService {

	@Autowired
	private SkillRepository repository;

	@Override
	public List<Skill> getSkillsByPortfolioId(Integer portfolioId) {
		return repository.findSkillsByPortfolioId(portfolioId);
	}

	



	
}
