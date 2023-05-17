package kr.co.pofo.pofoapiboot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Activities;
import kr.co.pofo.pofoapiboot3.repository.CollectionsRepository;
import kr.co.pofo.pofoapiboot3.repository.FollowRepository;
import kr.co.pofo.pofoapiboot3.repository.PortfolioLikeRepository;
import kr.co.pofo.pofoapiboot3.repository.PortfolioRepository;

@Service
public class DefaultActivitiesService implements ActivitiesService{
    
    @Autowired
    private PortfolioLikeRepository likeRepository;
    @Autowired
    private CollectionsRepository collectionsRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private FollowRepository followRepository;

    @Override
    public Activities settingActivities(int id) {
        int liked = likeRepository.count(id);
        int colleted = collectionsRepository.count(id);
        int hited = portfolioRepository.countOfhits(id);
        int follower = followRepository.countFollower(id);
        Activities activities = new Activities(hited, liked, colleted, follower,0);
        return activities;
    }
}
