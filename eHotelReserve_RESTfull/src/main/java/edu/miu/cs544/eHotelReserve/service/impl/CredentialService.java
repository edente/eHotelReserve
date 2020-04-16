package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IUserCredentialDao;
import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.service.ICredentialService;



@Service("credentialService")
public class CredentialService implements ICredentialService{
	
	@Autowired
	private IUserCredentialDao userCredentialsDao;

 	
    public void save( UserCredential userCredentials) {  		
 		userCredentialsDao.save(userCredentials);
	}
 	
    public void update( UserCredential userCredentials) {  		
 		userCredentialsDao.update(userCredentials);
	}
 	
  	
	public List<UserCredential> findAll() {
		return (List<UserCredential>)userCredentialsDao.findAll();
	}
	
	

	public UserCredential findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}

	@Override
	public void delete(Long cId) {
		// TODO Auto-generated method stub
		
	}

	

//	@Override
//	public void delete(Long cId) {
//		// TODO Auto-generated method stub
//		
//	}

}
	
