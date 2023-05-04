package kr.co.pofo.pofoapiboot3.service;

import jakarta.servlet.http.HttpSession;

public interface EmailService {
	
	void sendEmail(String email);
	int createRandomNum ();
	int emailCheck(String email);
	boolean checkAuthoNum(int authoNum, String email);
	String getId(String email);
	void sendLink(String email,HttpSession session);
	int idCheck(String id);
}
