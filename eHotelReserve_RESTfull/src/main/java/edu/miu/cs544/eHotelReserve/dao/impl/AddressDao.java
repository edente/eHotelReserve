package edu.miu.cs544.eHotelReserve.dao.impl;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IAddressDao;
import edu.miu.cs544.eHotelReserve.model.Address;

@Repository
public class AddressDao extends GenericDao<Address> implements IAddressDao{

}
