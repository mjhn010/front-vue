package kr.co.pofo.pofoapiboot3.controller.member;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.entity.Skill;
import kr.co.pofo.pofoapiboot3.entity.UsedSkill;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
@RestController
@RequestMapping("/members")
public class PortfolioMemberController {
    @Autowired
    private PortfolioService portfolioService;
    @PostMapping("/regpofo")
    public boolean regPofo(Portfolio pofo, String[] skills,Integer memberId) throws IllegalStateException, IOException{
        System.out.println("나나나나나나나나나나나나난나나나나나나나나나나나나나난나나ㅏ난나나난나나나");
        System.out.println("----------------------------------");
        System.out.println("gkgkgkgkgkkgk         "+pofo);
        System.out.println(skills.length);
        System.out.println(memberId);
        
        

        
        portfolioService.regPofo(pofo, skills);
        return true;
    }

    @PostMapping("/regcontent")
    public boolean regContent(@RequestParam(required = false) MultipartFile contents, 
                   MultipartHttpServletRequest request,PortfolioContents pofoContent,Portfolio pofo) {
       int types = 0;
       String content = "";
    //    System.out.println("order : " + orders);
       if(contents==null) {
           content = request.getParameter("contents");
           System.out.println(content);
       }
       else {
          types =1;
          content = contents.getOriginalFilename();
          pofoContent.setContent(content);
          System.out.println(content);
       }
       boolean result = portfolioService.regContent(pofo,pofoContent);

       return result;
    }
   
}
