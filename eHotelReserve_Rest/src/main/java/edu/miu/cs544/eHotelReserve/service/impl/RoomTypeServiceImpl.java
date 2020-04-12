package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.RoomTypeService;
import mum.edu.cs544.eHotelReserve.dao.RoomTypeDao;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	RoomTypeDao categoryDao;
	
	@Override
	public RoomType getCategoryById(Long id) {
		return categoryDao.findOne(id);
	}

	@Override
	public List<RoomType> getCategoryList() {
		return categoryDao.findAll();
	}

	@Override
	public void saveCategory(RoomType category) {
		categoryDao.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryDao.delete(id);
	}

}
