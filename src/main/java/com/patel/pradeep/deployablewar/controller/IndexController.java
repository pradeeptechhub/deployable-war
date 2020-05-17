package com.patel.pradeep.deployablewar.controller;

import java.util.HashMap;
import java.util.Map;

import com.patel.pradeep.deployablewar.email.EmailService;
import com.patel.pradeep.deployablewar.email.MailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;

@Controller
@Slf4j
public class IndexController {

	@Autowired
	private EmailService emailService;

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}
	
	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		return "next";
	}

	@RequestMapping(value = { "/testThymeleaf" }, method = RequestMethod.GET)
	public String testThymeleafView() {

		return "th_page1";
	}

	@RequestMapping(value = { "/sendEmail" }, method = RequestMethod.GET)
	public String sendEmail(Map<String, Object> modelMap) {
		log.info("Sending Email with Thymeleaf HTML Template Example");

		MailModel mail = new MailModel();
		mail.setFrom("pkdaptel@gmail.com");
		mail.setTo("pkdaptel@gmail.com");
		mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

		Map<String, Object> model = new HashMap();
		model.put("name", "Google.com");
		model.put("location", "Mumbai");
		model.put("signature", "https://google.com");
		mail.setModel(model);

		try {
			emailService.sendSimpleMessage(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
			modelMap.put("errorMessage", "Email service failed to sent email!!!");
			return "error";
		}
		modelMap.put("message", "Email sent successfully!!!");
		modelMap.put("errorMessage", "Another Error Page!!!");
		return "jsp/error";
	}

}