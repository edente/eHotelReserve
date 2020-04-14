package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.RoomType;



public interface IRoomTypeService {
	
	List<RoomType>findAll();
	RoomType save(RoomType roomType);
	RoomType findById(Long rId);
	void delete(Long rId);

}
