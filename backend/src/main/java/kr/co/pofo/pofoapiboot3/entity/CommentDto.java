package kr.co.pofo.pofoapiboot3.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommentDto {
    private Integer memberId;
    private Integer portfolioId;
    private String content;
}
