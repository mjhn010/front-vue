package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSkillService implements SkillService {

	@Autowired
	private SkillRepository repository;

}
