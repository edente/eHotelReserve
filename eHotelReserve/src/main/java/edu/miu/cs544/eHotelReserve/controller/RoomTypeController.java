package edu.miu.cs544.eHotelReserve.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.amqpconfigJava.AmqpConfiguration;
import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;
import edu.miu.cs544.eHotelReserve.service.impl.BookingService;

@RequestMapping("/hotel/admin/roomTypes")
@Controller
public class RoomTypeController {
	
	@Autowired
    private IRoomTypeService roomTypeService;
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping(value = "")
    public ModelAndView manageRoomTypes() {
        
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println();
	     System.out.print("*************HIT RETURN send message to sanfrasisco*********************::   ");
	      System.out.println();
	        try {
				in.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AmqpConfiguration.class);
		// Put booking into Spring Integration through OrderGateway
    
    Address address1= new Address("111","san","tx","1234","s@g","123456789");
    User user1= new User("selam","Gd",address1,"sel","1234");
    RoomType roomType1= new RoomType("11","master",100.00,null);
    Room room1= new Room("11",roomType1);
    Payment payment1= new Payment(user1,null,"card",12341234L,345,100.00,"paid");

    Booking newBooking= new Booking(1L,"11",null,null,null,200.00,"SanFrancisco",user1,room1,payment1);
		bookingService.publish(newBooking, context);
 	
 	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.print("*************HIT RETURN send message to sanfrasisco*********************::   ");
	     
	     
       ModelAndView modelAndView = new ModelAndView();
       List<RoomType> roomTypes = roomTypeService.findAll();
       modelAndView.addObject("roomTypes", roomTypes);
       modelAndView.setViewName("admin/roomTypes/roomTypes");
       return modelAndView;
    }
	
	
	
	
	
	@GetMapping(value = "/add")
    public String newCategoryForm(Model model) {
        model.addAttribute("roomTypes", new RoomType());
        return "admin/roomTypes/newroomTypesform";
    }
	
	@PostMapping(value = "/add/save")
    public String addNewCategory(@Valid @ModelAttribute("roomType") RoomType roomType,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/roomTypes/newroomTypesform";
        }
        roomType = roomTypeService.save(roomType);
        return "redirect:/hotel/admin/roomTypes";
    }
	
	@GetMapping(value = "/edit/{roomTypeId}")
    public String editCategoryForm(@PathVariable("roomTypeId") Long roomTypeId, Model model) {
		RoomType roomType = roomTypeService.findById(roomTypeId);
        if (roomType != null) {
            model.addAttribute("roomType", roomType);
            return "admin/roomTypes/editroomTypesform";
        }
        return "admin/roomTypes/roomTypes";
    }
	
	@GetMapping(value="/delete/{roomTypeId}")
	public String deleteCategory(@PathVariable("roomTypeId") Long id, Model model){		
		roomTypeService.delete(id);
		return "redirect:/hotel/admin/roomTypes";
	}

}
