package kr.co.pofo.pofoapiboot3.controller.member;

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
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
@RestController
@RequestMapping("/members")
public class PortfolioMemberController {
    @Autowired
    private PortfolioService portfolioService;
    @PostMapping("/regpofo")
    public boolean regPofo(Portfolio pofo, Skill skills){
        

        System.out.println("--------------------------------");
        portfolioService.regPofo(pofo,skills);
        return regPofo(pofo, skills);
    }

    @PostMapping("/regcontent")
    public boolean regContent(@RequestParam(required = false) MultipartFile contents, 
                   MultipartHttpServletRequest request, int orders,PortfolioContents pofoContent) {
       int types = 0;
       String content = "";
       System.out.println("order : " + orders);
       if(contents==null) {
           content = request.getParameter("contents");
           System.out.println(content);
       }
       else {
          types =1;
          content = contents.getOriginalFilename();
          System.out.println(content);
       }
       boolean result = portfolioService.regContent(pofoContent);

       return result;
    }
   
}
