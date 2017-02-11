package TestyJednostkowe.Expres;

import org.junit.Assert;
import org.junit.Test;

import Expres.ObslugaKomponentow;
import Expres.Przepis;
import Expres.SkladnikCiekly;
import Expres.SkladnikSypki;

public class TObslugaKomponentow {
	
	@Test
	public void sprawdzInicjowanieObslugiKomponentow() {
		ObslugaKomponentow obsluga = new ObslugaKomponentow();
		Assert.assertNotNull(obsluga);
	}
	
	@Test
	public void sprawdzInicjalizowanieKomponentow() {
		ObslugaKomponentow obsluga = new ObslugaKomponentow();
		
		Assert.assertEquals(true, obsluga.podajPojemniki().isEmpty());
		
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		obsluga.ustawZadanie(przepis);
		obsluga.zainicjalizujKomponenty();	
		Assert.assertEquals(false, obsluga.podajPojemniki().isEmpty());
		
		Assert.assertNotEquals(true, obsluga.podajPojemniki().isEmpty());
	}
	
	@Test
	public void sprawdzUstawianiePojemnosci() {
		ObslugaKomponentow obsluga = new ObslugaKomponentow();
		
		Assert.assertEquals(true, obsluga.podajPojemniki().isEmpty());
	
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		obsluga.ustawZadanie(przepis);
		obsluga.ustawPojemnoscPojemnikow(100);
		obsluga.zainicjalizujKomponenty();
		for(int pojemnosc = 100; pojemnosc<1000; pojemnosc++)
		{		
			obsluga.podajPojemniki().get(0).ustawIlosc(pojemnosc);
			Assert.assertEquals(pojemnosc, obsluga.podajPojemniki().get(0).podajDostepnaIlosc(), 0);
			
			Assert.assertNotEquals(pojemnosc*2, obsluga.podajPojemniki().get(0).podajDostepnaIlosc(), 0);
		}
	}	
	
	@Test
	public void sprawdzCzyNieDublujaSiePojemniki() {
		ObslugaKomponentow obsluga = new ObslugaKomponentow();
		
		Assert.assertEquals(true, obsluga.podajPojemniki().isEmpty());
		
		SkladnikCiekly skladnikGlowny = new SkladnikCiekly("Ciecz", 1, 2, 3);
		Przepis przepis = new Przepis(skladnikGlowny);
		for(int i=0; i<100; i++)
		{
			obsluga.ustawZadanie(przepis);
			obsluga.ustawPojemnoscPojemnikow(100);
			obsluga.zainicjalizujKomponenty();
			Assert.assertEquals(1, obsluga.podajPojemniki().size(), 0);
			
			Assert.assertNotEquals(0, obsluga.podajPojemniki().size(), 0);
		}
		for(int iterator=0; iterator<100; iterator++)
		{
			SkladnikCiekly skladnikGlownyNowy = new SkladnikCiekly("NowaCiecz" + iterator, 10, 2, 3);
			przepis = new Przepis(skladnikGlownyNowy);
			obsluga.ustawZadanie(przepis);
			obsluga.ustawPojemnoscPojemnikow(100);
			obsluga.zainicjalizujKomponenty();
			Assert.assertEquals(2+iterator, obsluga.podajPojemniki().size(), 0);
			
			Assert.assertNotEquals(iterator, obsluga.podajPojemniki().size(), 0);
		}	
		
		for(int iterator=0; iterator<100; iterator++)
		{
			SkladnikSypki skladnikDodatkowy = new SkladnikSypki("Proszek" + iterator, 10, 2, 3);
			przepis.dodajDoPrzepisu(skladnikDodatkowy);
			obsluga.ustawZadanie(przepis);
			obsluga.ustawPojemnoscPojemnikow(100);
			obsluga.zainicjalizujKomponenty();
			Assert.assertEquals(102+iterator, obsluga.podajPojemniki().size(), 0);
			
			Assert.assertNotEquals(iterator, obsluga.podajPojemniki().size(), 0);
		}
	}	
}
