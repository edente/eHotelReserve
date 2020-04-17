package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;


@RestController
public class RoomTypeController {
	
	@Autowired
    private IRoomTypeService roomTypeService;
	
	@GetMapping(value = {"roomTypes","roomTypes/all"})
    public List<RoomType> manageCategories() {
        return roomTypeService.getRoomTypeList();
        
    }
	
//	@GetMapping(value = "/add")
//    public String newRoomTypeForm(Model model) {
//        model.addAttribute("RoomType", new RoomType());
//        return "admin/categories/newRoomTypeform";
//    }
	
	@PostMapping(value = "roomTypes/save")
    public void addNewRoomType(@RequestBody RoomType roomType) {
     roomTypeService.saveRoomType(roomType);
        
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
