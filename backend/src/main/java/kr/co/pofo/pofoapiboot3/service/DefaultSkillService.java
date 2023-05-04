package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Skill;
import kr.co.pofo.pofoapiboot3.repository.SkillRepository;

@Service
public class DefaultSkillService implements SkillService {

	@Autowired
	private SkillRepository repository;
	
	@Override
	public int add(Skill skill) {

		int portfolioId = skill.getPortfolioId();
		List<String> engNames = skill.getEngNames();
		List<String> korNames = skill.getKorNames();
		
		if(engNames.isEmpty())
			return 0;
		
		int nums = engNames.size();
		for(int i=0; i<nums; i++) {
			String engName = engNames.get(i);
			String korName = korNames.get(i);
			repository.insert(portfolioId, engName,korName);
			
		}
		
		
		return 1;

	}

}
