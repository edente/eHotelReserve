package edu.miu.cs544.eHotelReserve.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@OneToOne
    private User customer;
    private String cardType;
    private String cardProvider;
    private String cardFullName;
    private String cardNumber;
    private LocalDate expirationDate;
    private String billingAddress;
    private String cvv;

    public Payment() {
    }

    public Payment(String cardType, String cardProvider,
                   String cardFullName, String cardNumber,
                   LocalDate expirationDate,
                   String billingAddress, String cvv) {
        this.cardType = cardType;
        this.cardProvider = cardProvider;
        this.cardFullName = cardFullName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.billingAddress = billingAddress;
        this.cvv = cvv;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCvv(User customer) {
        this.customer = customer;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public String getCardFullName() {
        return cardFullName;
    }

    public void setCardFullName(String cardFullName) {
        this.cardFullName = cardFullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCVV(String CVV) {
        this.cvv = CVV;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
