package TestyJednostkowe.Expres;

import org.junit.Assert;

import org.junit.Test;

import Expres.Przepis;
import Expres.SkladnikCiekly;
import Expres.SkladnikSypki;

public class TPrzepis {
	
	@Test
	public void sprawdzTworzeniaPrzepisu() {
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		Assert.assertNotNull(przepis);
	}

	@Test
	public void sprawdzDodawanieDodatkow() {
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		Assert.assertEquals(true, przepis.podajListeDodatkow().isEmpty());
		
		Assert.assertNotEquals(false, przepis.podajListeDodatkow().isEmpty());
		
		SkladnikCiekly skladnikDodatkowy = new SkladnikCiekly("CieczNowa", 1, 2, 3);
		przepis.dodajDoPrzepisu(skladnikDodatkowy);
		
		Assert.assertEquals(false, przepis.podajListeDodatkow().isEmpty());
		
		Assert.assertNotEquals(true, przepis.podajListeDodatkow().isEmpty());
		
		SkladnikSypki skladnikDodatkowyKolejny = new SkladnikSypki("Proszek", 1, 2, 3);
		przepis.dodajDoPrzepisu(skladnikDodatkowyKolejny);
		
		Assert.assertEquals(2, przepis.podajListeDodatkow().size());
		
		Assert.assertNotEquals(4, przepis.podajListeDodatkow().size());
	}
	
	@Test
	public void sprawdzNazweGlownegoSkladnika() {
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Mleko", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		Assert.assertEquals("Mleko", przepis.podajSkladnikGlowny().podajNazwe());
		
		Assert.assertNotEquals("Cukier", przepis.podajSkladnikGlowny().podajNazwe());
	}

	@Test
	public void sprawdzInformacjeDodatkow() {
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		
		SkladnikCiekly skladnikDodatkowy = new SkladnikCiekly("CieczNowa", 1, 2, 3);
		przepis.dodajDoPrzepisu(skladnikDodatkowy);
		
		Assert.assertEquals("CieczNowa", przepis.podajListeDodatkow().get(0).podajNazwe());
		Assert.assertEquals(3, przepis.podajListeDodatkow().get(0).podajWymaganaIlosc(), 0);
		Assert.assertEquals(1, przepis.podajListeDodatkow().get(0).podajWymaganaTemperatura(), 0);
		Assert.assertEquals(2, przepis.podajListeDodatkow().get(0).wymogSkladnika(), 0);
		
		Assert.assertNotEquals("Ciecz", przepis.podajListeDodatkow().get(0).podajNazwe());
		Assert.assertNotEquals(1, przepis.podajListeDodatkow().get(0).podajWymaganaIlosc(), 0);
		Assert.assertNotEquals(5, przepis.podajListeDodatkow().get(0).podajWymaganaTemperatura(), 0);
		Assert.assertNotEquals(7, przepis.podajListeDodatkow().get(0).wymogSkladnika(), 0);
		
		SkladnikSypki skladnikDodatkowyKolejny = new SkladnikSypki("Proszek", 10, 22, 5);
		przepis.dodajDoPrzepisu(skladnikDodatkowyKolejny);
		
		Assert.assertEquals("Proszek", przepis.podajListeDodatkow().get(1).podajNazwe());
		Assert.assertEquals(5, przepis.podajListeDodatkow().get(1).podajWymaganaIlosc(), 0);
		Assert.assertEquals(10, przepis.podajListeDodatkow().get(1).podajWymaganaTemperatura(), 0);
		Assert.assertEquals(22, przepis.podajListeDodatkow().get(1).wymogSkladnika(), 0);
		
		Assert.assertNotEquals("Ciecz", przepis.podajListeDodatkow().get(0).podajNazwe());
		Assert.assertNotEquals(1, przepis.podajListeDodatkow().get(0).podajWymaganaIlosc(), 0);
		Assert.assertNotEquals(5, przepis.podajListeDodatkow().get(0).podajWymaganaTemperatura(), 0);
		Assert.assertNotEquals(7, przepis.podajListeDodatkow().get(0).wymogSkladnika(), 0);
	}
}
