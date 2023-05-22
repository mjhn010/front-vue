package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Skill;
import kr.co.pofo.pofoapiboot3.entity.UsedSkill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkillRepository {
//	Skill
	List<Skill> findAll();

	void insertSkill(Skill skill);

	void updateSkill(Skill skill);

	void deleteSkill(Skill skill);

//	UsedSkill
	List<Skill> findSkillsByPortfolioId(Integer portfolioId);

	// void insertUsedSkill(UsedSkill usedSkill);

	void updateUsedSkill(UsedSkill usedSkill);

	void deleteUsedSkill(UsedSkill usedSkill);


	int insertUsedSkill(UsedSkill usedSkills);
}
