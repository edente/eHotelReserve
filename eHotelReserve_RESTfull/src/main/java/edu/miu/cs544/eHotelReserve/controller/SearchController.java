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
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;
import edu.miu.cs544.eHotelReserve.service.ISearchService;
import edu.miu.cs544.eHotelReserve.service.impl.SearchService;
import edu.miu.cs544.eHotelReserve.utility.RequestPeriod;

@Controller
public class SearchController {
	
	@Autowired
	private ISearchService searchService;
	
	@Autowired
	private IRoomTypeService roomTypeService;
	
	private RequestPeriod temp = new RequestPeriod();
	
	public RequestPeriod getTemp() {
		return temp;
	}

	public void setTemp(RequestPeriod temp) {
		this.temp = temp;
	}
	
	@GetMapping(value = "/company/search")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    public List<RoomType> searchRoom(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate start, 
    		@RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {

        List<RoomType> availableRoom = searchService.findAvailableRoomTypes(start, end);
        temp.setStart(start);
        temp.setEnd(end);
        return availableRoom;
    }

}
