package kr.co.pofo.pofoapiboot3.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notification {
    private Integer id;
    private Integer typeId;
    private Integer fromMemberId;
    private Integer toMemberId;
    private Integer commentId;
    private Date regDate;
    private Integer clickFlag;
}
