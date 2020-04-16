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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.repository.IBookingRepository;
import edu.miu.cs544.eHotelReserve.repository.IRoomRepository;
import edu.miu.cs544.eHotelReserve.service.ISearchService;

@Service("searchService")
public class SearchService implements ISearchService {
	
	@Autowired
	private IRoomRepository roomRepository;
	private IBookingRepository bookingRepository;

	@Autowired
	public SearchService(IRoomRepository roomRepository, IBookingRepository bookingRepository) {
		this.roomRepository = roomRepository;
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
		List<Booking> allBookings = (List<Booking>) bookingRepository.findAll();
		List<Room> allRooms = (List<Room>) roomRepository.findAll();
		List<Room> availableRooms = new ArrayList<>();

		List<Room> booked = allBookings.stream()
				.filter(b -> (b.getCheckInDate().isBefore(checkIn) && b.getCheckOutDate().isAfter(checkOut))
						|| (b.getCheckInDate().isAfter(checkIn) && b.getCheckInDate().isBefore(checkOut))
						|| (b.getCheckInDate().equals(checkIn) || b.getCheckInDate().equals(checkOut)
								|| b.getCheckOutDate().equals(checkIn) || b.getCheckOutDate().equals(checkOut)))
				.map(b -> b.getRoom()).collect(Collectors.toList());

		for (Room r : allRooms)
			if (!(booked.contains(r)))
				availableRooms.add(r);

		return availableRooms;

	}

	@Override
	public List<RoomType> findAvailableRoomTypes(LocalDate checkIn, LocalDate checkOut) {
		return getAvailableRooms(checkIn, checkOut).stream().map(r -> r.getRoomtype()).distinct()
				.collect(Collectors.toList());
	}

}
