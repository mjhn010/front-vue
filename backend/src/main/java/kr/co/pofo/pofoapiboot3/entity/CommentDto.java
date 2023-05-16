package kr.co.pofo.pofoapiboot3.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private Integer memberId;
    private Integer portfolioId;
    private String content;

    @Builder
    public CommentDto(Integer memberId, Integer portfolioId, String content) {
        this.memberId = memberId;
        this.portfolioId = portfolioId;
        this.content = content;
    }
}
