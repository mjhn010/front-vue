package kr.co.pofo.pofoapiboot3.entity;

import java.util.Date;

import lombok.Data;

@Data
public class PortfolioDetail {
    private Integer id;
    private String PrjTypeName;
    private String title;
    private String description;
    private String teamInfo;
    private String epilogue;
    private String video;
    private Integer hit;
    private Integer deleteStatus;
    private Date regDate;
    private Date modifiedDate;
    private Date deleteDate;
}
