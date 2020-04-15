package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.repository.IUserCredentialRepository;
import edu.miu.cs544.eHotelReserve.service.IUserCredentialService;



@Service("userCredentialService")
public class UserCredentialService implements IUserCredentialService{
	
	private IUserCredentialRepository userCredentialRepository;
		
	@Autowired
	public UserCredentialService(IUserCredentialRepository userCredentialRepository) {
		this.userCredentialRepository = userCredentialRepository;
	}

	@Override
	public List<UserCredential> findAll() {
		
		return userCredentialRepository.findAll();
	}

	@Override
	public UserCredential save(UserCredential userCredential) {
//
//  		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
//  		String encodedPassword = passwordEncoder.encode(userCredential.getPassword());
//  		userCredential.setPassword(encodedPassword);
//  		return userCredentialRepository.save(userCredential);
		return null;
  		
	}

//
//	@Override
//	public UserCredential findById(Long ucId) {
//		return userCredentialRepository.findById(ucId).get();
//	}
//
//	@Override
//	public void delete(Long cId) {
//		userCredentialRepository.deleteById(cId);
//	}

	@Override
	public UserCredential findByUserName(String userName) {
		return userCredentialRepository.findByUserName(userName);
	}

	

}
	
