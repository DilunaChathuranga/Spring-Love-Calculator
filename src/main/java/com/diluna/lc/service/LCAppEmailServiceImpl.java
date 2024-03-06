package com.diluna.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


//@Service is same as Component.we use it bcz it is a Servive class
@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

	@Autowired
	private JavaMailSender javaMailSenderImpl;
	
	@Override
	public void sendEmail(String username,String userEmail,String result) {
		
		SimpleMailMessage newMail=new SimpleMailMessage();
		//newMail.setFrom("kmac617udee@gmail.com");
		newMail.setTo(userEmail);
		newMail.setSubject("Love Calculator Result");
		newMail.setText("Hi "+username+ " The result Predicted by the LCAPP is "+result);
		System.out.println("Inside Send Mail to set properties");
		
		javaMailSenderImpl.send(newMail);

	}

}
