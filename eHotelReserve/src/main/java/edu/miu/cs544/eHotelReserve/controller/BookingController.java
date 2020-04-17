package edu.miu.cs544.eHotelReserve.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.amqpconfigJava.AmqpConfiguration;
import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IBookingService;
import edu.miu.cs544.eHotelReserve.service.IPaymentService;
import edu.miu.cs544.eHotelReserve.service.IRoomService;
import edu.miu.cs544.eHotelReserve.service.IUserService;
import edu.miu.cs544.eHotelReserve.service.impl.SearchService;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequestMapping(value={"/hotel/admin/bookings","/hotel/public/bookings"})
@Controller
public class BookingController {

	@Autowired
	private IBookingService bookingService;

	@Autowired
	private IRoomService roomService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private SearchController searchController;

	@Autowired
	private SearchService searchService;

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AmqpConfiguration.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView bookingsList() {
		List<Booking> bookings = bookingService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookings", bookings);
		modelAndView.setViewName("admin/bookings/bookings");
		return modelAndView;
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public String newBookingForm(Model model) {

		Booking newBooking = new Booking();
		newBooking.setReferenceNumber(bookingService.assignReferenceNumber());
		List<Room> rooms = roomService.findAll();
		List<User> users = userService.findAll();
		List<Payment> payments = paymentService.findAll();
		model.addAttribute("booking", newBooking);
		model.addAttribute("rooms", rooms);
		model.addAttribute("users", users);
		model.addAttribute("payments", payments);
		return "admin/bookings/bookingform";
	}

	@PostMapping(value = "/admin/addnew/save")
	public String addNewBooking(@Valid @ModelAttribute("booking") Booking booking,
								BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/bookings/bookingform";
		}
		booking = bookingService.save(booking);
		return "redirect:/hotel/admin/bookings";
	}

	@GetMapping(value = "/edit/{bookingId}")
	public String editBookingForm(@PathVariable("bookingId") Long bookingId, Model model) {
		Booking booking = bookingService.findById(bookingId);
		if (booking != null) {
			model.addAttribute("booking", booking);
			return "admin/bookings/bookingeditform";
		}
		return "admin/bookings/bookings";
	}

	@PostMapping(value = "/edit/save")
	public String updateBooking(@Valid @ModelAttribute("booking") Booking booking,
								BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/bookings/bookingeditform";
		}
		booking = bookingService.save(booking);

		return "redirect:/hotel/admin/bookings";
	}

	@GetMapping(value="/delete/{bookingId}")
	public String deleteBooking(@PathVariable("bookingId") Long id){
		bookingService.delete(id);
		return "redirect:/hotel/admin/bookings";
	}

	@GetMapping(value = "/addnew/{roomType}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String newPublicBookingForm(Model model, @PathVariable("roomType") RoomType roomType) {

		Booking newBooking = new Booking();
		Payment newPayment = new Payment();
//		paymentService.save(newPayment);
		LocalDate checkIn = searchController.getTemp().getStart();
		LocalDate checkOut = searchController.getTemp().getEnd();
		System.out.println("booking in data===: "+checkIn);
		Long dateDifference = (Long)(ChronoUnit.DAYS.between(checkIn, checkOut));
		Double unitPrice = roomType.getPrice();
		
		Double totalPrice = (double) (dateDifference*unitPrice);
		newBooking.setTotalPrice(totalPrice);
		newBooking.setCheckInDate(checkIn);
		newBooking.setCheckOutDate(checkOut);
//		newBooking.setReferenceNumber(bookingService.assignReferenceNumber());

		newBooking.setReferenceNumber("AFDR56877");
		newBooking.setBookingDate(LocalDate.now());
		newBooking.setPayment(newPayment);
		Room room=new Room( "400",roomType);
		newBooking.setRoom(room);
//		newBooking.setRoom(searchService.getAvailableRooms(checkIn, checkOut)
//				.stream()
//				.filter(v -> v.getRoomtype() == roomType)
//				.findFirst()
//				.orElse(null));
		
		model.addAttribute("booking", newBooking);
		return "public/book/bookingform";
	}

	@PostMapping(value = "/addnew/save")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String addNewBookingPublic(@Valid @ModelAttribute("booking") Booking booking,
									  BindingResult bindingResult, Model model) {

//		if(bindingResult.hasErrors()) {
//			model.addAttribute("errors", bindingResult.getAllErrors());
//			return "public/book/bookingform";
//		}
		
//		booking = bookingService.save(booking);
		
		//sample booking
	    Address address1= new Address("111","sanfransico","tx","1234");

	    User user1= new User("selam","Gd",address1,"sel","1234","ruftaea@gmail.com");
	    RoomType roomType1= new RoomType("11","master",100.00,null);
	    Room room1= new Room("11",roomType1);
	    Payment payment1= new Payment(user1,null,"card",12341234L,345,100.00,"paid");

	    Booking newBooking= new Booking(1L,"11",null,null,null,200.00,"SanJose",user1,room1,payment1);
		
		//end sample
			
			bookingService.publish(newBooking, context);
			System.out.println("After publish ***********");
			
//		return "redirect:/hotel/public/bookings/success";
		return "public/book/confirmation";
	}

	@GetMapping(value = "/hotel/public/bookings/success")
	public String homePage() {
		System.out.println("F I N A L L Y");
		return "public/book/confirmation";
	}

}
