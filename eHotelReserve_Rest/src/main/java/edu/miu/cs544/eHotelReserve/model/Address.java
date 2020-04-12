package edu.miu.cs544.eHotelReserve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String street;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String city;
	
	@NotEmpty(message="{NotEmpty.validation}")
	@Size(min = 2, max = 2, message="{Size.validation.stateandzip}")
    private String state;
	
	@NotEmpty(message="{NotEmpty.validation}")
	@Size(min = 5, max = 5, message="{Size.validation.stateandzip}")
    private String zipCode;
	
	@NotEmpty(message="{NotEmpty.validation}")
	@Email(message="{Email.validation}")
    private String email;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String phone;

    public Address() {}

	public Address(String street, String city, String state, String zip, String email, String phone) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zip;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return addressId;
	}

	public void setId(long id) {
		this.addressId = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zipCode;
	}

	public void setZip(String zip) {
		this.zipCode = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}
