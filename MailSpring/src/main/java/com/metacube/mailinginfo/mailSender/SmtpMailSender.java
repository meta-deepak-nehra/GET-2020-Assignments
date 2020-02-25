package com.metacube.mailinginfo.mailSender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//with component annotation
@Component
public class SmtpMailSender implements MailSender {

	@Override
	public void message() {
		System.out.println("Message from SmtpMail");
	}

}

//without component annotation
//for config file
//public class SmtpMailSender implements MailSender {
//
//	@Override
//	public void message() {
//		System.out.println("Message from SmtpMail");
//	}
//
//}

//for primary

//@Component
//@Primary
//public class SmtpMailSender implements MailSender {
//
//	@Override
//	public void message() {
//		System.out.println("Message from SmtpMail");
//	}
//
//}