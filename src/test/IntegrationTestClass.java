package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllayer.ControlPayStation;
import controllayer.IllegalCoinException;
import modellayer.*;

public class IntegrationTestClass {
	private ControlPayStation ps;
	private PPayStation pPayStation;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
		pPayStation = new PPayStation(1, "Gay");
	}

	@Test(expected = IllegalCoinException.class)
	public void currencyNokFRA() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 4;	// In minutes
		int coinValueNOK = 50;
		Currency.ValidCurrency coinCurrencyNOK = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValueNOK, coinCurrencyNOK, coinType);

		// Assert
		
	}
	
	@Test(expected = IllegalCoinException.class)
	public void currencyNokINT() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 4;	// In minutes
		int coinValueNOK = 1;
		Currency.ValidCurrency coinCurrencyNOK = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValueNOK, coinCurrencyNOK, coinType);
		// Assert
	}
	
	@Test
	public void currencyEuro() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 40;	// In minutes
		int coinValueEURO = 1;
		Currency.ValidCurrency coinCurrencyEURO = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValueEURO, coinCurrencyEURO, coinType);

		// Assert
		assertEquals("Should not throw IlligalCoinException", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void currencyCent() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 1;	// In minutes
		int coinValueCENT = 1;
		Currency.ValidCurrency coinCurrencyCENT = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValueCENT, coinCurrencyCENT, coinType);

		// Assert
		assertEquals("Should not throw IlligalCoinException", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void currencyKrone() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 6;	// In minutes
		int coinValueDKK = 1;
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinType);

		// Assert
		assertEquals("Should not throw IlligalCoinException", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void currencyÿre() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 1;	// In minutes
		int coinValueDKK = 1;
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinType);

		// Assert
		assertEquals("Should not throw IlligalCoinException", expectedParkingTime, ps.readDisplay());
	}

/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}

}
