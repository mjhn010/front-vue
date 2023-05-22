package kr.co.pofo.pofoapiboot3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Follow;
import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.service.DefaultFollowService;

@RestController
@RequestMapping("follow")
public class FollowController {

    @Autowired
    private DefaultFollowService followService;

    @GetMapping("{id}")
    public Map<String, Object> getList(@PathVariable int id, int type){
        Map <String , Object> dto = new HashMap<>();
        List<Member> list = followService.getList(id, type);
        dto.put("list", list);
        // 팔로잉하고 있는지 확인 용
        List<Integer> counts = new ArrayList<Integer>();
        for(int i=0; i<list.size(); i++){
            Follow f = new Follow(id, list.get(i).getId());
            int result = followService.checkFollowed(f);
            counts.add(result);
        }
        dto.put("counts", counts);
        return dto;
    }
}
