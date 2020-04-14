package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.repository.IAddressRepository;
import edu.miu.cs544.eHotelReserve.service.IAddressService;



@Service("addressService")
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}
	
	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address findById(Long aId) {
		return addressRepository.findById(aId).orElse(null);
	}

	@Override
	public void delete(Long aId) {
		addressRepository.deleteById(aId);
	}
	
}
