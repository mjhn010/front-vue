package kr.co.pofo.pofoapiboot3.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioView extends Portfolio {
	private String imageName;
	private Integer weeklyTotalHits;
	private List<String> skillNames;
}
