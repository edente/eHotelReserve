package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.IRoomService;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;

@RequestMapping("/hotel/admin/rooms")
@Controller
public class RoomController {

	@Autowired
	private IRoomService roomService;

	@Autowired
	private IRoomTypeService roomTypeService;

	@GetMapping(value = "/")
	public String listRooms(Model model) {
//		ModelAndView modelAndView = new ModelAndView();
//		List<Room> rooms = roomService.findAll();
//		modelAndView.addObject("rooms", rooms);
//		modelAndView.setViewName("admin/rooms/rooms");
//		return modelAndView;
		
	List<Room> rooms = roomService.findAll();
         model.addAttribute("rooms",rooms);
		return "admin/rooms/rooms";
	}

	@GetMapping(value = "/add")
	public String newRoomForm(Model model) {
		Room newRoom = new Room();
		newRoom.setRoomNumber(roomService.assignRoomNumber());
		List<RoomType> roomTypes = roomTypeService.findAll();
		model.addAttribute("vehicle", newRoom);
		model.addAttribute("roomTypes", roomTypes);
		return "admin/rooms/newroomform";
	}

	@PostMapping(value = "/add/save")
	public String addNewRoom(@Valid @ModelAttribute("room") Room room, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/rooms/newroomform";
		}
		room = roomService.save(room);
		return "redirect:/hotel/admin/rooms";
	}

	@GetMapping(value = "/edit/{roomId}")
	public String editVehicleForm(@PathVariable("roomId") Long roomId, Model model) {
		Room room = roomService.findById(roomId);
		List<RoomType> roomTypes = roomTypeService.findAll();
		if (room != null) {
			model.addAttribute("room", room);
			model.addAttribute("roomTypes", roomTypes);
			return "admin/rooms/editroomform";
		}
		return "admin/rooms/rooms";
	}

	@GetMapping(value = "/delete/{roomId}")
	public String deleteVehicle(@PathVariable("roomId") Long id, Model model) {
		roomService.delete(id);
		return "redirect:/hotel/admin/rooms";
	}

}