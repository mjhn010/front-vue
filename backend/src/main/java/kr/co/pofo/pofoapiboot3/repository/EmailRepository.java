package kr.co.pofo.pofoapiboot3.repository;

import java.lang.reflect.Member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailRepository {

    int countEmail(String email);

    String findId(String email);

    int findEmail(String email);

    String uuidCheck(String uuid);

}
