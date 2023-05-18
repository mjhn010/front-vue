package kr.co.pofo.pofoapiboot3.controller.member;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.pofo.pofoapiboot3.entity.CommunityPost;
import kr.co.pofo.pofoapiboot3.service.CommunityPostService;

import jakarta.servlet.http.HttpServletRequest;

@RestController("memberCommunityPostController")
@RequestMapping("/members/community-post")
public class CommunityPostController {
    
    @Autowired
    private CommunityPostService service;

    @PostMapping("/register")
    public boolean register(MultipartFile image, CommunityPost post, HttpServletRequest request) throws IllegalStateException, IOException{
        post.setThumbnail(image.getOriginalFilename());
        String urlPath ="/communityImage" +File.separator + image.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath(urlPath);
        image.transferTo(new File(realPath));

        boolean result = service.register(post);

        return result;
    }
}
