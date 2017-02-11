package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.Glowica;
import Expres.Mlynek;

public class TMlynek {
	
	@Test
	public void sprawdzInicjowanieMlynka() {
		Glowica glowica = new Glowica();
		Mlynek mlynek = new Mlynek(glowica);
		Assert.assertNotNull(mlynek);
	}

	@Test
	public void sprawdzNazwe() {
		Glowica glowica = new Glowica();
		Mlynek mlynek = new Mlynek(glowica);
		Assert.assertEquals("Mlynek", mlynek.podajNazwe());
		
		Assert.assertNotEquals("Grzalka", mlynek.podajNazwe());
	}
}