package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.repository.IRoomRepository;

import edu.miu.cs544.eHotelReserve.service.IRoomService;


@Service("roomService")
public class RoomService implements IRoomService{
	
	private IRoomRepository roomRepository;

	String baseUrl = "http://localhost:8000/MemberRest/rooms";
	String baseUrlExtended = baseUrl + "/save";
	@Autowired
	RestHttpHeader restHelper;
	
//	@Autowired
//	public RoomService(IRoomRepository roomRepository) {
//		this.roomRepository = roomRepository;
//	}

	@Override
	
	public List<Room> findAll() {
//		return roomRepository.findAll();
		RestTemplate restTemplate= restHelper.getRestTemplate();
		HttpEntity httpEntity= new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Room[]> responseEntity=restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Room[].class);
 		List<Room> rooms = Arrays.asList(responseEntity.getBody());
 		return rooms;
	}
		
	

	@Override
	public Room save(Room room) {
		return roomRepository.save(room);
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
