package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.repository.IUserRepository;
import edu.miu.cs544.eHotelReserve.service.IUserService;



@Service("userService")
public class UserService implements IUserService{
	
	private IUserRepository userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long uId) {
		return userRepository.findById(uId).orElse(null);
	}

	@Override
	public void delete(Long uId) {
		userRepository.deleteById(uId);
	}

}
