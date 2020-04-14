package edu.miu.cs544.eHotelReserve.dao.impl;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.eHotelReserve.dao.IPaymentDao;
import edu.miu.cs544.eHotelReserve.model.Payment;

@Repository
public class PaymentDao extends GenericDao<Payment> implements IPaymentDao{

}
