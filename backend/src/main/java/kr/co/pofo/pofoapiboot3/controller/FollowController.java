package kr.co.pofo.pofoapiboot3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.service.DefaultFollowService;

@RestController
@RequestMapping("follow")
public class FollowController {

    @Autowired
    private DefaultFollowService followService;

    @GetMapping("{id}")
    public List<Member> getList(@PathVariable int id, int type){
        List<Member> list = followService.getList(id, type);
        return list;
    }
}
