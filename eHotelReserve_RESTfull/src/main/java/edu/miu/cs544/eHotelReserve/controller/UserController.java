package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IUserService;

@RestController
@RequestMapping("/hotel/user/users")
public class UserController {

	private IUserService userService;
	private ObjectMapper oM;

	
     @Autowired
	public UserController(IUserService userService, MappingJackson2HttpMessageConverter springMvcJacksonConverter,
			DozerBeanMapper dozerBeanMapper) {
		this.userService = userService;
		oM= springMvcJacksonConverter.getObjectMapper();
	

	}

	@GetMapping(value = { "", "/all" })
	public List<User> getUsers() {
		System.out.println("****I am in the list of users******");
		List<User> users = userService.findAll();
		System.out.println(users);
		return userService.findAll();

	}

	@PostMapping(value = "/add/save")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addNewUser(@RequestBody User user) {
		userService.save(user);
		System.out.println("----i am the user in save method----" + user);

	}

	@GetMapping(value = "/edit/{userId}")
	public User editUserForm(@PathVariable("userId") Long userId) {
		User user = userService.findById(userId);
		System.out.println("user id ***** " + userId);
		return user;
	}

	@GetMapping(value = "/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Long id) {
		userService.delete(id);
	}

	@PutMapping(value = "/put/{id}")
	public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		userService.delete(id);
		userService.update(user);
		return;
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);

	}

//	@PatchMapping("/patch/{id}")
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//	public void patchMemberById(@PathVariable("id") Long id, @RequestBody Map<String,Object> patchMap) {
//		
//  		// Convert Patch Map to member 
//  		User patchUser = objectMapper.convertValue(patchMap, User.class);
// 
//  		userService.patch(id, patchUser);
//  		
//  		return ; 
//	}
}