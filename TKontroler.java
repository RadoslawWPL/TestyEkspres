package TestyJednostkowe.Expres;


import org.junit.Assert;
import org.junit.Test;

import Expres.Grzalka;
import Expres.Kontroler;


public class TKontroler {

	@Test
	public void sprawdzInicjowanieKontrolera() {
		Kontroler kontroler = new Kontroler();
		Assert.assertNotNull(kontroler);
	}
	
	@Test
	public void sprawdzPojemnoscKubka() {
		Kontroler kontroler = new Kontroler();
		Assert.assertEquals(100, kontroler.pobierzPojemnoscKubka(), 0);
		
		Assert.assertNotEquals(200, kontroler.pobierzPojemnoscKubka(), 0);
	}
	
	@Test
	public void sprawdzCzyListaJestPusta() {
		Kontroler kontroler = new Kontroler();
		Assert.assertEquals(0, kontroler.dajListeKomponentow().size(), 0);
		
		Assert.assertNotEquals(3, kontroler.dajListeKomponentow().size(), 0);
	}
	
	@Test
	public void sprawdzDodawanieKomponentow() {
		Kontroler kontroler = new Kontroler();
		Grzalka grzalka = new Grzalka();
		kontroler.dodajKomponent(grzalka);
		Assert.assertEquals(1, kontroler.dajListeKomponentow().size(), 0);	
		
		Assert.assertNotEquals(0, kontroler.dajListeKomponentow().size(), 0);	
	}
	
	@Test
	public void sprawdzUsuwanieKomponentow() {
		Kontroler kontroler = new Kontroler();
		Grzalka grzalka = new Grzalka();
		kontroler.dodajKomponent(grzalka);
		kontroler.usunKomponent(grzalka.podajNazwe());
		Assert.assertEquals(0, kontroler.dajListeKomponentow().size(), 0);	
		
		Assert.assertNotEquals(1, kontroler.dajListeKomponentow().size(), 0);	
	}	
}
