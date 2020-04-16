package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.Booking;



public interface IBookingService {

	List<Booking>findAll();
	Booking save(Booking booking);
	Booking findById(Long bId);
	void delete(Long bId);
	String assignReferenceNumber();
	public void publish(Booking newBooking, AnnotationConfigApplicationContext context);

}
