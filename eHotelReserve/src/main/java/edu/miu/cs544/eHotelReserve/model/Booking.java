package edu.miu.cs544.eHotelReserve.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "bookings")
public class Booking implements Serializable {

	// @Override
	// public String toString() {
	// return "Booking [id=" + id + ", referenceNumber=" + referenceNumber + ",
	// bookingDate=" + bookingDate
	// + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ",
	// totalPrice=" + totalPrice
	// + ", hotelReserveLocation=" + hotelReserveLocation + ", user=" + user + ",
	// room=" + room + ", payment="
	// + payment + "]";
	// }

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// private String bookingID;
	@NotEmpty
	@Column(name = "reference_number")
	private String referenceNumber;

	@Column(name = "booking_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate bookingDate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkInDate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOutDate;

	@Column(name = "total_price")
	private Double totalPrice;
	@NotEmpty
	@Column(name = "hotel_reserve_location")
	private String hotelReserveLocation;

	public String getHotelReserveLocation() {
		return hotelReserveLocation;
	}

	public void setHotelReserveLocation(String hotelReserveLocation) {
		this.hotelReserveLocation = hotelReserveLocation;
	}

	@Valid
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "room_id", nullable = true)
	private Room room;

	@OneToOne
	@JoinColumn(name = "payment_id")
	@Valid
	private Payment payment;

	public Booking() {

	}

	public Booking(Long id, String referenceNumber, LocalDate bookingDate, LocalDate checkInDate,
			LocalDate checkOutDate, Double totalPrice, String location, User user, Room room, Payment payment) {
		this.id = id;
		this.referenceNumber = referenceNumber;
		this.bookingDate = bookingDate;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
		this.hotelReserveLocation = location;
		this.user = user;
		this.room = room;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
