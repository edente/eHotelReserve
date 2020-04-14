package edu.miu.cs544.eHotelReserve.repository;

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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="Bookings")
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// private String bookingID;

	@Column(name = "reference_number")
	private String referenceNumber;

	@Column(name = "booking_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "{NotNull}")
	private LocalDate bookingDate;

	@NotNull(message = "{NotNull.validation}")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date checkInDate;

	@NotNull(message = "{NotNull.validation}")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date checkOutDate;

	@Column(name = "total_price")
	private Double totalPrice;

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

	public Booking(String referenceNumber,LocalDate bookingDate,
			Date checkInDate,
			 Date checkOutDate, Double totalPrice,  User user,
			Room room, Payment payment) {
		super();
		this.referenceNumber = referenceNumber;
		this.bookingDate = bookingDate;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
		this.user = user;
		this.room = room;
		this.payment = payment;
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
