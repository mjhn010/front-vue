package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Member;

public interface MemberService {
    //회원가입
    int signup(Member member);
    Member getById(int id);
    //로그인 아이디, 비밀번호 확인
    boolean isValid(String email, String pwd);
    //이메일로 회원정보 가져오기
    public Member getByEmail(String email);

}
