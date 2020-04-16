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

 
@Entity
@Table(name = "userCredentials")
public class UserCredential {

	 @Id
	 @Column(name = "username", nullable = false, unique = true)
 	String username;
	 
	 @Column(name = "PASSWORD", nullable = false)
	String password;
	
	String matchingPassword;
	
	Boolean enabled;
	
	@OneToOne(mappedBy = "userCredentials", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	User user;
	
 	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
