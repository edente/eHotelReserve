package edu.miu.cs544.eHotelReserve.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "userCredentials")
public class UserCredential {
	
	@NotEmpty(message="{NotEmpty.validation}")
	@Id
	@Column(name = "username", nullable = false, unique = true)
	String username;
	
	@NotEmpty(message="{NotEmpty.validation}")
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
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}

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

	public boolean equals(Object obj) {
		if (obj instanceof UserCredential) {
			UserCredential userCredentials = (UserCredential) obj;
			if (this.username.equals(userCredentials.getUsername()))
				return true;
		}
		return false;
	}

	public int hashCode() {
		return this.username.hashCode();
	}

}
