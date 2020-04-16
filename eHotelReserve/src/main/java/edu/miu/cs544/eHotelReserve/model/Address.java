package edu.miu.cs544.eHotelReserve.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name="addresses")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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


    public Address() {}

	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zip;
		
	}


	public Long getId() {
		return id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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


}
