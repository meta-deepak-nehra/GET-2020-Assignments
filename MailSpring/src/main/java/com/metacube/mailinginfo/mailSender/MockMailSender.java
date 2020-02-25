package com.metacube.mailinginfo.mailSender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//with component annotation

@Component
public class MockMailSender implements MailSender {

	@Override
	public void message() {
		System.out.println("Message from MockMail");
	}

}

//without component annotation
//for Config file

//public class MockMailSender implements MailSender {
//
//	@Override
//	public void message() {
//		System.out.println("Message from MockMail");
//	}
//
//}

//for primary Annotation

//@Component
//@Primary
//public class MockMailSender implements MailSender {
//
//	@Override
//	public void message() {
//		System.out.println("Message from MockMail");
//	}
//
//}
