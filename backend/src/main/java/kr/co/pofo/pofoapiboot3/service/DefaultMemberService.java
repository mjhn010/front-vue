package kr.co.pofo.pofoapiboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.repository.MemberRepository;

@Service
public class DefaultMemberService implements MemberService{
	
	@Autowired
	MemberRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean isValidMember(String uid, String pwd) {
		Member member = repository.findByUid(uid);
		if(member == null)
			return false;
		else if(!member.getPwd().equals(pwd))
			return false;
		return true;
	}

	@Override
	public int signup(Member member) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));  
		return repository.insert(member);
	}
	
	@Override
	public Member getById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public int update(Member member) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));  
		return repository.update(member);
	}
	
	@Override
	public int addUUId(String email, String uuid) {
		return repository.insertUUID(email, uuid);
	}

	@Override
	public String getUUID(String email) {
		return repository.findUUID(email);
	}

	@Override
	public void setPwd(String email, String pwd) {
		pwd = passwordEncoder.encode(pwd); 
		repository.updatePwd(email, pwd);
	}
}
