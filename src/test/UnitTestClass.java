package test;

import static org.junit.Assert.*;

import org.junit.*;

import controllayer.ControlPrice;
import databaselayer.DatabaseLayerException;
import databaselayer.DatabasePBuy;
import databaselayer.DatabasePPrice;
import databaselayer.IDbPPrice;
import modellayer.Currency;
import modellayer.PPrice;
import modellayer.PZone;


import org.junit.Test;

public class UnitTestClass {
	private IDbPPrice dbPrice;

	@Before
	public void setUp() {
		this.dbPrice = new DatabasePPrice();
		
	
	}
	@Test
	public void testPriceByZoneID() throws DatabaseLayerException {
		//arrange
		int expectedPrice = 25;
		PZone zone = new PZone();
		int zoneID = zone.getpZoneId();
		System.out.println(zoneID);
		
		
		//act
		
		PPrice price = dbPrice.getPriceByZoneId(zoneID);
		System.out.println(zoneID);
		
		System.out.println(price);
		
		//assert
		
		int p = price.getParkingPrice();
		System.out.println(p);
		
		assertEquals(p, expectedPrice);
	}
	
	@Test
	public void t() throws DatabaseLayerException {
		//arrange
		
		
		//act
		
		
		
		//assert
		
		
		
		//assertEquals();
	}
	
		@After
		public void cleanUp() {
			}
		}


