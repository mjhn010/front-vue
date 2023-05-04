package kr.co.pofo.pofoapiboot3.entity;

import lombok.Data;

@Data
public class Report {
    private Integer id;
    private Integer memberId;
    private String url;
    private String content;
    private String regDate;
}
