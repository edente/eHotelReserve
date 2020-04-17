package edu.miu.cs544.eHotelReserve.dao.impl;

import edu.miu.cs544.eHotelReserve.dao.IGroupDao;
import edu.miu.cs544.eHotelReserve.model.Group;

public class GroupDao extends GenericDao<Group> implements IGroupDao{
	public GroupDao() {
		super.setDaoType(Group.class);
	}

}
