package kr.co.pofo.pofoapiboot3.service;

import kr.co.pofo.pofoapiboot3.entity.Notification;

public interface NotificationService {
    void create(Notification notification);

    void delete(Notification notification);
}
