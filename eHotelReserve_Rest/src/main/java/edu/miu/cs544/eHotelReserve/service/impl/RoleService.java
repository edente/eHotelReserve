package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IRoleDao;
import edu.miu.cs544.eHotelReserve.model.Role;
import edu.miu.cs544.eHotelReserve.service.IRoleService;

@Service("roleService")
public class RoleService implements IRoleService{
	
	private IRoleDao roleDao;
	
	@Autowired
	public RoleService(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findById(Long rId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long rId) {
		// TODO Auto-generated method stub
		
	}


}