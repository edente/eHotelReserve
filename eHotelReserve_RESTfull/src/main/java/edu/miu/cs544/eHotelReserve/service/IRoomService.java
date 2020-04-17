package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;

public interface IRoomService {
	
	Room getRoomById(Long id);

	List<Room> getRoomList();

 	void saveRoomType(Room room);

 	void deleteRoom(Long id);

}
