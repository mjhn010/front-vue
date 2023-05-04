package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Member;

public interface MemberService {
	boolean isValidMember(String uid, String pwd);
	int signup(Member member);
	Member getById(Integer id);
	int update(Member member);
	int addUUId(String email, String uuid);
	String getUUID(String email);
	void setPwd(String email, String pwd);
}
