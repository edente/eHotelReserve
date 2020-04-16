package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.eHotelReserve.dao.IRoomDao;
import edu.miu.cs544.eHotelReserve.dao.IRoomTypeDao;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.IRoomService;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;

@Service
@Transactional
public class RoomService implements IRoomService {

	@Autowired
	IRoomDao roomTypeDao;

	@Override
	public Room getRoomById(Long id) {
		return roomTypeDao.findOne(id);
	}

	@Override
	public List<Room> getRoomList() {
		return roomTypeDao.findAll();
	}

	@Override
	public void saveRoomType(Room room) {
		roomTypeDao.save(room);
	}

	@Override
	public void deleteRoom(Long id) {
		roomTypeDao.delete(id);		
	}
	
	

}
