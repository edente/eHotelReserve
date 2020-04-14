package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Room;


public interface IRoomService {
	
	List<Room>findAll();
	Room save(Room vehicle);
	Room findById(Long vId);
	void delete(Long vId);
	String assignRoomNumber();

}
