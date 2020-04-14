package edu.miu.cs544.eHotelReserve.service;

import java.time.LocalDate;
import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;



public interface ISearchService {
	
	List<RoomType> findAvailableRoomTypes(LocalDate checkIn, LocalDate checkOut);
	List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut);
}
