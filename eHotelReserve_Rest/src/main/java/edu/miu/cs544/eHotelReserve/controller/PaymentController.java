package edu.miu.cs544.eHotelReserve.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.service.IPaymentService;

@Controller("/user/payments")
public class PaymentController {
	
	@Autowired
    private IPaymentService paymentService;
	
	@GetMapping(value = {"","/all"})
    public List<Payment> managePayments() {

        return paymentService.findAll();

    }
	
//	@GetMapping(value = "/add")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//    public String newPaymentForm(Model model) {
//		Payment newPayment = new Payment();
//        model.addAttribute("payment", newPayment);
//        return "public/book/paymentform";
//    }
	
	
	@PostMapping(value = "/save")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    public void addNewPayment(Payment payment) {
        paymentService.save(payment);
    }
	
	
	@GetMapping(value = "/edit/{paymentId}")
    public Payment editPaymentForm(@PathVariable("paymentId") Long paymentId) {
		Payment payment = paymentService.findById(paymentId);
        return payment;
    }
	@GetMapping(value="/delete/{paymentId}")
	public void deletePayment(@PathVariable("paymentId") Long id){		
		paymentService.delete(id);

	}
	

}