package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Community;
import kr.co.pofo.pofoapiboot3.repository.CommunityRepository;

@Service
public class DefaultCommunityService implements CommunityService {

    @Autowired
    private CommunityRepository repository;
    
    // 커뮤니티 리스트
    @Override
    public List<Community> getList() {
        return repository.findAll();
    }

    // 커뮤니티 레지스터
    @Override
    public boolean register(Community post) {
        int result = repository.insert(post);

        if(result == 1) // insert 성공
            return true;
        else            // insert 실패
            return false;
    }

}
