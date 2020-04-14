package edu.miu.cs544.eHotelReserve.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs544.eHotelReserve.model.Group;


public interface IGroupService {
	
	List<Group>findAll();
	Group save(Group group);
	 Optional<Group> findById(Long gId);
	void delete(Long gId);

}