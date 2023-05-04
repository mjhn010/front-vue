package kr.co.pofo.pofoapiboot3.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.repository.MemberRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@Service
public class DefaultEmailService implements EmailService{
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	private Map <String, Integer> map = new HashMap<>();
	
	// 인증번호 보내기 메서드
	public void sendEmail(String email) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		int randomNum = createRandomNum();
		map.put(email, randomNum);
		try {
			helper.setTo(email);
			helper.setSubject("Portfo 회원가입 인증 이메일");
			helper.setText("이메일 인증번호 : " + randomNum);
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
    public void sendLink(String email,HttpSession session){
		String uuid = UUID.randomUUID().toString();
    	memberService.addUUId(email,uuid);
		session.setAttribute("email", email);
		String subject = "요청 하신 비밀번호 재설정 링크 입니다.";
		String resetPasswordLink = String.format("http://localhost:8080/user/reset?uuid=%s",uuid);
        String body = "<br/>해당링크로 접속하셔서 비밀번호를 변경하실수 있습니다. <br/>" + resetPasswordLink;
        
		MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        sender.send(mimeMessage);
    }
	
	//난수 생성 메서드
	public int createRandomNum () {
		Random ran = new Random();
		int randomNum = (ran.nextInt(500000)+1) + (ran.nextInt(499999)+1);
		return randomNum;
	}
	
	@Override
	public int emailCheck(String email) {
		int result = memberRepository.countEmail(email);
		return result;
	}

	@Override
	public int idCheck(String uid) {
		int result = memberRepository.countId(uid);
		return result;
	}

	@Override
	public boolean checkAuthoNum(int authoNum, String email) {
		if(authoNum == (int)map.get(email)) {
			map.remove(email);
			return true;
		}
		else
			return false;
	}

	@Override
	public String getId(String email) {
		return memberRepository.findId(email);
	}

}
