package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.UserCredential;

public interface ICredentialService {
	
	List<UserCredential>findAll();
	UserCredential save(UserCredential credential);
	UserCredential findById(Long cId);
	void delete(Long cId);

}
	
