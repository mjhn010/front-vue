package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.CommunityPost;
import kr.co.pofo.pofoapiboot3.repository.CommunityPostRepository;

@Service
public class DefaultCommunityPostService implements CommunityPostService {

    @Autowired
    private CommunityPostRepository repository;
    
    // 커뮤니티 리스트
    @Override
    public List<CommunityPost> getList() {
        return repository.findAll();
    }

    @Override
    public boolean register(CommunityPost post) {
        Long memberId = post.getMemberId();
        String title = post.getTitle();
        Boolean onlineType = post.getOnlineType();
        String locationInfo = post.getLocationInfo();
        String period = post.getPeriod();
        Integer teamSize = post.getTeamSize();
        String thumbnail = post.getThumbnail();

        int result = repository.insert(memberId, title, onlineType, locationInfo, period, teamSize, thumbnail);

        if(result == 1) // insert 성공
            return true;
        else            // insert 실패
            return false;
    }

    // @Override
    // public void register(Long memberId, String title, Integer locationType, String locationInfo, String period,
    //         Integer teamSize, String thumbnail) {
    //     repository.insert(memberId, title, locationType, locationInfo, period, teamSize, thumbnail);
    // }

}
