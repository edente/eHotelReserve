package edu.miu.cs544.eHotelReserve.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "rooms")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@Column(name = "room_number")
	@NotEmpty
	private String roomNumber;
	
	@Valid
	@ManyToOne
	@JoinColumn(name="roomType_id", nullable = false)
	@NotNull
    private RoomType roomType;
    
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Booking> bookings;
    
    
    public Room() {}

	

	public Room(Long id,String roomNumber,
			 RoomType roomtype, 
			List<Booking> bookings) {
		
		this.id=id;
		this.roomNumber = roomNumber;
		this.roomType = roomtype;
		
		this.bookings = bookings;
	}
	
	

	

	public Room( String roomNumber,
			RoomType roomType) {
		
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getRoomtype() {
		return roomType;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomType = roomtype;
	}

	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	

	
}
