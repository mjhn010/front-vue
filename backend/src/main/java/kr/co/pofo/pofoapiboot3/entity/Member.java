package kr.co.pofo.pofoapiboot3.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private Integer id;
	private String username;
	private String pwd;
	private String nickname;
	private String email;
	private int career;
	private Date regDate;
	private int genderId;
	private String url;
	private String profile;
}
