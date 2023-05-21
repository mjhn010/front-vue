package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Community;

@Mapper
public interface CommunityRepository {

    // 커뮤니티 등록
    int insert(Community post);

    // 커뮤니티 목록조회
    List<Community> findAll();

    // 커뮤니티 상세조회
    Community findById(Long id);
}
