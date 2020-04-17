package edu.miu.cs544.eHotelReserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import edu.miu.cs544.eHotelReserve.model.Login;
import edu.miu.cs544.eHotelReserve.model.UserCredential;
import edu.miu.cs544.eHotelReserve.service.IUserCredentialService;

import javax.validation.Valid;

@RequestMapping("/hotel/credential")
@Controller
public class UserCredentialController {

	@Autowired
	private IUserCredentialService userCredentialService;


	@GetMapping(value = "/registration")
	public String openRegistration(WebRequest r, Model model) {
		UserCredential userCredential = new UserCredential();
		model.addAttribute("userCredential", userCredential);
		return "credential/registration";
	}

	@PostMapping(value = "/registration")
	public String addNewUserCredential(@Valid @ModelAttribute("userCredential") UserCredential userCredential,
							 BindingResult bindingResult, Model model) {
		System.out.println("registration start");
		if (bindingResult.hasErrors()) {
			System.out.println("registration error");
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "credential/registration";
		}
		 userCredentialService.save(userCredential);
		return "Forward:/hotel/credential/login";
	}

	@GetMapping(value = "/login")
	public String openLogin(WebRequest r, Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "credential/login";
	}

	@PostMapping(value = "/login")
	public String login(@Valid @ModelAttribute("credential") Login login, Model model) {
		UserCredential userCredentialdb = userCredentialService.findByUserName(login.getUserName());

		if (userCredentialdb.getPassword().equals(login.getPassword())) {
			return "redirect:/";
		}
		model.addAttribute("error", "login failed");
		model.addAttribute("login", login);
		return "credential/login";
	}
 

//	@GetMapping(value = "/credentials/edit/{username}")
//	public String editUserForm(@PathVariable("username") String username, Model model) {
//		UserCredential userCredential = userCredentialService.findByUserName(username);
//		if (userCredential != null) {
//			model.addAttribute("userCredential", userCredential);
//			return "credential/credentials/editcredentialform";
//		}
//		return "credential/credentials/credentials";
//	}

//	@GetMapping(value = "/company/credential/credentials/delete/{credentialId}")
//	public String deleteCredential(@PathVariable("credentialId") Long id, Model model) {
//		credentialService.delete(id);
//		return "redirect:/company/credential/credentials";
//	}
}