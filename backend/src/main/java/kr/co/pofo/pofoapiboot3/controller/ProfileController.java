package kr.co.pofo.pofoapiboot3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Activities;
import kr.co.pofo.pofoapiboot3.entity.Follow;
import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.service.ActivitiesService;
import kr.co.pofo.pofoapiboot3.service.CollectionsService;
import kr.co.pofo.pofoapiboot3.service.DefaultFollowService;
import kr.co.pofo.pofoapiboot3.service.MemberService;
import kr.co.pofo.pofoapiboot3.service.PortfolioLikeService;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private MemberService service;
    @Autowired
    private PortfolioService pofoService;
    @Autowired
    private PortfolioLikeService portfolioLikeService;
    @Autowired
    private CollectionsService collectionsService;
    @Autowired
    private ActivitiesService activitiesService;
    @Autowired
    private DefaultFollowService followService;

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> myProfile(@PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<>();
        Member member = service.getById(id);
        map.put("member", member);

        List<Portfolio> works = pofoService.getByUserId(id);
        map.put("works", works);

        List<Portfolio> likes = portfolioLikeService.getByUserId(id);
        map.put("likes", likes);

        List<Portfolio> collections = collectionsService.getByUserId(id);
        map.put("collections", collections);

        Activities activities = activitiesService.settingActivities(id);
        map.put("activities", activities);

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    //팔로우 확인
    @PostMapping("isFollowed")
    public String isFollowed(Follow follow){
        int result = followService.checkFollowed(follow);
        if(result == 0){
            return "no";
        }
        return "yes";
    }

    //팔로우
    @PostMapping("follow")
    public String following(Follow follow) {
        System.out.println(follow);
        int result = followService.add(follow);
        System.out.println(result);
        return "";
    }
    //팔로우 취소
    @DeleteMapping("follow")
    public String followCancle(Follow follow) {
        int result = followService.delete(follow);
        System.out.println(result);
        return "";
    }
}