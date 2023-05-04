package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Skill;
import kr.co.pofo.pofoapiboot3.entity.UsedSkill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkillRepository {
	List<UsedSkill> findSkillById(Integer id);

	void insert(UsedSkill usedSkill);

	void delete(UsedSkill usedSkill);
}
