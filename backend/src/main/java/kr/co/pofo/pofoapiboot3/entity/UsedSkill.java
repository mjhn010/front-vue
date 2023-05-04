package kr.co.pofo.pofoapiboot3.entity;

import lombok.Data;

@Data
public class UsedSkill {
    private Integer id;
    private Integer portfolioId;
    private Integer recruitId;
    private Integer skillId;
}
