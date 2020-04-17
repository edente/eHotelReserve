package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.eHotelReserve.RestHttpHeader;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.repository.IPaymentRepository;
import edu.miu.cs544.eHotelReserve.service.IPaymentService;


@Service("paymentService")
public class PaymentService implements IPaymentService{
	
	String baseUrl = "http://localhost:8000/MemberRest/payments";
	String baseUrlExtended = baseUrl + "/save";
	
	@Autowired
	RestHttpHeader restHelper;
	
	@Autowired
	public PaymentService(IPaymentRepository paymentRepository) {

	}

	@Override
	public List<Payment> findAll() {
		return null;
	}

	@Override
	public Payment save(Payment payment) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		System.out.println("posting payment***********************");
		HttpEntity<Payment> httpEntity = new HttpEntity<Payment>(payment, restHelper.getHttpHeaders());
		
		restTemplate.postForObject(baseUrlExtended, httpEntity, Payment.class);
		return null;
	}

	@Override
	public Payment findById(Long pId) {
		return null;
	}

	@Override
	public void delete(Long pId) {		
	}

	@Override
	public Double getTotalPrice(Payment payment) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}
}

	
