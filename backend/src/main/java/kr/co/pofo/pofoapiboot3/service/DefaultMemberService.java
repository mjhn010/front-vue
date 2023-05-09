package kr.co.pofo.pofoapiboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.repository.MemberRepository;
@Service
public class DefaultMemberService implements MemberService {
    
    @Autowired
    private MemberRepository repository;

    public int signup(Member member) {
        return repository.insert(member);
    };
}
