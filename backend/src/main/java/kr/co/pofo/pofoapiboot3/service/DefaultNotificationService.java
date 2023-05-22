package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Notification;
import kr.co.pofo.pofoapiboot3.repository.NotificationRepository;

@Service
public class DefaultNotificationService implements NotificationService {
    private final NotificationRepository repository;

    public DefaultNotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Notification notification) {
        repository.insert(notification);
    }

    @Override
    public void delete(Notification notification) {
        repository.delete(notification);
    }
    
    public List<Notification> getList(int id){
        return repository.findById(id);
    }

    @Override
    public void createFromProfile(int fromMemberId, int toMemberId) {
        int type = 3;
        repository.insertFromProfile(fromMemberId,toMemberId,type);
    }

}
