package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Address;

public interface IAddressService {
	
	List<Address>findAll();
	void save(Address address);
	Address findById(Long aId);
	void delete(Long aId);

}
