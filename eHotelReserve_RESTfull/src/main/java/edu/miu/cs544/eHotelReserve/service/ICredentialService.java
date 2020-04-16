package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.UserCredential;

public interface ICredentialService {
	
	List<UserCredential>findAll();
	void save(UserCredential credential);
	UserCredential findByUserName(String userName );
	void delete(Long cId);
	

}
	
