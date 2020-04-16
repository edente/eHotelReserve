package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.UserCredential;


public interface IUserCredentialService {
	
	List<UserCredential>findAll();
	void save(UserCredential userCredential);
//	UserCredential findById(Long ucId);
	UserCredential findByUserName(String userName);
	
//	void delete(Long ucId);

}
	
