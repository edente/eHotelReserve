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
import edu.miu.cs544.eHotelReserve.service.IAddressService;


@RequestMapping("/hotel/user/addresses")
@Controller
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	@GetMapping(value = "/")
    public ModelAndView listAddresses() {
        ModelAndView modelAndView = new ModelAndView();
        List<Address> addresses = addressService.findAll();
        modelAndView.addObject("addresses", addresses);
        modelAndView.setViewName("user/addresses/addresses");
        return modelAndView;
    }
	
	@GetMapping(value = "/add")
    public String newAddressForm(Model model) {
		Address newAddress = new Address();
        model.addAttribute("address", newAddress);
        return "user/addresses/addressform";
    }
	
	@PostMapping(value = "/add/save")
    public String addNewAddress(@Valid @ModelAttribute("address") Address address,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/addresses/addressform";
        }
        address = addressService.save(address);
        return "redirect:/hotel/user/addresses";
    }
	
	@GetMapping(value = "/edit/{addressId}")
    public String editAddressForm(@PathVariable("addressId") Long addressId, Model model) {
		Address address = addressService.findById(addressId);
        if (address != null) {
            model.addAttribute("address", address);
            return "user/addresses/addressform";
        }
        return "redirect:/hotel/user/addresses";
    }
	
	@PostMapping(value = "/edit/save")
    public String updateAddress(@Valid @ModelAttribute("address") Address address,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/addresses/addresseditform";
        }
        address = addressService.save(address);
        return "redirect:/hotel/user/addresses";
    }
	
	@GetMapping(value="/delete/{addressId}")
	public String deleteAddress(@PathVariable("addressId") Long id, Model model){		
		addressService.delete(id);
		return "redirect:/hotel/user/addresses";
	}
	
}
