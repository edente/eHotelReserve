package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.User;



public interface IUserService {
	
	List<User>findAll();
	void save(User user);
	User findById(Long uId);
	//void delete(Long uId);

}
