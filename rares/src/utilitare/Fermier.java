package utilitare;

import java.util.ArrayList;
import java.util.Scanner;

public class Fermier {
	private String nume;
	private String prenume;
	private ArrayList<TerenAgricol> listaTerenuri = new ArrayList<TerenAgricol>();
	
	public Fermier(String nume, String prenume) {
		
		this.nume = nume;
		this.prenume = prenume;
	}
	
	public void cumpara(Judet judet,int suprafata) {
		TerenAgricol teren= new TerenAgricol(judet,suprafata);
		int i;
		System.out.println("Selectati localitate:");
		Scanner scan = new Scanner(System.in);
		
		for(int j=0;j<judet.getLocalitati().size();j++) {
			System.out.println(j+"."+judet.getLocalitati().get(j));
		}
		i=scan.nextInt();
		
		judet.getLocalitati().get(i).addTeren(teren);
		
		listaTerenuri.add(teren);
	}
	
	
}
