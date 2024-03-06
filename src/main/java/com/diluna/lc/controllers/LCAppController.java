package com.diluna.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.diluna.lc.api.UserInfoDTO;
import com.diluna.lc.service.LCAppService;

//We can only store model attr inside sessionAttributes
//@SessionAttributes and @ModelAttribute both can't work together.We have to use add manually model attribute
@SessionAttributes("UserInfo")
@Controller
public class LCAppController {
	
	@Autowired
	private LCAppService lcAppservice;
	
	//*Two way data binding Happen here
	//Read from DTO and write to Web Form
	//Read from Web From data and write to DTO
	
	//With @SessionAttributes
	@RequestMapping("/")
	//Read from DTO and write to Web Form
	public String showHomePage(Model model) {
	
	
		model.addAttribute("UserInfo", new UserInfoDTO());
			
		return "home-page";
	}
	
	/*
	@RequestMapping("/")
	//Read from DTO and write to Web Form
	public String showHomePage(@ModelAttribute("UserInfo") UserInfoDTO userinfodto, HttpServletRequest request) {
		//read the default properties fetching from DTO class(READ)
		
	
		//we replace these 2 line with @ModelAttribute annotation
		UserInfoDTO userinfo=new UserInfoDTO();
		model.addAttribute("UserInfo",userinfo);
		
		//Load Username if user already enter his name using Cookies
		//Cookie Method	
		Cookie[] cookies= request.getCookies();
		for(Cookie temp:cookies) {
			if("LCApp.username".equals(temp.getName())) {
				String myUsername=temp.getValue();
				userinfodto.setUsername(myUsername);
			}
		}
		
			
		return "home-page";
	}
	*/
	
	/*
	 //Using RequestParam Data Binding
	@RequestMapping("/process-homepage")
	public String processHomePage(@RequestParam String username, @RequestParam String crushname, Model model) {
		System.out.println(username+" "+crushname);
		
		//send data from controller to view using Model
		model.addAttribute("Username",username);
		model.addAttribute("Crushname",crushname);
		
		return "result-page";
	}
	*/
	
	//Using DTO class Data Binding(Spring features)
	@RequestMapping("/process-homepage")
	//Read from Web From data and write to DTO
	public String processHomePage( Model model,@Valid UserInfoDTO userinfodto,BindingResult result, HttpServletResponse response,HttpServletRequest request, HttpSession session) {
		
		model.addAttribute("UserInfo",userinfodto );
		//if we don't use @ModelAttribute then we had to add manually add every thing(Here we add errors)
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"UserInfo",result);
		
		//Writting values for properties by fetching from url(WRITE)
		
		System.out.println(userinfodto.isTermAndCondition());
		
		//all the bind data in (userInfoDTO) reference
		
		//we replace these 1 line with @ModelAttribute annotation
		//model.addAttribute("UserInfo",userInfoDTO);
		if(result.hasErrors()) {
			
			List<ObjectError> allerrors= result.getAllErrors();
			// For each loop
			for(ObjectError temp:allerrors) {
				System.out.println(temp);
			}
			
			return "home-page";
		}
		// session using HttpSession
		//session.setAttribute("username", userinfodto.getUsername());
		//set session timeout
		//session.setMaxInactiveInterval(120);
		
		//session using Servletrequest
		//HttpSession session2=request.getSession();
		//session2.setAttribute("username", userinfodto.getUsername());
		
		
		/*
		//Create the cookie to store the user name
		Cookie cookie=new Cookie("LCApp.username", userinfodto.getUsername());
		cookie.setMaxAge(60*60*24);
		//Append the cookie with response
		response.addCookie(cookie);
		//We can check created cookie in Inspect window in browser
		*/
		
		//Write a service which will calculate the bond between user and crush
		String finalresult=lcAppservice.clculateLove(userinfodto.getUsername(), userinfodto.getCrushname());
	
		//create a new varibale inside a userinfodto and send that to model
		userinfodto.setResult(finalresult);
			return "result-page";
	
	}
	
	
}
