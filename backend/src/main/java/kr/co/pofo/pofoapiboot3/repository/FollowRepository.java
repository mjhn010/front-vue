package kr.co.pofo.pofoapiboot3.repository;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Follow;

@Mapper
public interface FollowRepository {
    int insert(Follow follow);
    int delete(Follow follow);
    int countFollower(int id);
    // int countFollowing(int id);
    
    int count(Follow follow);
}
