package edu.miu.cs544.eHotelReserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.model.Payment;



@Repository("paymentRepository")
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}

	
