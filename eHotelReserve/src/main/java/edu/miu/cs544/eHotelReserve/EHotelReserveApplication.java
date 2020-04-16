package edu.miu.cs544.eHotelReserve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import edu.miu.cs544.eHotelReserve.amqpconfigJava.AmqpConfiguration;
import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.impl.BookingService;

//ll3333
@SpringBootApplication
public class EHotelReserveApplication {

	@Autowired
	BookingService bookingService;
	
	public static void main(String[] args) {
		SpringApplication.run(EHotelReserveApplication.class, args);
	}
	
	
//	public void run(String... args) throws Exception {
//		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	        System.out.println();
//	     System.out.print("*************HIT RETURN send message to sanfrasisco*********************::   ");
//	      System.out.println();
//	        try {
//				in.readLine();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//       AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AmqpConfiguration.class);
//		// Put booking into Spring Integration through OrderGateway
//       
//       Address address1= new Address("111","san","tx","1234","ruftaea@gmail.com","123456789");
//       User user1= new User("selam","Gd",address1,"sel","1234");
//       RoomType roomType1= new RoomType("11","master",100.00,null);
//       Room room1= new Room("11",roomType1);
//       Payment payment1= new Payment(user1,null,"card",12341234L,345,100.00,"paid");
//
//       Booking newBooking= new Booking(1L,"11",null,null,null,200.00,"SanFrancisco",user1,room1,payment1);
//		bookingService.publish(newBooking, context);
//    	
//    	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	     System.out.print("*************HIT RETURN send message to sanfrasisco*********************::   ");
//
//	}
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:errorMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}

}
