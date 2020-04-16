package edu.miu.cs544.eHotelReserve.amqp;

import javax.mail.MessagingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.miu.cs544.eHotelReserve.emailservice.EmailService;
import edu.miu.cs544.eHotelReserve.model.Booking;

import java.util.Locale;

public class DirectBranchListener {

	public void listen(Booking booking) throws MessagingException {
		String name = booking.getUser().getFirstName();
		String email = booking.getUser().getEmail();
		String documentName = "eHotelReceipt.docx";
		
		System.out.println("-------- Customer's Full Name    : " + booking.getUser().getFirstName() + " "
				+ booking.getUser().getLastName() + "\n");
		 System.out.println("\n-------- New Booking Message Received from " +
		 booking.getHotelReserveLocation() + " Branch Queue on Rabbitmq");
		System.out.println("-------- Sending Confirmation Email to Customer to " + email + "\n");

		ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		EmailService emailService = (EmailService) context.getBean("emailService");
		emailService.sendBookingConfirmationMail(name, email,booking,documentName,new Locale("en"));

//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(edu.miu.cs544.eHotelReserve.main.AmqpConfiguration.class);
//
//		EmailService emailService =(EmailService) context.getBean("emailService");
//		emailService.sendBookingConfirmationMail(name, email, booking, documentName, new Locale("en"));
	}
}
