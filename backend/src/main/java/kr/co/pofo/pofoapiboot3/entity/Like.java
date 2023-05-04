package kr.co.pofo.pofoapiboot3.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Like {
    private Integer id;
    private Integer memberId;
    private Integer portfolioId;
    private Date likedDate;
}
