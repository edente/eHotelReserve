package edu.miu.cs544.eHotelReserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.service.IBookingService;
import edu.miu.cs544.eHotelReserve.service.impl.BookingServiceImpl;

@RestController("/bookings")
public class BookingController {
	@Autowired
	private IBookingService bookingService;
	
	@GetMapping({"","/all"})
	public Iterable<Booking> getbookHotels() {
		return bookingService.getBookingList();
	}

	@GetMapping("/{id}")
	public Booking getBookingById(@PathVariable("id") Long id) {
		return bookingService.getBookingById(id);
	}

	@PostMapping("/add")
	public Booking createBooking(@RequestBody Booking booking) {
		try {
			bookingService.saveBooking(booking);
		} catch (Exception ex) {
			System.out.println("Transaction Failed!!!");
		}
		return booking;
	}

	@DeleteMapping("/delete")
	public void deleteBooking(Long id) {
		bookingService.deleteBooking(id);
	}
}
