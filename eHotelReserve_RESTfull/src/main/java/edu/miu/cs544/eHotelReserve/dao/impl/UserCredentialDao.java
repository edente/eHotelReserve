package edu.miu.cs544.eHotelReserve.dao.impl;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IUserCredentialDao;
import edu.miu.cs544.eHotelReserve.model.UserCredential;

@Repository
public class UserCredentialDao extends GenericDao<UserCredential> implements IUserCredentialDao{

}
