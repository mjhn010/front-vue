package kr.co.pofo.pofoapiboot3.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityTeamRepository {

    // 팀 등록
    void insert(Long communityId, Long memberId);
    
}
