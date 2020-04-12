package edu.miu.cs544.eHotelReserve.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.miu.cs544.eHotelReserve.model.Booking;

public interface BookingService {
	
	Booking getBookingById(Long bookingID);

	List<Booking> getBookingList();

 	void saveBooking(Booking booking);

 	void deleteBooking(Long id);
	
}
