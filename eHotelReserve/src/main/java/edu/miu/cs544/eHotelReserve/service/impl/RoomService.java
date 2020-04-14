package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.repository.IRoomRepository;
import edu.miu.cs544.eHotelReserve.service.IRoomService;


@Service("roomService")
public class RoomService implements IRoomService{
	
	private IRoomRepository roomRepository;
	
	@Autowired
	public RoomService(IRoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public Room save(Room vehicle) {
		return roomRepository.save(vehicle);
	}

	@Override
	public Room findById(Long vId) {
		return roomRepository.findById(vId).orElse(null);
	}

	@Override
	public void delete(Long vId) {
		roomRepository.deleteById(vId);
	}

	@Override
	public String assignRoomNumber() {
		if(roomRepository.findAll().stream().count() == 0) return "HR1";
		Long currentId = roomRepository.findAll().stream().mapToLong(Room::getId).max().getAsLong();
		return  "HR" + (currentId + 1) ;
	}

}
