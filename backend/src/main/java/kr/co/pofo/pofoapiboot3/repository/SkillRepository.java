package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkillRepository {
	List<String> findSkillById(Integer id);
	void insert(int portfolioId, String engName, String korName);
}
