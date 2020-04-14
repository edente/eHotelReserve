package edu.miu.cs544.eHotelReserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
	
	@GetMapping(value = {"/","/home","/hotel/home"})
	public String homePage() {
		return "public/home/index";
	}
	
	@GetMapping(value = "/hotel/about")
	public String aboutPage() {
		return "public/home/about";
	}
	
	@GetMapping(value = "/hotel/contact")
	public String contactPage() {
		return "public/home/contact";
	}
	
	@GetMapping(value = "/hotel/services")
	public String servicesPage() {
		return "public/home/services";
	}
	
}
