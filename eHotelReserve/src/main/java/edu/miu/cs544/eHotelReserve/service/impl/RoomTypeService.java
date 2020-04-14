package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.repository.IRoomTypeRepository;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;



@Service("roomTypeService")
public class RoomTypeService implements IRoomTypeService{
	
	private IRoomTypeRepository roomTypeRepository;
	
	@Autowired
	public RoomTypeService(IRoomTypeRepository roomTypeRepository) {
		this.roomTypeRepository = roomTypeRepository;
	}

	@Override
	public List<RoomType> findAll() {
		return roomTypeRepository.findAll();
	}

	@Override
	public RoomType save(RoomType category) {
		return roomTypeRepository.save(category);
	}

	@Override
	public RoomType findById(Long cId) {
		return roomTypeRepository.findById(cId).orElse(null);
	}

	@Override
	public void delete(Long cId) {
		roomTypeRepository.deleteById(cId);
	}

}
