package edu.miu.cs544.eHotelReserve.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import edu.miu.cs544.eHotelReserve.model.Booking;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service("emailService")
public class EmailService {
	private static final String IM_THE_GUY = "templates/images/imtheguy.jpg";
	private static final String JPG_MIME = "image/jpg";
	private static final String DOCX_MIME = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	// final String recipientEmail,
	public void sendBookingConfirmationMail(final String recipientName, final String recipientEmail, Booking booking,
			String documentName, final Locale locale) throws MessagingException {

		// Prepare the Thymeleaf evaluation context
		final Context thymeContext = new Context(locale);
		thymeContext.setVariable("name", recipientName);
		thymeContext.setVariable("booking", booking);

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setSubject("Reservation Details");

//		message.setFrom("ecarrentaliowa@gmail.com");
		// could have CC, BCC, will also take an array of Strings
		 message.setTo(recipientEmail);

		// Create the HTML body using Thymeleaf..template is orderReceivedMail.html
		final String htmlContent = this.springTemplateEngine.process("bookingReceivedMail", thymeContext);
		message.setText(htmlContent, true /* isHtml */);

		// Add imtheguy.jpg
		message.addInline("imtheguy", new ClassPathResource(IM_THE_GUY), JPG_MIME);

		// Add attachment
		String documentLocation = "templates/images/" + documentName;
		message.addAttachment(documentName, new ClassPathResource(documentLocation));

		// Send email
		this.mailSender.send(mimeMessage);

		 System.out.println("\n-------- Confirmation Email Sent to " +
		 booking.getUser().getAddress().getEmail());

	}

}
