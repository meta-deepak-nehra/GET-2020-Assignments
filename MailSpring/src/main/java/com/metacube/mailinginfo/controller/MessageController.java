package com.metacube.mailinginfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.mailinginfo.mailSender.MailSender;

@RestController
public class MessageController {
	private MailSender mailSender;

	// constructor injection with two component annotation


	@Autowired public MessageController(MailSender mockMailSender) {

		this.mailSender = mockMailSender; }


	// constructor injection with two component annotation
	//
	//	 @Autowired
	//	 public MessageController(MailSender smtpMailSender) {
	//	
	//	 this.mailSender = smtpMailSender;
	//	 }

	// constructor injection with component annotation
	// constructor injection for config file

	//	@Autowired
	//	public MessageController(MailSender mailSender) {
	//
	//		this.mailSender = mailSender;
	//	}

	// setter injection with component annotation

	//	 @Autowired
	//	 public void setMailSender(MailSender smtpMailSender) {
	//	 this.mailSender = smtpMailSender;
	//	 }

	// setter injection with component annotation

	// @Autowired
	// public void setMailSender(MailSender mockMailSender) {
	// this.mailSender = mockMailSender;
	// }

	// using Qualifier annotation and setter injection

	//	 @Autowired
	//	 public void setMailSender(@Qualifier("smtpMailSender")MailSender mailSender)
	//	 {
	//	 this.mailSender = mailSender;
	//	 }

	// using Qualifier annotation and setter injection

	// @Autowired
	// public void setMailSender(@Qualifier("mockMailSender")MailSender mailSender)
	// {
	// this.mailSender = mailSender;
	// }

	// using Qualifier annotation and constructor injection
	//
	//	@Autowired
	//	public MessageController(@Qualifier("smtpMailSender")MailSender mailSender) {
	//
	//		this.mailSender = mailSender;
	//	}

	// using Qualifier annotation and constructor injection

	// @Autowired
	// public MessageController(@Qualifier("mockMailSender")MailSender mailSender) {
	//
	// this.mailSender = mailSender;
	// }

	@GetMapping("/message")
	public String test() {

		mailSender.message();

		return "Message Send";
	}

}
