package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Community;
import kr.co.pofo.pofoapiboot3.entity.CommunityView;
import kr.co.pofo.pofoapiboot3.repository.CommunityRepository;

@Service
public class DefaultCommunityService implements CommunityService {

    @Autowired
    private CommunityRepository repository;
    
    // 커뮤니티 등록
    @Override
    public boolean register(Community post) {
        int result = repository.insert(post);

        if(result == 1) // insert 성공
            return true;
        else            // insert 실패
            return false;
    }

    // 커뮤니티 목록조회
    @Override
    public List<CommunityView> getViewList() {
        return repository.findViewAll();
    }

    // 커뮤니티 상세조회
    @Override
    public CommunityView getById(Long id) {
        return repository.findById(id);
    }

}
