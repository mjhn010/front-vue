package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Community;

public interface CommunityService {

    // 커뮤니티 등록
    boolean register(Community post);

    // 커뮤니티 목록조회
    List<Community> getList();

    // 커뮤니티 상세조회
    Community getById(Long id);

}
