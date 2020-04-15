package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.service.ICredentialService;


@RestController
@RequestMapping({"/userCredentials"})
public class CredentialController {
	
	@Autowired
	ICredentialService credentialsService;
	
	@RequestMapping
	public List<UserCredential>  findAll( ) {
		return  credentialsService.findAll();
 
	}
	

 	
 	@RequestMapping("/{id}")
	public UserCredential findOne(@PathVariable("id") String userName ) {

		UserCredential validCredentials = credentialsService.findByUserName(userName);
 
 		return  validCredentials;
	}
 

}