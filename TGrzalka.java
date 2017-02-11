package TestyJednostkowe.Expres;

import org.junit.Assert;

import org.junit.Test;
import Expres.Grzalka;
import Expres.SkladnikCiekly;

public class TGrzalka {

	@Test
	public void sprawdzInicjowanieGrzalki() {
		Grzalka grzalka = new Grzalka();
		Assert.assertNotNull(grzalka);
	}
	
	@Test
	public void sprawdzNazwe() {
		Grzalka grzalka = new Grzalka();
		Assert.assertEquals("Grzalka", grzalka.podajNazwe());
		
		Assert.assertNotEquals("Mlynek", grzalka.podajNazwe());
	}
	
	@Test
	public void sprawdzTemperaturePokojowa() {
		Grzalka grzalka = new Grzalka();
		Assert.assertEquals(21.1f, grzalka.podajTemperature(), 0);
		
		Assert.assertNotEquals(23.1f, grzalka.podajTemperature(), 0);
	}

	@Test
	public void sprawdzTemperaturePoPodgrzaniuISchlodzeniu() {
		Grzalka grzalka = new Grzalka();
		SkladnikCiekly skladnikDoPodrzania = new SkladnikCiekly("Ciecz", 18, 2, 3);
		grzalka.podgrzejDoWymaganejTemperatury(skladnikDoPodrzania);
		Assert.assertEquals(21.1f, grzalka.podajTemperature(), 0);
		
		Assert.assertNotEquals(23.1f, grzalka.podajTemperature(), 0);
	}
}
