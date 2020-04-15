package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.amqpconfigJava.AmqpConfiguration;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.repository.IBookingRepository;
import edu.miu.cs544.eHotelReserve.service.IBookingService;



@Service("bookingService")
public class BookingService implements IBookingService{
	

	private IBookingRepository bookingRepository;

	@Autowired
	public BookingService(IBookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking findById(Long bId) {
		return bookingRepository.findById(bId).orElse(null);
	}

	@Override
	public void delete(Long bId) {
		bookingRepository.deleteById(bId);
	}

	@Override
	public String assignReferenceNumber() {
		if(bookingRepository.findAll().stream().count() == 0) return "BN1";
		Long currentId = bookingRepository.findAll().stream().mapToLong(Booking::getId).max().getAsLong();
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
		System.out.println("\n-------- New Booking Sent to " + newBooking.getHotelReserveLocation() + " Branch Queue on Rabbitmq");
		System.out.println("-------- Booking Reference Number: " + newBooking.getReferenceNumber());
		System.out.println("-------- Customer's Full Name    : " + newBooking.getUser().getFirstName() + " " + newBooking.getUser().getLastName() + "\n");
	}



}
	