package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.eHotelReserve.dao.IRoomTypeDao;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;

@Service
@Transactional
public class RoomTypeServiceImpl implements IRoomTypeService {

	@Autowired
	IRoomTypeDao roomTypeDao;
	
	@Override
	public RoomType getRoomTypeById(Long id) {
		return roomTypeDao.findOne(id);
	}

	@Override
	public List<RoomType> getRoomTypeList() {
		return roomTypeDao.findAll();
	}

	@Override
	public void saveRoomType(RoomType RoomType) {
		roomTypeDao.save(RoomType);
	}

	@Override
	public void deleteRoomType(Long id) {
		roomTypeDao.delete(id);
	}

}
