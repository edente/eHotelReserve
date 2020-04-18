package edu.miu.cs544.eHotelReserve.utility;

import org.springframework.beans.factory.annotation.Autowired;

import edu.miu.cs544.eHotelReserve.model.Authority;
import edu.miu.cs544.eHotelReserve.model.Group;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.service.ICredentialService;
import edu.miu.cs544.eHotelReserve.service.IGroupService;
import edu.miu.cs544.eHotelReserve.service.IRoomService;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;
import edu.miu.cs544.eHotelReserve.service.IUserService;





public class Populator {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private ICredentialService credentialService;

	
	
	public void populate() {
		
		//creating and populating room types
//		
//		RoomType rT1 = new RoomType("HR1", 300.0);
//		roomTypeService.save(rT1);
//		RoomType rT2 = new RoomType("HR2", 150.0);
//		roomTypeService.save(rT2);
//		RoomType rT3 = new RoomType("HR3", 200.0);
//		roomTypeService.save(rT3);
//		RoomType rT4 = new RoomType("HR4", 400.0);
//		roomTypeService.save(rT4);
//		
//		//creating and populating rooms
//		Room r1 = new Room(roomService.assignRoomNumber(),rT1);
//		roomService.save(r1);
//		Room r2 = new Room(roomService.assignRoomNumber(),rT2);
//		roomService.save(r2);
//		Room r3 = new Room(roomService.assignRoomNumber(),rT3);
//		roomService.save(r3);
//		Room r4 = new Room(roomService.assignRoomNumber(),rT4);
//		roomService.save(r4);
		 Authority authority = new Authority();
		    authority.setAuthority("ROLE_USER");
		    
		    Group groupUser = new Group();
		    groupUser.setGroup_name("USER");
		    groupUser.getAuthority().add(authority);
		    
		    Group groupAdmin = new Group();
		    groupAdmin.setGroup_name("ADMIN");
		 
		   authority = new Authority();
		   authority.setAuthority("ROLE_ADMIN");
		   groupAdmin.getAuthority().add(authority); 
		   
		   UserCredential userCredentials = new UserCredential();
		    userCredentials.setUsername("bsr");
		    userCredentials.setPassword("bsr");
		    userCredentials.setEnabled(true);
		   
		   groupUser.getUserCredentials().add(userCredentials);


	}

}
