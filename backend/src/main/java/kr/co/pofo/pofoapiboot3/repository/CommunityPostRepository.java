package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.CommunityPost;

@Mapper
public interface CommunityPostRepository {

    // 커뮤니티 리스트
    List<CommunityPost> findAll();

    int insert(Long memberId, 
                String title, 
                Boolean onlineType, 
                String locationInfo, 
                String period, 
                Integer teamSize,
                String thumbnail);

}
