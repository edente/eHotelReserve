package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.eHotelReserve.model.User;
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
	
//	@PostMapping(value = "/add/save")
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void addNewUserCredential(@RequestBody UserCredential userCredential) {
//		credentialsService.save(userCredential);
//        System.out.println("----i am the userredentila in save method----"+ userCredential);
//
//    }
 	
 	@RequestMapping("/{id}")
	public UserCredential findOne(@PathVariable("id") String userName ) {

		UserCredential validCredentials = credentialsService.findByUserName(userName);
 
 		return  validCredentials;
	}
 

}