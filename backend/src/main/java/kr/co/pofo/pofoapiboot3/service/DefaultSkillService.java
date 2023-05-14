package kr.co.pofo.pofoapiboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.repository.SkillRepository;

@Service
public class DefaultSkillService implements SkillService {

	@Autowired
	private SkillRepository repository;

}
