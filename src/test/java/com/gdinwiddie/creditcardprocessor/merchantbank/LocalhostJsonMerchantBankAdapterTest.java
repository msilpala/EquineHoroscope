package com.gdinwiddie.creditcardprocessor.merchantbank;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.PaymentResult;
import com.gdinwiddie.creditcardprocessor.TestingCreditCards;
import com.github.dreamhead.moco.HttpServer;
import org.junit.Before;
import org.junit.Test;

import static com.github.dreamhead.moco.Moco.pathResource;
import static com.github.dreamhead.moco.MocoJsonRunner.jsonHttpServer;
import static com.github.dreamhead.moco.Runner.running;
import static org.junit.Assert.*;

public class LocalhostJsonMerchantBankAdapterTest {
	@SuppressWarnings("unused")
	public static final CreditCardInfo invalidCard = new CreditCardInfo("4222222222222220", "123", "12/2099");
	private JsonMerchantBankAdapter bankAdapter;
	private HttpServer server;

	@Before
	public void setUp() {
		server = jsonHttpServer(12345, pathResource("com/gdinwiddie/creditcardprocessor/merchantbank/moco_config.json"));
		bankAdapter = new JsonMerchantBankAdapter();
		bankAdapter.setBankURL("http://localhost:12345");
	}

	@Test
	public void testInvalidCard() throws Exception {
		running(server, () -> {
			PaymentResult paymentResult = bankAdapter.processPayment(10, TestingCreditCards.invalidCard);
			assertFalse(paymentResult.isSuccessful());
			assertEquals("invalid card", paymentResult.getReason());
		});
	}

	@Test
	public void testValidCard() throws Exception {
		running(server, () -> {
			PaymentResult paymentResult = bankAdapter.processPayment(10, TestingCreditCards.goodCard);
			assertEquals("", paymentResult.getReason());
			assertTrue(paymentResult.isSuccessful());
		});
	}

}
