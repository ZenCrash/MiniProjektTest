package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllayer.ControlPayStation;
import controllayer.IllegalCoinException;
import modellayer.Currency;

public class SystemTest {
	private ControlPayStation ps;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	@Test
	public void shouldDisplay6minutesFor1Euro() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 40;	// In minutes
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 6 min for 1Euro", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay80MinFor2Euro() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 80;	// In minutes		
		int coinValue = 1;
		int coinValue2 = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		ps.addPayment(coinValue2, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 80 min for 2Euro", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay3MinFor50Ore() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 3;	// In minutes
		int coinValue = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 3 min for 50 øre", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay3MinFor50Orex2() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 6;	// In minutes
		int coinValue = 50;
		int coinValue2 = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		ps.addPayment(coinValue2, coinCurrency, coinType);
			
		// Assert
		assertEquals("Should display 3 min for 50 øre", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplayMultiple() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 49;	// In minutes
		int coinValueDKK = 50;
		int coinValueEURO = 1;
		int coinValueDKKINT = 1;
		int coinValueEUROINT = 1;
		
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCurrency coinCurrencyEURO = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinTypeFRA = Currency.ValidCoinType.FRACTION;
		Currency.ValidCoinType coinTypeINT = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinTypeFRA);
		ps.addPayment(coinValueEURO, coinCurrencyEURO, coinTypeFRA);
		ps.addPayment(coinValueDKKINT, coinCurrencyDKK, coinTypeINT);
		ps.addPayment(coinValueEUROINT, coinCurrencyEURO, coinTypeINT);

		// Assert
		assertEquals("Should display 49 min for 1 krone, 1 euro, 50 øre and 1 cent", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplayMultiplex2() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 49;	// In minutes
		int coinValueDKK = 50;
		int coinValueEURO = 1;
		int coinValueDKKINT = 1;
		int coinValueEUROINT = 1;
		int coinValueNOKINT = 1;
		int coinValueNOK = 50;
		
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCurrency coinCurrencyEURO = Currency.ValidCurrency.EURO;
		Currency.ValidCurrency coinCurrencyNOK = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinTypeFRA = Currency.ValidCoinType.FRACTION;
		Currency.ValidCoinType coinTypeINT = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinTypeFRA);
		ps.addPayment(coinValueEURO, coinCurrencyEURO, coinTypeFRA);
		ps.addPayment(coinValueDKKINT, coinCurrencyDKK, coinTypeINT);
		ps.addPayment(coinValueEUROINT, coinCurrencyEURO, coinTypeINT);
		ps.addPayment(coinValueNOKINT, coinCurrencyNOK, coinTypeINT);
		ps.addPayment(coinValueNOK, coinCurrencyNOK, coinTypeFRA);

		// Assert
		assertEquals("Should display 49 min for 1 krone, 1 euro, 50 øre and 1 cent", expectedParkingTime, ps.readDisplay());
	}
	
	@After
	public void cleanUp() {
		ps.setReady();
	}
	
	
}
