package edu.miu.cs544.eHotelReserve.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.BookingDao;
import edu.miu.cs544.eHotelReserve.model.Booking;

@SuppressWarnings("unchecked")
@Repository
public class BookingDaoImpl extends GenericDaoImpl<Booking> implements BookingDao {

	public BookingDaoImpl() {
		super.setDaoType(Booking.class);
	}

}