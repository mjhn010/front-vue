package kr.co.pofo.pofoapiboot3.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class PortfolioView extends Portfolio {
	private String imageName;
	private Integer weeklyTotalHits;
	private List<String> skillNames;

	// shl
	private String nickname;
    private String memberImage;
    private Long likeCount;
    private String skillIds;
}
