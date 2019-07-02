package testare;

import utilitare.Fermier;
import utilitare.Judet;
import utilitare.Localitate;
import utilitare.Tara;

public class Test {
	
	public static void main(String[] args) {
		Tara tara=new Tara("Romania");
		Judet maramu=new Judet("Maramures");
		Judet satu=new Judet("Satu Mare");
		
		tara.addJudet(maramu);
		tara.addJudet(satu);
		
		maramu.addLocalitate(new Localitate("Lapusel"));
		maramu.addLocalitate(new Localitate("Boiu Mare"));
		
		satu.addLocalitate(new Localitate("Ciuperceni"));
		satu.addLocalitate(new Localitate("Satuc"));
		
		Fermier fermier1=new Fermier("Bud","Bogdan");
		Fermier fermier2=new Fermier("Silaghi","Rares");
		
		fermier1.cumpara(maramu, 200);
		fermier1.cumpara(maramu,100);
		fermier2.cumpara(satu,150);
		fermier2.cumpara(maramu, 300);
		fermier2.cumpara(maramu, 50);
		
		System.out.println("Ordonare dupa judet:");
		tara.printDupaJudet();
		
		System.out.println("Ordonare dupa localitate:");
		tara.printDupaLocalitate();
	}
}
