package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.repository.PortfolioLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Activities;
import kr.co.pofo.pofoapiboot3.repository.CollectionsRepository;
import kr.co.pofo.pofoapiboot3.repository.PortfolioRepository;

@Service
public class DefaultActivitiesService implements ActivitiesService{
    
    @Autowired
    private PortfolioLikeRepository likeRepository;
    @Autowired
    private CollectionsRepository collectionsRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Activities settingActivities(int id) {
        int liked = likeRepository.count(id);
        int colleted = collectionsRepository.count(id);
        int hited = portfolioRepository.countOfhits(id);
        Activities activities = new Activities(hited, liked, colleted);
        return activities;
    }
}
