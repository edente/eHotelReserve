package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IUserDao;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IUserService;

@Service("userService")
public class UserService implements IUserService{
	
	private IUserDao userDao;
	
	@Autowired
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
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
