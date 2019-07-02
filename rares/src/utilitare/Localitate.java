package utilitare;

import java.util.ArrayList;

public class Localitate implements Comparable<Localitate> {
	private String nume;
	private ArrayList<TerenAgricol> listaTerenuri= new ArrayList<TerenAgricol>();
	
	public Localitate(String nume) {
		this.nume=nume;
	}
	
	public void addTeren(TerenAgricol teren) {
		listaTerenuri.add(teren);
		}
	
	
	public String toString() {
		return nume;
	}
	
	public ArrayList<TerenAgricol> getTerenuri(){
		return listaTerenuri;
	}

	@Override
	public int compareTo(Localitate o) {
		
		return this.nume.compareTo(o.toString());
	}
}
