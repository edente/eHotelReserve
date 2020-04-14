package edu.miu.cs544.eHotelReserve.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String userID;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String firstName;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String lastName;
    
	@Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private UserCredential userCredential;
	

    public UserCredential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	public User() {}

    public User(String firstName, String lastName, Address address, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		
	}
    
    

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
