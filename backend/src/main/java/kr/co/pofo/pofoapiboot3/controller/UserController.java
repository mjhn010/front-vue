package kr.co.pofo.pofoapiboot3.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Member;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signup")
    public String signup(Member user) {
        System.out.println(user.toString());
        return "";
    }
}
