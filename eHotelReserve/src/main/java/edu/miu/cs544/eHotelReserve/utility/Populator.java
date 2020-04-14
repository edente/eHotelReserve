package edu.miu.cs544.eHotelReserve.utility;

import org.springframework.beans.factory.annotation.Autowired;

import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.repository.IRoomRepository;
import edu.miu.cs544.eHotelReserve.repository.IRoomTypeRepository;
import edu.miu.cs544.eHotelReserve.service.IRoomService;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;
import edu.miu.cs544.eHotelReserve.service.impl.RoomService;
import edu.miu.cs544.eHotelReserve.service.impl.RoomTypeService;

public class Populator {
	
	@Autowired
	private IRoomTypeRepository roomTypeRepository;
	
	@Autowired
	private IRoomRepository roomRepository;
	
	@Autowired
	private IRoomTypeService roomTypeService = new RoomTypeService(roomTypeRepository);
	
	@Autowired
	private IRoomService roomService = new RoomService(roomRepository);
	
	public void populate() {
		
		//creating and populating room types
		
		RoomType rT1 = new RoomType("HR1", 300.0);
		roomTypeService.save(rT1);
		RoomType rT2 = new RoomType("HR2", 150.0);
		roomTypeService.save(rT2);
		RoomType rT3 = new RoomType("HR3", 200.0);
		roomTypeService.save(rT3);
		RoomType rT4 = new RoomType("HR4", 400.0);
		roomTypeService.save(rT4);
		
		//creating and populating rooms
		Room r1 = new Room(roomService.assignRoomNumber(),rT1);
		roomService.save(r1);
		Room r2 = new Room(roomService.assignRoomNumber(),rT2);
		roomService.save(r2);
		Room r3 = new Room(roomService.assignRoomNumber(),rT3);
		roomService.save(r3);
		Room r4 = new Room(roomService.assignRoomNumber(),rT4);
		roomService.save(r4);
		
		
		
	}

}
