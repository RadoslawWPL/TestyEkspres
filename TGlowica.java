package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.Glowica;

public class TGlowica {

	@Test
	public void sprawdzInicjowanieGlowicy() {
		Glowica glowica = new Glowica();
		Assert.assertNotNull(glowica);
	}

	@Test
	public void sprawdzNazwe() {
		Glowica glowica = new Glowica();
		Assert.assertEquals("Glowica", glowica.podajNazwe());
		
		Assert.assertNotEquals("Mlynek", glowica.podajNazwe());
	}
}
