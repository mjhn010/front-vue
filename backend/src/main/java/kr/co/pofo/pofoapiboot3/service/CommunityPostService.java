package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.CommunityPost;

public interface CommunityPostService {

    // 커뮤니티 리스트
    List<CommunityPost> getList();

    boolean register(CommunityPost post);

    // void register(Long memberId, String title, Integer locationType, String locationInfo, String period,
    //         Integer teamSize, String thumbnail);

    
}
