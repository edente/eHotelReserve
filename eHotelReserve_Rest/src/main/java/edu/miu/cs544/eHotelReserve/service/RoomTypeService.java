package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.RoomType;

public interface RoomTypeService {
	
	RoomType getCategoryById(Long id);

	List<RoomType> getCategoryList();

 	void saveCategory(RoomType category);

 	void deleteCategory(Long id);

}
