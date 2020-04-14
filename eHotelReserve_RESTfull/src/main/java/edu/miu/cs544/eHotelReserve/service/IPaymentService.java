package edu.miu.cs544.eHotelReserve.service;

import java.util.List;

import edu.miu.cs544.eHotelReserve.model.Payment;


public interface IPaymentService {
	
	List<Payment>findAll();
	void save(Payment payment);
	Payment findById(Long pId);
	void delete(Long pId);
	String count();
	Double getTotalPrice(Payment payment);

}

	
