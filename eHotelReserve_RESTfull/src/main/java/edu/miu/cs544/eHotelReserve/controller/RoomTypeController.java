package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;


@RestController("/admin")
public class RoomTypeController {
	
	@Autowired
    private IRoomTypeService roomTypeService;
	
	@GetMapping(value = {"hotel/admin/roomTypes","roomType/all"})
    public List<RoomType> manageCategories() {
        return roomTypeService.getRoomTypeList();
    }
	
//	@GetMapping(value = "/add")
//    public String newRoomTypeForm(Model model) {
//        model.addAttribute("RoomType", new RoomType());
//        return "admin/categories/newRoomTypeform";
//    }
	
	@PostMapping(value = "roomType/save")
    public void addNewRoomType( RoomType RoomType) {

     roomTypeService.saveRoomType(RoomType);
        
    }
	
	@GetMapping(value = "roomType/edit/{RoomTypeId}")
    public RoomType editRoomTypeForm(@PathVariable("RoomTypeId") Long RoomTypeId) {
		return roomTypeService.getRoomTypeById(RoomTypeId);

    }
	
	@GetMapping(value="roomType/delete/{RoomTypeId}")
	public void deleteRoomType(@PathVariable("RoomTypeId") Long id){		
		roomTypeService.deleteRoomType(id);
	}

}
