package edu.miu.cs544.eHotelReserve.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//private String userID;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String firstName;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String lastName;
	

	@Column(name = "email")
	@NotEmpty(message = "{NotEmpty}")
    private String email;
    
	@Valid
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id") 
    private Address address;
	
	@Valid
	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
	@JoinColumn(name="username") 
	private UserCredential userCredentials;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	private List<Booking> booking;
	

    public UserCredential getUserCredential() {
		return userCredentials;
	}

	public void setUserCredential(UserCredential userCredentials) {
		this.userCredentials = userCredentials;
	}

	public User() {}

    
    
    

	public User( String firstName,
			String lastName,
			 String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	
}
