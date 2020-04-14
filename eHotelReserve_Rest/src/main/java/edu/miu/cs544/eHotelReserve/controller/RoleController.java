package edu.miu.cs544.eHotelReserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.miu.cs544.eHotelReserve.service.IRoleService;


@Controller
public class RoleController {
	
	@Autowired
    private IRoleService roleService;

}