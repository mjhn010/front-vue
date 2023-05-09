package kr.co.pofo.pofoapiboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Member;
import kr.co.pofo.pofoapiboot3.service.MemberService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public String signup(Member member) {
        memberService.signup(member);
        return "ok";
    }
}
