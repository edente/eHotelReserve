package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.repository.IPaymentRepository;
import edu.miu.cs544.eHotelReserve.service.IPaymentService;


@Service("paymentService")
public class PaymentService implements IPaymentService{
	
	private IPaymentRepository paymentRepository;
	
	@Autowired
	public PaymentService(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findById(Long pId) {
		return paymentRepository.findById(pId).orElse(null);
	}

	@Override
	public void delete(Long pId) {
		paymentRepository.deleteById(pId);
		
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

	
