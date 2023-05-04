package kr.co.pofo.pofoapiboot3.entity;

import lombok.Data;

@Data
public class PortfolioContents {
    private Integer id;
    private Integer portfolioId;
    private String content;
    private String type;
    private Integer orders;
}
