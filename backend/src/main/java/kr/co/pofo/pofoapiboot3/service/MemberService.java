package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Member;

public interface MemberService {
    int signup(Member member);
    Member getById(int id);
}
