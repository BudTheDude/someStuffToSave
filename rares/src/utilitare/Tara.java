package utilitare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Tara {
	private String name;
	private ArrayList<Judet> listaJudete = new ArrayList<Judet>();
	
	private ArrayList<Localitate> localitatiOrdonate= new ArrayList<Localitate>();	
	public Tara(String name) {
		this.name = name;
	}
	
	public void addJudet(Judet judet) {
		listaJudete.add(judet);
	}
	
	public void printDupaJudet() {
		Collections.sort(listaJudete);
		
		Iterator i = listaJudete.iterator();
		
		while(i.hasNext()) {
			Judet jud=(Judet)i.next();
			
			for(int j=0;j<jud.getLocalitati().size();j++) {
				localitatiOrdonate.add(jud.getLocalitati().get(j));
				
				for(int k=0;k<jud.getLocalitati().get(j).getTerenuri().size();k++) {
					System.out.println("("+jud+") "+jud.getLocalitati().get(j).getTerenuri().get(k));
				}
			}
		}
	}
	
	public void printDupaLocalitate() {
		
		Collections.sort(localitatiOrdonate);
		Iterator i=localitatiOrdonate.iterator();
		
		while(i.hasNext()) {
			Localitate loc=(Localitate)i.next();
			for(int j=0;j<loc.getTerenuri().size();j++) {
				System.out.println("("+loc+") "+loc.getTerenuri().get(j));
			}
		}
	}
	
	
}
