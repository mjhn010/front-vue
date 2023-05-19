package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Community;

@Mapper
public interface CommunityRepository {

    // 커뮤니티 리스트
    List<Community> findAll();

    // 커뮤니티 레지스터
    int insert(Community post);
}
