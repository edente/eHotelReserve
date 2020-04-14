package edu.miu.cs544.eHotelReserve.dao.impl;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IRoomDao;
import edu.miu.cs544.eHotelReserve.model.Room;

@Repository
public class RoomDao extends GenericDao<Room> implements IRoomDao{

}
