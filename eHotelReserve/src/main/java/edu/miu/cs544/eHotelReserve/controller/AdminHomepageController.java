package edu.miu.cs544.eHotelReserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hotel/admin")
@Controller
public class AdminHomepageController {
	
	@GetMapping(value = "/home")
	public String adminHomePage() {
		return "admin/home/adminhome";
	}
	
	@GetMapping(value = "/underconstruction")
	public String underConstruction() {
		return "general/underconstruction";
	}
	
}
