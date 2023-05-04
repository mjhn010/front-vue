package kr.co.pofo.pofoapiboot3.entity;

import java.util.Date;

import lombok.Data;

@Data
public class PortfolioComment {
    private Integer id;
    private Integer portfolioId;
    private String content;
    private Date regDate;
    private String memberImageName;
    private String memberNickName;
}
