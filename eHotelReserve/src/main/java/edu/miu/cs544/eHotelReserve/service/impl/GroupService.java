package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.eHotelReserve.model.Group;
import edu.miu.cs544.eHotelReserve.repository.IGroupRepository;
import edu.miu.cs544.eHotelReserve.service.IGroupService;

@Service("groupService")
@Transactional
public class GroupService implements IGroupService{
	
	private IGroupRepository groupRepository;
	
	@Autowired
	public GroupService(IGroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}

	

	@Override
	public void delete(Long grId) {
		groupRepository.deleteById(grId);
		
	}



	@Override
	public List<Group> findAll() {
		
		return groupRepository.findAll();
	}



	@Override
	public Group save(Group group) {
		
		return groupRepository.save(group);
	}



	@Override
	public Optional<Group> findById(Long grId) {
		
		return groupRepository.findById(grId);
	}


}