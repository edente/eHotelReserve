package edu.miu.cs544.eHotelReserve.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IRoomTypeDao;
import edu.miu.cs544.eHotelReserve.model.RoomType;

@SuppressWarnings("unchecked")
@Repository
public class RoomTypeDao extends GenericDao<RoomType> implements IRoomTypeDao {

	public RoomTypeDao() {
		super.setDaoType(RoomType.class);
	}
	
}
