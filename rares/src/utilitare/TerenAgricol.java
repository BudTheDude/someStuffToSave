package utilitare;

public class TerenAgricol {
	
	
	private Judet judet;
	private int suprafata;
	private String localitate;
	
	public TerenAgricol(Judet judet, int suprafata) {
		
		this.judet = judet;
		this.suprafata = suprafata;
		
	}
	
	public String toString() {
		return ("Lot cu suprafata: "+suprafata);
	}
	
	
}
