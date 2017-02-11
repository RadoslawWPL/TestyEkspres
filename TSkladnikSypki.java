package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.SkladnikSypki;

public class TSkladnikSypki {
	
	@Test
	public void sprawdzTworzenieSkladnikaSypkiego() {
		SkladnikSypki przygotujSkladnik = new SkladnikSypki("Proszek", 1, 2, 3);
		Assert.assertNotNull(przygotujSkladnik);
	}

	@org.junit.Test
	public void testNazwy() {
		for(int i = 0; i<100; i++)
		{
			SkladnikSypki przygotujSkladnik = new SkladnikSypki("Proszek" + i, 1, 2, 3);
			Assert.assertEquals("Proszek"+i, przygotujSkladnik.podajNazwe());
			
			Assert.assertNotEquals("Proszek", przygotujSkladnik.podajNazwe());
		}	
	}
	
	@org.junit.Test
	public void testWymaganejTemperatury() {
		for(int i = 0; i<100; i++)
		{
			SkladnikSypki przygotujSkladnik = new SkladnikSypki("Proszek", i, 2, 3);
			Assert.assertEquals(i, przygotujSkladnik.podajWymaganaTemperatura(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.podajWymaganaTemperatura(), 0);
		}
	}
	
	@org.junit.Test
	public void testWymaganegoCzasuMielenia() {
		for(int i = 0; i<100; i++)
		{
			SkladnikSypki przygotujSkladnik = new SkladnikSypki("Proszek", 1, i, 3);
			Assert.assertEquals(i, przygotujSkladnik.wymogSkladnika(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.wymogSkladnika(), 0);
		}
	}
	
	@org.junit.Test
	public void testWymaganejIlosci() {
		for(int i = 0; i<100; i++)
		{
			SkladnikSypki przygotujSkladnik = new SkladnikSypki("Proszek", 1, 2, i);
			Assert.assertEquals(i, przygotujSkladnik.podajWymaganaIlosc(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.podajWymaganaIlosc(), 0);
		}
	}
	
	
	@org.junit.Test
	public void testUstawianiaIlosci() {
		SkladnikSypki przygotujSkladnik = new SkladnikSypki("Ciecz", 1, 2, 10);
		Assert.assertEquals(10, przygotujSkladnik.podajWymaganaIlosc(), 0);
		
		for(int i = 0; i<100; i++)
		{
			przygotujSkladnik.ustawIlosc(i);
			Assert.assertEquals(i, przygotujSkladnik.podajWymaganaIlosc(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.podajWymaganaIlosc(), 0);
		}
	}
}
