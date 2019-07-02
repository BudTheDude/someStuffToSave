package utilitare;

import java.util.ArrayList;

public class Judet implements Comparable<Judet> {
	private String name;
	private ArrayList<Localitate> listaLocalitati = new ArrayList<Localitate>();
	
	public Judet(String name) {
		this.name = name;
	}
	
	public ArrayList<Localitate> getLocalitati(){
		return listaLocalitati;
	}
	
	public void addLocalitate(Localitate nume) {
		listaLocalitati.add(nume);
	}

	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Judet compi) {
		
		return this.name.compareTo(compi.getName());
	}
	
	public String toString() {
		return name;
	}
	
	
}
