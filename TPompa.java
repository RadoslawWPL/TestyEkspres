package TestyJednostkowe.Expres;


import org.junit.Assert;
import org.junit.Test;

import Expres.Glowica;
import Expres.Pompa;

public class TPompa {

	@Test
	public void sprawdzInicjowaniePompy() {
		Glowica glowica = new Glowica();
		Pompa pompa = new Pompa(glowica);
		Assert.assertNotNull(pompa);
	}

	@Test
	public void sprawdzNazwe() {
		Glowica glowica = new Glowica();
		Pompa pompa = new Pompa(glowica);
		Assert.assertEquals("Pompa", pompa.podajNazwe());
		
		Assert.assertNotEquals("Glowica", pompa.podajNazwe());
	}
}