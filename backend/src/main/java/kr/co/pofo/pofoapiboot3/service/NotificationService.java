package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import kr.co.pofo.pofoapiboot3.entity.Notification;

public interface NotificationService {
    void create(Notification notification);

    void delete(Notification notification);

    List<Notification> getList(int id);

    void createFromProfile(int requesterId, int requestedId);

    // 팀 신청 확인
    boolean isApplied(Notification notification);
}
