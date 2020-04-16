package edu.miu.cs544.eHotelReserve.dao.impl;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IUserDao;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.model.User;

@Repository
public class UserDao extends GenericDao<User> implements IUserDao{

	public UserDao() {
		super.setDaoType(User.class);
	}
}
