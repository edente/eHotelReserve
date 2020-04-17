package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.amqpconfigJava.AmqpConfiguration;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.IBookingService;



@Component("bookingService")
public class BookingService implements IBookingService{
	

//	private IBookingRepository bookingRepository;
	String baseUrl = "http://localhost:8000/MemberRest";
	String baseUrlExtended = baseUrl + "/bookings/add";

	@Autowired
	RestHttpHeader restHelper;
//	@Autowired
//	public BookingService(IBookingRepository bookingRepository) {
//		
//	}

	@Override
	public List<Booking> findAll() {
		return null;
	}

	@Override
	public Booking save(Booking booking) {	
		RestTemplate restTemplate = restHelper.getRestTemplate();
		System.out.println("posting booking***********************");
		HttpEntity httpEntity = new HttpEntity(booking, restHelper.getHttpHeaders());
		System.out.println("after entity***********************");
		restTemplate.postForObject(baseUrlExtended, httpEntity, Booking.class);
		System.out.println("posted***********************");
		return null;
	}

	@Override
	public Booking findById(Long bId) {
		return null;
	}
	@Override
	public void delete(Long bId) {
		
	}

	@Override
	public String assignReferenceNumber() {
		
		RestTemplate restTemplate= restHelper.getRestTemplate();
		HttpEntity httpEntity= new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Booking[]> responseEntity=restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Booking[].class);
		List<Booking> booking = Arrays.asList(responseEntity.getBody());

 		if (booking.size()==0) return "AA1";
		Long currentId = booking.stream().mapToLong(Booking::getId).max().getAsLong();

//		if(bookingRepository.findAll().stream().count() == 0) return "BN1";
//		Long currentId = bookingRepository.findAll().stream().mapToLong(Booking::getId).max().getAsLong();
		return  "BN" + (currentId + 1) ;
	}

	@Override
	public void publish(Booking newBooking, AnnotationConfigApplicationContext context) {
		AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(AmqpConfiguration.class);
		if(newBooking.getHotelReserveLocation().equals("SanFrancisco")) {
			RabbitTemplate rabbitTemplate = context.getBean("bookingTemplateSanFrancisco",RabbitTemplate.class);
			rabbitTemplate.convertAndSend(newBooking);
		} else if(newBooking.getHotelReserveLocation().equals("SanJose")){
			RabbitTemplate rabbitTemplate = context.getBean("bookingTemplateSanJose",RabbitTemplate.class);
			rabbitTemplate.convertAndSend(newBooking);
		} else {
			RabbitTemplate rabbitTemplate = context.getBean("bookingTemplateLasVegas",RabbitTemplate.class);
			rabbitTemplate.convertAndSend(newBooking);
		}
		System.out.println("\n------New Booking Sent to " + newBooking.getHotelReserveLocation() + " Branch Queue on Rabbitmq");
		System.out.println("--------Booking Reference Number: " + newBooking.getReferenceNumber());
		System.out.println("--------Booking email: " + newBooking.getUser().getEmail());
		System.out.println("--------Customer's Full Name    : " + newBooking.getUser().getFirstName() + " " + newBooking.getUser().getLastName() + "\n");
	}



}
	