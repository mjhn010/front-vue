package kr.co.pofo.pofoapiboot3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Community;
import kr.co.pofo.pofoapiboot3.entity.CommunityView;
import kr.co.pofo.pofoapiboot3.service.CommunityService;

@RestController
@RequestMapping("/community")
public class CommunityController {
    
    @Autowired
    private CommunityService service;

    // 커뮤니티 목록조회
    @GetMapping("list")
    public ResponseEntity<Map<String, Object>> list(){
        
        List<CommunityView> list = service.getViewList();
        
        Map<String, Object> dto = new HashMap<>();
        dto.put("list", list);

        return new ResponseEntity<Map<String, Object>>(dto, HttpStatus.OK);
    }

    // 커뮤니티 상세조회
    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("id") Long id){

        CommunityView community = service.getById(id);
        
        Map<String, Object> dto = new HashMap<>();
        dto.put("community", community);

        return new ResponseEntity<Map<String,Object>>(dto, HttpStatus.OK);
    }
}
