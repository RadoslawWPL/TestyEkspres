package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.SkladnikCiekly;

public class TSkladnikCiekly {
	
	@Test
	public void sprawdzTworzenieSkladnikaCieklego() {
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Assert.assertNotNull(skladnikGlowny);
	}

	@Test
	public void testNazwy() {
		for(int i = 0; i<100; i++)
		{
			SkladnikCiekly przygotujSkladnik = new SkladnikCiekly("Ciecz" + i, 1, 2, 3);
			Assert.assertEquals("Ciecz"+i, przygotujSkladnik.podajNazwe());
			
			Assert.assertNotEquals("Ciecz" + (i+2), przygotujSkladnik.podajNazwe());
		}	
	}
	
	@Test
	public void testWymaganejTemperatury() {
		for(int i = 0; i<100; i++)
		{
			SkladnikCiekly przygotujSkladnik = new SkladnikCiekly("Ciecz", i, 2, 3);
			Assert.assertEquals(i, przygotujSkladnik.podajWymaganaTemperatura(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.podajWymaganaTemperatura(), 0);
		}
	}
	
	@Test
	public void testWymaganegoCisnienia() {
		for(int i = 0; i<100; i++)
		{
			SkladnikCiekly przygotujSkladnik = new SkladnikCiekly("Ciecz", 1, i, 3);
			Assert.assertEquals(i, przygotujSkladnik.wymogSkladnika(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.wymogSkladnika(), 0);
		}
	}
	
	@Test
	public void testWymaganejIlosci() {
		for(int i = 0; i<100; i++)
		{
			SkladnikCiekly przygotujSkladnik = new SkladnikCiekly("Ciecz", 1, 2, i);
			Assert.assertEquals(i, przygotujSkladnik.podajWymaganaIlosc(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.podajWymaganaIlosc(), 0);
		}
	}
	
	@Test
	public void testUstawianiaIlosci() {
		SkladnikCiekly przygotujSkladnik = new SkladnikCiekly("Ciecz", 1, 2, 10);
		Assert.assertEquals(10, przygotujSkladnik.podajWymaganaIlosc(), 0);
		
		Assert.assertNotEquals(5, przygotujSkladnik.podajWymaganaIlosc(), 0);
		
		for(int i = 0; i<100; i++)
		{
			przygotujSkladnik.ustawIlosc(i);
			Assert.assertEquals(i, przygotujSkladnik.podajWymaganaIlosc(), 0);
			
			Assert.assertNotEquals(i+2, przygotujSkladnik.podajWymaganaIlosc(), 0);
		}
		
	}
}
