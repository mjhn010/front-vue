package kr.co.pofo.pofoapiboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.repository.MemberRepository;
@Service
public class DefaultMemberService implements MemberService {
    
    @Autowired
    private MemberRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public int signup(Member member) {
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        return repository.insert(member);
    }

    @Override
    public boolean isValid(String email, String password) {
        Member member = getByEmail(email);
        if(member == null)
            return false;
            
        else if (!BCrypt.checkpw(password, member.getPwd()))
            return false;
        
        return true;
    }

    @Override
    public Member getByEmail(String email){
        return repository.findByEmail(email);   
    }
}
