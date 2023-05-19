package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Community;

public interface CommunityService {

    // 커뮤니티 리스트
    List<Community> getList();

    boolean register(Community post);

}
