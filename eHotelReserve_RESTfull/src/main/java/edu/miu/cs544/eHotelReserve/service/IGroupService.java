package edu.miu.cs544.eHotelReserve.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs544.eHotelReserve.model.Group;


public interface IGroupService {
	
	List<Group>findAll();
	void save(Group group);
	
	void delete(Long gId);

}