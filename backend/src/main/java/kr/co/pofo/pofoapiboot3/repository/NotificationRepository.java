package kr.co.pofo.pofoapiboot3.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.pofo.pofoapiboot3.entity.Notification;

@Mapper
public interface NotificationRepository {

    List<Notification> findById(int id);

}
