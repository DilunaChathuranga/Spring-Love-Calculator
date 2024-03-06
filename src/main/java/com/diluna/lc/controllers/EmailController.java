package com.diluna.lc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.diluna.lc.api.EmailDTO;
import com.diluna.lc.api.UserInfoDTO;
import com.diluna.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private LCAppEmailServiceImpl LCAppEmailService;

	/*This way use for sending data through URL using @pathVariable
	 * @RequestMapping("/send-mail/{username}")
	 * public String sendMail(@PathVariable("username") String username, Model model) {
	 * model.addAttribute("emailDTO", new EmailDTO());
	 * model.addAttribute("username",username); 
	 * return "mail-page";
	 * }
	 */

	/* With Cookies
	@RequestMapping("/send-mail")
	public String sendMail(@CookieValue("LCApp.username") String username, Model model) {

		//set cookie value
		model.addAttribute("username",username);
		
		model.addAttribute("emailDTO", new EmailDTO());
		return "mail-page";
	}
	*/
	
	//With Session
	@RequestMapping("/send-mail")
	public String sendMail(@ModelAttribute("emailDTO") EmailDTO emailDTO) {

		
		return "mail-page";
	}
	
	
/*
	@RequestMapping("/process-mail")
	public String processMail(@ModelAttribute("emailDTO") EmailDTO emailDTO, HttpSession session, Model model) {
		
		String myusername1=(String)session.getAttribute("username");
		String myusername2="Mr : "+myusername1;
		model.addAttribute("username",myusername2);
		//first try to find username from model then it try to fetch username from session
		return "mail-process";
	}
	*/
	
	@RequestMapping("/process-mail")
	public String processMail(@SessionAttribute("UserInfo") UserInfoDTO userInfoDTO,@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		//Calling the SendEmail method
		LCAppEmailService.sendEmail(userInfoDTO.getUsername() , emailDTO.getUserEmail() ,userInfoDTO.getResult());
		
		return "mail-process";
	}
}
