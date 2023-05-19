package kr.co.pofo.pofoapiboot3.controller.member;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.pofo.pofoapiboot3.entity.CommunityPost;
import kr.co.pofo.pofoapiboot3.service.CommunityPostService;

@RestController("memberCommunityPostController")
@RequestMapping("/members/community")
public class CommunityPostController {
    
    @Autowired
    private CommunityPostService service;

    @PostMapping("register")
    public boolean register(MultipartFile image, CommunityPost post, Boolean onlineType, HttpServletRequest request) throws IllegalStateException, IOException{
        String originalFilename = image.getOriginalFilename();
        String encodedFilename = URLEncoder.encode(originalFilename, "UTF-8");

        //post.setThumbnail(image.getOriginalFilename());
        post.setThumbnail(encodedFilename);

        String urlPath = "/communityImage" +File.separator + encodedFilename;
        String realPath = request.getServletContext().getRealPath(urlPath);
        
        System.out.println("post: " + post);
        System.out.println("urlPath:" + urlPath);
        System.out.println("realPath:" + realPath);
        image.transferTo(new File(realPath));

        boolean result = service.register(post);

        return result;
    }
}
