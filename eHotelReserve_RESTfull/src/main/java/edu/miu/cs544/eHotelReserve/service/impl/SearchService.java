package edu.miu.cs544.eHotelReserve.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IBookingDao;
import edu.miu.cs544.eHotelReserve.dao.IRoomDao;
import edu.miu.cs544.eHotelReserve.dao.IRoomTypeDao;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.ISearchService;

@Service("searchService")
public class SearchService implements ISearchService {
	
	private IRoomDao roomDao;
	private IBookingDao bookingDao;
	private IRoomTypeDao roomType;
	
	public SearchService(IRoomDao roomDao, IBookingDao bookingDao, IRoomTypeDao roomType) {
		this.roomDao = roomDao;
		this.bookingDao = bookingDao;
		this.roomType=roomType;
	}



	@Override
	public List<RoomType> findAvailableRoomTypes(LocalDate start, LocalDate end) {
		
		return roomType.findAll();
				
//		return getAvailableRoom(start, end).stream()
//				   .map(v -> v.getRoomtype())
//				   .distinct()
//				   .collect(Collectors.toList());
	}
  
	@Override
	public List<Room> getAvailableRoom(LocalDate start, LocalDate end) {
		List<Room> bookedRooms = bookingDao.findAll().stream()
				.filter(b -> (b.getCheckOutDate().isBefore(start) && b.getCheckInDate().isAfter(start))
								|| b.getCheckOutDate().isAfter(start) && b.getCheckOutDate().isBefore(end) )			
				.map(Booking::getRoom)
				.collect(Collectors.toList());		
		System.out.println("============"+bookedRooms);
		return roomDao.findAll().stream()
//				  				.filter(v -> !bookedRooms.contains(v))
				  				.collect(Collectors.toList()); 
	}
	
	


}
