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

import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IUserService;

@RequestMapping("/hotel/user/users")
@Controller

public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/")
	public ModelAndView manageCategories() {
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.findAll();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("user/users/users");
		return modelAndView;
	}
	
	@GetMapping(value = "/add")
    public String newUserForm(Model model) {
		User user = new User();
        model.addAttribute("user", user);
        return "user/users/newuserform";
    }

	@PostMapping(value = "/add/save")
	public String addNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "user/users/newuserform";
		}
		 userService.save(user);
		return "redirect:/hotel/user/users";
	}

	@GetMapping(value = "/edit/{userId}")
	public String editUserForm(@PathVariable("userId") Long userId, Model model) {
		User user = userService.findById(userId);
		if (user != null) {
			model.addAttribute("user", user);
			return "user/users/edituserform";
		}
		return "user/users/users";
	}

//	@GetMapping(value = "/delete/{userId}")
//	public String deleteUser(@PathVariable("userId") Long id, Model model) {
//		userService.delete(id);
//		return "redirect:/hotel/user/users";
//	}
}