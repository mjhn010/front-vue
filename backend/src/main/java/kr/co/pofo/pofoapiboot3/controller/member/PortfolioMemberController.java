package kr.co.pofo.pofoapiboot3.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
import kr.co.pofo.pofoapiboot3.util.FileUpload;
@RestController
@RequestMapping("/members")
public class PortfolioMemberController {
    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private FileUpload fileUpload;

    @PostMapping("/regpofo")
    public boolean regPofo(Portfolio portfolio, String [] skills, MultipartFile image) throws Exception{
        //UUID로 파일명 변경
        String modifiedName = fileUpload.modifyImgName(image.getOriginalFilename());
        //파일 업로드 실행
        fileUpload.upload(image, modifiedName);
        //UUID로 변경된 썸네일 이름 portfolio객체에 setting
        portfolio.setThumbnail(modifiedName);

        return true;    
    }

    @PostMapping("/regcontent")
    public boolean regContent(@RequestParam(required = false) MultipartFile contents, 
                   MultipartHttpServletRequest request,PortfolioContents pofoContent,Portfolio pofo) {
       int types = 0;
       String content = "";
       if(contents==null) {
           content = request.getParameter("contents");
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
