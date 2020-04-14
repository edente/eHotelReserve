package edu.miu.cs544.eHotelReserve.repository;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	
	@Column(name = "payment_date")
//	@NotNull(message = "*Please provide payment date")
	private LocalDate paymentDate;

	@Column(name = "payment_type")
//	@NotNull(message = "*Please provide payment type") 
    private String paymentType;

	@Column(name = "card_number")
//	@NotNull(message = "*Please provide payment card type") 
    private Long cardNumber;
    
	@Column(name = "card_cvv")
//	@NotNull(message = "*Please provide payment card CSV") 
    private Integer cardCVV;
    
	@Column(name = "total_price") 
    private Double totalPrice;
    
	@Column(name = "payment_status")
//	@NotNull 
	private String paymentStatus;
	

    public Payment() {
    }


	public Payment(User customer, LocalDate paymentDate, String paymentType, Long cardNumber,
			Integer cardCVV, Double totalPrice, String paymentStatus) {

		
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.cardCVV = cardCVV;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}



	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public Long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Integer getCardCVV() {
		return cardCVV;
	}


	public void setCardCVV(Integer cardCVV) {
		this.cardCVV = cardCVV;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

   
}
