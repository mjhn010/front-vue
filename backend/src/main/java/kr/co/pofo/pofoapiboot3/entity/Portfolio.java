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
	private int prjTypeId;
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
	private Integer likes;
	
	public Portfolio(Integer id, Integer memberId, String title) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.title = title;
	}
}
