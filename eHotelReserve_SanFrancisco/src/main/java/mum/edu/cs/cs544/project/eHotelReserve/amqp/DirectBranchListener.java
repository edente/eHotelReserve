package mum.edu.cs.cs544.project.eHotelReserve.amqp;

import javax.mail.MessagingException;

import mum.edu.cs.cs544.project.eHotelReserve.emailservice.EmailService;
import mum.edu.cs.cs544.project.eHotelReserve.model.Booking;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class DirectBranchListener {

	public void listen(Booking booking) throws MessagingException {

		//System.out.println("\n-------- New Booking Message Received from " + booking.getPickUpLocation() + " Branch Queue on Rabbitmq");
		//System.out.println("-------- Booking Reference Number: " + booking.getReferenceNumber());
		//System.out.println("-------- Sending Confirmation Email to Customer on " + booking.getEmail() + "\n");
		System.out.println("-------- Customer's Full Name    : " + booking.getCustomer().getFirstName() + " " + booking.getCustomer().getLastName ()+ "\n");

		String name = booking.getCustomer().getFirstName();
		//String email = booking.getEmail();
		String documentName = "eHotelReceipt.docx";

		ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		EmailService emailService = (EmailService) context.getBean("emailService");
		emailService.sendBookingConfirmationMail(name,booking,documentName,new Locale("en"));

		//emailService.sendBookingConfirmationMail(name, email,booking,documentName,new Locale("en"));

	}
}
