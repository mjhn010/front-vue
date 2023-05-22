package kr.co.pofo.pofoapiboot3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pofo.pofoapiboot3.entity.Notification;
import kr.co.pofo.pofoapiboot3.service.DefaultNotificationService;
import kr.co.pofo.pofoapiboot3.service.MemberService;

@RestController
@RequestMapping("notification")
public class NotificationController {
    
    @Autowired
    private DefaultNotificationService service;
    @Autowired
    private MemberService memberservice;

    @GetMapping("list/{id}")
    public List<Notification> notificationList(@PathVariable int id){
        List<Notification> list = service.getList(id);
        return list;
    }
}
