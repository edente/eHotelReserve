package edu.miu.cs544.eHotelReserve.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.repository.IBookingRepository;
import edu.miu.cs544.eHotelReserve.repository.IRoomRepository;
import edu.miu.cs544.eHotelReserve.service.ISearchService;


@Component("searchService")
public class SearchService implements ISearchService {
	
//	private IRoomRepository roomRepository;
//	private IBookingRepository bookingRepository;	String baseUrl = "http://localhost:8000/MemberRest/roomTypes";
	String baseUrl = "http://localhost:8000/MemberRest/company/search";
	String baseUrlExtended = baseUrl + "?start={start}&end={end}";
	@Autowired
	RestHttpHeader restHelper;
	
	
//	@Autowired
//	public SearchService(IRoomRepository roomRepository, IBookingRepository bookingRepository) {
//		this.roomRepository = roomRepository;
//		this.bookingRepository = bookingRepository;
//	}
	
	@Override
	public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut){
		RestTemplate restTemplate= restHelper.getRestTemplate();
		HttpEntity httpEntity= new HttpEntity(restHelper.getHttpHeaders());
		
//		ResponseEntity<Booking[]> responseEntity=restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Booking[].class);
// 		List<Booking> allBookings = Arrays.asList(responseEntity.getBody());

//		 String result = restTemplate.getForObject("http://example.com/hotels?state={state}&country={country}", String.class,"NY","USA");
		ResponseEntity<Room[]> responseEntity=restTemplate.exchange(baseUrlExtended, HttpMethod.GET, httpEntity, Room[].class,checkIn,checkOut);

 		List<Room> allRooms = Arrays.asList(responseEntity.getBody());
 			
//		List<Booking> allBookings = (List<Booking>) bookingRepository.findAll();
//		List<Room> allRooms = (List<Room>) roomRepository.findAll();
//		List<Room> availableRooms = new ArrayList<>();
//		
//		List<Room> booked = allBookings.stream().filter(b -> (b.getCheckInDate().isBefore(checkIn) &&
//                b.getCheckOutDate().isAfter(checkOut)) || (b.getCheckInDate().isAfter(checkIn) &&
//                b.getCheckInDate().isBefore(checkOut)) || (b.getCheckInDate().equals(checkIn) ||
//                b.getCheckInDate().equals(checkOut) || b.getCheckOutDate().equals(checkIn) ||
//                b.getCheckOutDate().equals(checkOut))).map(b -> b.getRoom()).collect(Collectors.toList());
//
//        for(Room r: allRooms) if(!(booked.contains(r))) availableRooms.add(r);
        
		return allRooms; 
	}

	@Override
	public List<RoomType> findAvailableRoomTypes(LocalDate checkIn, LocalDate checkOut) {
       
		RestTemplate restTemplate= restHelper.getRestTemplate();
		HttpEntity httpEntity= new HttpEntity(restHelper.getHttpHeaders());
		
		ResponseEntity<RoomType[]> responseEntity=restTemplate.exchange(baseUrlExtended, HttpMethod.GET, httpEntity, RoomType[].class,checkIn,checkOut);

 		List<RoomType> allRooms = Arrays.asList(responseEntity.getBody());
		
		return allRooms;
		
//		return getAvailableRooms(checkIn, checkOut).stream()
//											   .map(r -> r.getRoomtype())
//											   .distinct()
//											   .collect(Collectors.toList());
	}

}
