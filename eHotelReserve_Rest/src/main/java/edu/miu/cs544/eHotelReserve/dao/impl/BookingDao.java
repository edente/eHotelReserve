package edu.miu.cs544.eHotelReserve.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IBookingDao;
import edu.miu.cs544.eHotelReserve.model.Booking;

@SuppressWarnings("unchecked")
@Repository
public class BookingDao extends GenericDao<Booking> implements IBookingDao {

	public BookingDao() {
		super.setDaoType(Booking.class);
	}

}