package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.eHotelReserve.dao.IUserDao;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.ICredentialService;
import edu.miu.cs544.eHotelReserve.service.IUserService;
import edu.miu.cs544.eHotelReserve.validation.ServiceValidation;


@Service("userService")
@Transactional
public class UserService implements IUserService{

	private IUserDao userDao;
	
	
 	ICredentialService credentialsService;
	
	@Autowired
	public UserService(IUserDao userDao, ICredentialService credentialsService) {
		
		this.userDao = userDao;
		this.credentialsService = credentialsService;
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
@ServiceValidation
	@Override
	public void save(User user) {
		//credentialsService.save(user.getUserCredentials());
		userDao.save(user);
	}

	@Override
	public User findById(Long uId) {
		return userDao.findOne(uId);
	}

	@Override
	public void delete(Long uId) {
		userDao.delete(uId);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}


	@Override
	public void patch(Long id, User patchUser) {
		// TODO Auto-generated method stub
		
	}

}
