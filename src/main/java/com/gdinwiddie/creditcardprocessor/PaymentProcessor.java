package com.gdinwiddie.creditcardprocessor;

import com.gdinwiddie.creditcardprocessor.merchantbank.JsonMerchantBankAdapter;

public class PaymentProcessor {

	private static final int HOROSCOPE_PRICE_IN_DOLLARS = 2;
	protected static PaymentProcessor theProcessor;
	private final MerchantBank merchantBankAdapter;

	public PaymentProcessor(MerchantBank merchantBank) {
		this.merchantBankAdapter = merchantBank;
	}

	public static PaymentProcessor instance() {
		if (null == theProcessor) {
			theProcessor = new PaymentProcessor(new JsonMerchantBankAdapter());
		}
		return theProcessor;
	}

	public PaymentResult acceptPayment(CreditCardInfo creditCard) {
		if (!creditCard.validate()) {
			return new PaymentResult(false, "Invalid card information");
		}
		return merchantBankAdapter.processPayment(HOROSCOPE_PRICE_IN_DOLLARS, creditCard);
	}

}
