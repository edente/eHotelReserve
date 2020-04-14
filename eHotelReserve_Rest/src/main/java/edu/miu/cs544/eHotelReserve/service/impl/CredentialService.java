package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IUserCredentialDao;
import edu.miu.cs544.eHotelReserve.model.UserCredential;


@Service("credentialService")
public class CredentialService implements IUserCredentialDao{
	
	private IUserCredentialDao credentialRepository;
	
	@Autowired
	public CredentialService(IUserCredentialDao credentialRepository) {
		this.credentialRepository = credentialRepository;
	}

	@Override
	public List<UserCredential> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserCredential credential) {
		// TODO Auto-generated method stub

	}


	@Override
	public void delete(Long cId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserCredential findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCredential update(UserCredential t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCredential> findAll(String s, Object hint) {
		// TODO Auto-generated method stub
		return null;
	}

}
	
