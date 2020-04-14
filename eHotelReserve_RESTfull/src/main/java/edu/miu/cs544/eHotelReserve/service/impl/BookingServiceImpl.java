package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.eHotelReserve.dao.IBookingDao;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.service.IBookingService;

@Service
@Transactional 
public class BookingServiceImpl implements IBookingService{
	
 	@Autowired
	private IBookingDao bookingDao;
 	
	@Override
	public Booking getBookingById(Long id) {
		return bookingDao.findOne(id);
	}

	@Override
	public void saveBooking(Booking booking) {
		bookingDao.save(booking);
	}

	@Override
	public void deleteBooking(Long id) {
		bookingDao.delete(id);
	}

	@Override
	public List<Booking> getBookingList() {
		return bookingDao.findAll();
	}

}
