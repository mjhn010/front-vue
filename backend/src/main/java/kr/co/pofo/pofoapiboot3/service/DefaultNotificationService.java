package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Notification;
import kr.co.pofo.pofoapiboot3.repository.NotificationRepository;

@Service
public class DefaultNotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getList(int id){
        return notificationRepository.findById(id);
    }

}
