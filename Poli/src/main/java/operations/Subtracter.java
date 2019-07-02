package operations;

import struct.Poli.Poly;

public class Subtracter {
	private Poly a;
	private Poly b;
	
	public Subtracter(Poly a, Poly b) {
		this.a=a;
		this.b=b;
		
	}

	public void subPoly() {
		b.getList().forEach((n)->n.setCoef(-n.getCoef()));
		b.getList().forEach((n)->a.getList().add(n));
	}
	
	
	 
}	
