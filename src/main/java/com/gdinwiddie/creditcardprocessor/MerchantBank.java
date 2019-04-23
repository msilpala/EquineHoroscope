package com.gdinwiddie.creditcardprocessor;

public interface MerchantBank {
	PaymentResult processPayment(int dollars, CreditCardInfo creditCard);
}
