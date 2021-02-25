package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyEuro {

	private ControlPayStation ps;

	/** Fixture for pay station testing. */
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
	
	// BRUGES I RAPPORTEN
	
	@Test
	public void shouldDisplayAboveMAX() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 12080;	// In minutes
		int coinValue = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		for (int i = 0; i < 151; i++) {
		ps.addPayment(coinValue, coinCurrency, coinType);
		System.out.println(ps.readDisplay());
		}
		
		// Assert
		assertEquals("Shit doesn't work yo", expectedParkingTime, ps.readDisplay());
	}
	

	/**
	 * Entering 5 cents should make the display report 2 minutes parking time
	 */
	
	//VI BRUGER DEN HER I RAPPORTEN
	
	@Test
	public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 2;	// In minutes		
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 2 min for 5cent", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay80MinFor2Euro() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 80;	// In minutes		
		int coinValue = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 80 min for 2Euro", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay1MinFor2Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 1;	// In minutes		
		int coinValue = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 1 min for 2cent", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay4MinFor10Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 4;	// In minutes		
		int coinValue = 10;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 4 min for 10cent", expectedParkingTime, ps.readDisplay());
	}
	
	@Test
	public void shouldDisplay8MinFor20Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 8;	// In minutes		
		int coinValue = 20;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 8 min for 20cent", expectedParkingTime, ps.readDisplay());
	}
	@Test
	public void shouldDisplay20MinFor50Cents() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 20;	// In minutes		
		int coinValue = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		// Assert
		assertEquals("Should display 8 min for 20cent", expectedParkingTime, ps.readDisplay());
	}
	@Test
	public void shouldDisplay41MinFor1Cents1Euro() throws IllegalCoinException {
		
		// Arrange
		int expectedParkingTime = 41;	// In minutes		
		int coinValueCent = 1;
		int coinValueEuro = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinTypeFRAC = Currency.ValidCoinType.FRACTION;
		Currency.ValidCoinType coinTypeINT = Currency.ValidCoinType.INTEGER;
		
		// Act
		ps.addPayment(coinValueCent, coinCurrency, coinTypeFRAC);
		ps.addPayment(coinValueEuro, coinCurrency, coinTypeINT);
		// Assert
		assertEquals("Should display 8 min for 20cent", expectedParkingTime, ps.readDisplay());
	}

	
}
