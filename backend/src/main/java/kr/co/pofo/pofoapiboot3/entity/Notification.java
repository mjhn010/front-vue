package kr.co.pofo.pofoapiboot3.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification {
    private int fromId;
    private int toId;
    private String url;
    private Date regDate;
    private int clicked;
    private int typeId;
    private String nickname;
    private String image;
    private int portfolioId;
    private int communityId;
}

