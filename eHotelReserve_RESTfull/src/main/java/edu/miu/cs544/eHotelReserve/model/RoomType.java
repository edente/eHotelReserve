package edu.miu.cs544.eHotelReserve.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "roomTypes")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
//property = "@id")
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roomtype_id")
	private Long roomTypeId;
	
	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	@NotEmpty
	private String roomTypeName;
	
	@NotNull
	private Double price;
//	 @JsonManagedReference()
	 @JsonBackReference()
//	@JsonIgnoreProperties(value="roomType")
	@OneToMany(mappedBy = "roomType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Room> rooms;
	
	public RoomType() {}

	public RoomType(String roomType_id, String roomName,
			 Double price, List<Room> rooms) {
		
		
		this.roomTypeName = roomName;
		this.price = price;
		this.rooms = rooms;
	}
	
	



	public RoomType(@NotEmpty(message = "{NotEmpty.validation}") String roomTypeName,
			@NotNull(message = "{NotNull.validation}") Double price) {
		super();
		this.roomTypeName = roomTypeName;
		this.price = price;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomName) {
		this.roomTypeName = roomName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	
	
}
