package mum.edu.cs.cs544.project.eHotelReserve.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String bookingID;
	
	@Valid
	@OneToOne
	private User customer;
	
	@Valid
	@OneToOne
	private Room room;
	
	@NotNull(message = "{NotNull.validation}")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date checkInDate;
	
	@NotNull(message = "{NotNull.validation}")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date checkOutDate;
	
    private boolean gym;
    private boolean parking;
    
    private Double price;

    public Booking(){}

    public Booking(User customer, Room room, Date checkInDate, Date checkOutDate, boolean gym,
			boolean parking) {
		this.customer = customer;
		this.room = room;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.gym = gym;
		this.parking = parking;
		Double totalPrice = 0.0;
		if(gym) totalPrice += 10;
		if(parking) totalPrice += 20;
		totalPrice += room.getPrice();
		this.price = totalPrice;
	}

	public long getId() {
		return id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	
}
