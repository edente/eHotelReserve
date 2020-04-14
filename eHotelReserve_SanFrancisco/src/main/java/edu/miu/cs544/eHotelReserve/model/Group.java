package edu.miu.cs544.eHotelReserve.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GroupToo")
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long group_id;
	
	String group_name;
	
    @ManyToMany(cascade = CascadeType.ALL)
	List<Authority> authority = new ArrayList<Authority>();

    @ManyToMany(cascade = CascadeType.ALL)
	List<UserCredential> userCredentials = new ArrayList<UserCredential>();



	public long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public List<UserCredential> getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(List<UserCredential> userCredentials) {
		this.userCredentials = userCredentials;
	}
	

}
