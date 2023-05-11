package kr.co.pofo.pofoapiboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.service.MemberService;

@RestController
@RequestMapping("/email")
public class EmailController {
    
    @Autowired
    private MemberService service;
    
    @GetMapping("/sendemail")
    public String sendEmail(String email){
        //이메일 중복확인 용
        int result = service.checkEmail(email);
        if(result == 1)
            return "";
        else {
            service.sendEmail(email);
            return "OK";
        }
    }
    
    //이메일 인증번호 확인
	@GetMapping("check")
	public String checkNum(@RequestParam(name="certificationnum") int number, String email) {
		
        boolean result = service.checkAuthoNum(number, email);
		if(result) 
			return "ok";
		else
			return "";
	}
}
