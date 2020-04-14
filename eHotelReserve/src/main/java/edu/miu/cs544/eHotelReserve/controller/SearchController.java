package edu.miu.cs544.eHotelReserve.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.service.impl.RoomTypeService;
import edu.miu.cs544.eHotelReserve.service.impl.SearchService;
import edu.miu.cs544.eHotelReserve.utility.RequestPeriod;



@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	private RequestPeriod temp = new RequestPeriod();
	
	public RequestPeriod getTemp() {
		return temp;
	}

	public void setTemp(RequestPeriod temp) {
		this.temp = temp;
	}
	
	@GetMapping(value = "/hotel/search")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    public ModelAndView searchRooms(@RequestParam("checkIn") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate checkIn, 
    		@RequestParam("checkOut") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate checkOut) {
		ModelAndView modelAndView = new ModelAndView();
        List<RoomType> availableRoomTypes = searchService.findAvailableRoomTypes(checkIn, checkOut);
        modelAndView.addObject("availableRoomTypes", availableRoomTypes);
        modelAndView.setViewName("public/search/results");
        temp.setStart(checkIn);
        temp.setEnd(checkOut);
        return modelAndView;
    }

}
