package kr.co.pofo.pofoapiboot3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.CommunityPost;
import kr.co.pofo.pofoapiboot3.service.CommunityPostService;

@RestController
@RequestMapping("/community")
public class CommunityPostController {
    
    @Autowired
    private CommunityPostService service;

    @GetMapping("list")
    public ResponseEntity<Map<String, Object>> list(){
        
        // 커뮤니티 리스트
        List<CommunityPost> list = service.getList();
        
        Map<String, Object> dto = new HashMap<>();
        dto.put("list", list);

        return new ResponseEntity<Map<String, Object>>(dto, HttpStatus.OK);
    }
}
