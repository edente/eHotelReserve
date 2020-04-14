package edu.miu.cs544.eHotelReserve.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.eHotelReserve.dao.IPaymentDao;
import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.service.IPaymentService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Service("paymentService")
public class PaymentService implements IPaymentService{
	
	private IPaymentDao paymentDao;
	
	@Autowired
	public PaymentService(IPaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	@Override
	public List<Payment> findAll() {
		return paymentDao.findAll();
	}

	@Override
	public void save(Payment payment) {
		 paymentDao.save(payment);
	}

	@Override
	public Payment findById(Long pId) {
		return paymentDao.findOne(pId);
	}

	@Override
	public void delete(Long pId) {
		paymentDao.delete(pId);;
		
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

	
