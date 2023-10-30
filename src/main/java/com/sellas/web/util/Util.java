package com.sellas.web.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

@Component
public class Util {

	public String createCode() {
		
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		String code = "";
		int length = 8;
		
		for(int i = 0; i < length; i++) {
			code += charset.charAt((int)(Math.random() * charset.length()));
		}
		
		return code;
	}
	
	public void sendVerificationCode(String addr, String code) throws EmailException {
		
		HtmlEmail email = new HtmlEmail();
		
		email.setCharset("UTF-8");
		email.setHostName("smtp.office365.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);
		email.setDebug(false);
		
		String html = "<html>";
		html += "<h1>인증 번호 : " + code + "</h1>";
		html += "</html>";
		
		email.setFrom("nexp95@outlook.kr");
		email.setSubject("Verification Code");
		email.addTo(addr);
		email.setHtmlMsg(html);
		
		email.setAuthenticator(new DefaultAuthenticator("nexp95@outlook.kr", "alstjd12"));
		//email.send();
	}
		
}
