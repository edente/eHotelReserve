package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Room;

public interface IRoomService {
	
	Room getCategoryById(Long id);

	List<Room> getCategoryList();

 	void saveCategory(Room category);

 	void deleteCategory(Long id);

}
