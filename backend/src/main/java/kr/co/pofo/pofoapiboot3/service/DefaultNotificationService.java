package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Notification;
import kr.co.pofo.pofoapiboot3.repository.NotificationRepository;
import org.springframework.stereotype.Service;

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
}
