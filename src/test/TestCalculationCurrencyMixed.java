package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyMixed {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Entering 1 cent and 50 øre should make the display report 4 minutes parking time.
	 */
	@Test
	public void shouldDisplay4MinFor1CentAnd50Ore() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 4;	// In minutes
		int coinValueDKK = 50;
		int coinValueEURO = 1;
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCurrency coinCurrencyEURO = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinType);
		ps.addPayment(coinValueEURO, coinCurrencyEURO, coinType);

		// Assert
		assertEquals("Should display 4 min for 50 øre and 1 cent", expectedParkingTime, ps.readDisplay());
	}
	@Test(expected = IllegalCoinException.class)
	public void shouldDisplay4MinFor50OreAnd50Ore() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 3;	// In minutes
		int coinValueDKK = 50;
		int coinValueNOK = 50;
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCurrency coinCurrencyNOK = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinType);
		ps.addPayment(coinValueNOK, coinCurrencyNOK, coinType);

		// Assert
		assertEquals("Should display 4 min for 50 øre and 1 cent", expectedParkingTime, ps.readDisplay());
	}

	
	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}
	
}
