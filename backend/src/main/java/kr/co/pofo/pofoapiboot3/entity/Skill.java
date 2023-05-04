package kr.co.pofo.pofoapiboot3.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

	private Integer id;
	private Integer portfolioId;
	private List<String> engNames;
	private List<String> korNames;
	
}
