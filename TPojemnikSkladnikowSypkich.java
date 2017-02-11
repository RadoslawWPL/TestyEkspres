package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.PojemnikSkladnikowSypkich;

public class TPojemnikSkladnikowSypkich {
	
	@Test
	public void sprawdzInicjowaniePojemnikaSkladnikowSypkich() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(200, "ciastka");
		Assert.assertNotNull(pojemnik);
	}

	@Test
	public void sprawdzDostepnaIlosc() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(200, "ciastka");
		Assert.assertEquals(200, pojemnik.podajDostepnaIlosc(), 0);
		
		Assert.assertNotEquals(100, pojemnik.podajDostepnaIlosc(), 0);
	}
	
	@Test
	public void sprawdzDostepnaIloscPoZmianie() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(200, "ciastka1");
		for(int ilosc = 1; ilosc <200; ilosc++)
		{
			pojemnik.ustawIlosc(ilosc);
			Assert.assertEquals(ilosc, pojemnik.podajDostepnaIlosc(), 0);
		
			Assert.assertNotEquals(ilosc+ilosc, pojemnik.podajDostepnaIlosc(), 0);
		}
	}

	@Test
	public void sprawdzNazweSkladnika() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(200, "ciastka2");
		Assert.assertEquals("ciastka2", pojemnik.podajNazweSkladnika());
		
		Assert.assertNotEquals("ciastka", pojemnik.podajNazweSkladnika());
	}
	
	@Test
	public void sprawdzNazwePojemnika() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(200, "ciastka");
		Assert.assertEquals("pojemnikNaciastka", pojemnik.podajNazwe());
		
		Assert.assertNotEquals("ciastka", pojemnik.podajNazwe());
	}
	
	@Test
	public void sprawdzDostepnaIloscPoZabraniuCzesci() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(200, "ciastka");
		pojemnik.wezOdpowiedniaIlosc(30);
		Assert.assertEquals(170, pojemnik.podajDostepnaIlosc(), 0);
		
		Assert.assertNotEquals(200, pojemnik.podajDostepnaIlosc(), 0);
	}
	
	@Test
	public void sprawdzZabezpieczeniePrzedPobraniemZaDuzejIlosci() {
		PojemnikSkladnikowSypkich pojemnik = new PojemnikSkladnikowSypkich(100, "ciastka");
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
