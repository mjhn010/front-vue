package kr.co.pofo.pofoapiboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Follow;
import kr.co.pofo.pofoapiboot3.repository.FollowRepository;

@Service
public class DefaultFollowService {
    @Autowired
    private FollowRepository followRepository;

    public int add(Follow follow) {
        int result = followRepository.insert(follow);
        return result;
    }
    public int delete(Follow follow) {
        int result = followRepository.delete(follow);
        return result;
    }
    public int checkFollowed(Follow follow) {
        int result = followRepository.count(follow);
        return result;
    }
}
