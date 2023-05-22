package kr.co.pofo.pofoapiboot3.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {
	private Integer id;
	private Integer memberId;
	private String title;
	private Integer hit;
	private Date regDate;
	private Date deleteDate;
	private Date awardDate;
	private String thumbnail; 
    private Long likes;
    private Integer collaboration;
	public Portfolio(Integer memberId, String title, String thumbnail, Integer collaboration) {
		this.memberId = memberId;
		this.title = title;
		this.thumbnail = thumbnail;
		this.collaboration = collaboration;
	}
}
