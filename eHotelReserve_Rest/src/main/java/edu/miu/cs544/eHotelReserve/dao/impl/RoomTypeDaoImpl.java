package edu.miu.cs544.eHotelReserve.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import mum.edu.cs544.eHotelReserve.dao.RoomTypeDao;

@SuppressWarnings("unchecked")
@Repository
public class RoomTypeDaoImpl extends GenericDaoImpl<RoomType> implements RoomTypeDao {

	public RoomTypeDaoImpl() {
		super.setDaoType(RoomType.class);
	}
	
}
