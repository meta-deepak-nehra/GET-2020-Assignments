package com.metacube.mailinginfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.mailinginfo.mailSender.MockMailSender;
import com.metacube.mailinginfo.mailSender.SmtpMailSender;

//Use the AppConfig file when we don't use component annotation
//use bean annotation on method which we want to invoke

@Configuration
public class AppConfig {
	public SmtpMailSender smtpMailSender() {
		return new SmtpMailSender();
	}


	public MockMailSender mockMailSender() {
		return new MockMailSender();
	}
}
