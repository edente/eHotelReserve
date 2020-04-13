package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Role;



public interface IRoleService {
	
	List<Role>findAll();
	Role save(Role role);
	Role findById(Long rId);
	void delete(Long rId);

}