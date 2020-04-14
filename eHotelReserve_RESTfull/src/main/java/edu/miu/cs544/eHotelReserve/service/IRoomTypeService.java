package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.RoomType;

public interface IRoomTypeService {
	
	RoomType getRoomTypeById(Long id);

	List<RoomType> getRoomTypeList();

 	void saveRoomType(RoomType RoomType);

 	void deleteRoomType(Long id);

}
