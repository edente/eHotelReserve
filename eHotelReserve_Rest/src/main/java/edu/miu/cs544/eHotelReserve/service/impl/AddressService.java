package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IAddressDao;
import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.service.IAddressService;

@Service("addressService")
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressDao addressDao;

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}
	
	@Override
	public void save(Address address) {
	     addressDao.save(address); 
	}

	@Override
	public Address findById(Long aId) {
		return addressDao.findOne(aId); //.findById(aId).orElse(null);
	}

	@Override
	public void delete(Long aId) {
		addressDao.delete(aId);
	}
	
}
