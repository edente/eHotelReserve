//package edu.miu.cs544.eHotelReserve.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import edu.miu.cs544.eHotelReserve.dao.IBookingDao;
//import edu.miu.cs544.eHotelReserve.dao.IGroupDao;
//import edu.miu.cs544.eHotelReserve.model.Group;
//import edu.miu.cs544.eHotelReserve.service.IGroupService;
//
//@Service("groupService")
//@Transactional
//public class GroupService implements IGroupService{
//	
//@Autowired
//private IGroupDao groupDao;
//	
//
//	
//
//	@Override
//	public void delete(Long grId) {
//		groupDao.delete(grId);
//		
//	}
//
//
//
//	@Override
//	public List<Group> findAll() {
//		
//		return groupDao.findAll();
//	}
//
//
//
//	@Override
//	public void save(Group group) {
//		 groupDao.save(group);
//	}
//
//
//
//
//
//}