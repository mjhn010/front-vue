package kr.co.pofo.pofoapiboot3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(String email, String password) {
        Map<String, Object> dto = new HashMap<>();
        dto.put("result", false);
        if(memberService.isValid(email, password)){
            Member member = memberService.getByEmail(email);
            dto.put("result", member);
        }
        return new ResponseEntity<Map<String,Object>>(dto, HttpStatus.OK);
    }
}
