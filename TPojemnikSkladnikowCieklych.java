package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.PojemnikSkladnikowCieklych;

public class TPojemnikSkladnikowCieklych {
	
	@Test
	public void sprawdzInicjowaniePojemnikaSkladnikowCieklych() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(100, "TEST1");
		Assert.assertNotNull(pojemnik);
	}

	@Test
	public void sprawdzDostepnaIlosc() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(100, "TEST1");
		Assert.assertEquals(100, pojemnik.podajDostepnaIlosc(), 0);
		
		Assert.assertNotEquals(200, pojemnik.podajDostepnaIlosc(), 0);
	}
	
	@Test
	public void sprawdzDostepnaIloscPoZmianie() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(200, "TEST2");
		for(int ilosc = 1; ilosc <200; ilosc++)
		{
			pojemnik.ustawIlosc(ilosc);
			Assert.assertEquals(ilosc, pojemnik.podajDostepnaIlosc(), 0);
		
			Assert.assertNotEquals(ilosc+ilosc, pojemnik.podajDostepnaIlosc(), 0);
		}
	}

	@Test
	public void sprawdzNazweSkladnika() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(100, "TEST3");
		Assert.assertEquals("TEST3", pojemnik.podajNazweSkladnika());
		
		Assert.assertNotEquals("TEST1", pojemnik.podajNazweSkladnika());
	}
	
	@Test
	public void sprawdzNazwePojemnika() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(100, "TEST4");
		Assert.assertEquals("pojemnikNaTEST4", pojemnik.podajNazwe());
		
		Assert.assertNotEquals("TEST4", pojemnik.podajNazwe());
	}
	
	@Test
	public void sprawdzDostepnaIloscPoZabraniuCzesci() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(100, "TEST5");
		pojemnik.wezOdpowiedniaIlosc(30);
		Assert.assertEquals(70, pojemnik.podajDostepnaIlosc(), 0);
		
		Assert.assertNotEquals(30, pojemnik.podajDostepnaIlosc(), 0);
	}
	
	@Test
	public void sprawdzZabezpieczeniePrzedPobraniemZaDuzejIlosci() {
		PojemnikSkladnikowCieklych pojemnik = new PojemnikSkladnikowCieklych(100, "TEST6");
		pojemnik.wezOdpowiedniaIlosc(110);
		Assert.assertEquals(100, pojemnik.podajDostepnaIlosc(), 0);
		int nowaIlosc = 100;
		for(int ilosc = 0; ilosc <14; ilosc++)
		{
			pojemnik.wezOdpowiedniaIlosc(ilosc);
			nowaIlosc = nowaIlosc - ilosc;
			Assert.assertEquals(nowaIlosc, pojemnik.podajDostepnaIlosc(), 0);
			
			Assert.assertNotEquals(nowaIlosc+nowaIlosc, pojemnik.podajDostepnaIlosc(), 0);
		}
		pojemnik.wezOdpowiedniaIlosc(10);
		Assert.assertEquals(9, pojemnik.podajDostepnaIlosc(), 0);
		
		Assert.assertNotEquals(10, pojemnik.podajDostepnaIlosc(), 0);
	}
}
