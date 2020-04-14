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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IUserService;


@RestController("/user")
public class UserController {
	
	@Autowired
    private IUserService userService;
	
	@GetMapping(value = {"users","users/all"})
    public List<User> getUsers() {
        return userService.findAll();

    }
	
	@PostMapping(value = "users/save")
    public void addNewUser(User user) {
        userService.save(user);

    }
	
	@GetMapping(value = "users/edit/{userId}")
    public User editUserForm(@PathVariable("userId") Long userId) {
		User user = userService.findById(userId);
        return user;
    }
	
	@GetMapping(value="users/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Long id){		
		userService.delete(id);
	}
}