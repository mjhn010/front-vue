package kr.co.pofo.pofoapiboot3.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
	private Integer id;
	private Integer memberId;
	private String title;
	private Integer hit;
	private Date regDate;
	private Date deleteDate;
	private Date awardDate;
	private Integer likes;
}
