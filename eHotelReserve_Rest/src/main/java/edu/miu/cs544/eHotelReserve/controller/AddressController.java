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

import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.service.IAddressService;

@RestController("/user/addresses")
public class AddressController {
	
	@Autowired
	private IAddressService addressService;

	@GetMapping(value = "/add")
    public String newAddressForm(Model model) {
		Address newAddress = new Address();
        model.addAttribute("address", newAddress);
        return "user/addresses/addressform";
    }
	
	@PostMapping(value = "/add")
    public void addNewAddress(Address address) {
         addressService.save(address);
    }
	
	@GetMapping(value = "/edit/{addressId}")
    public Address editAddressForm(@PathVariable("addressId") Long addressId) {
		Address address = addressService.findById(addressId);

            return address;


    }
	
	@PostMapping(value = "/edit/{addressId}")
    public void updateAddress(@Valid @ModelAttribute("addressId") Address address) {

    }
	
	@GetMapping(value="/delete/{addressId}")
	public void deleteAddress(@PathVariable("addressId") Long id){		
		addressService.delete(id);

	}
	
}
