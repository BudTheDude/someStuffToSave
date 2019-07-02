package operations;

import struct.Poli.Poly;

public class Derivator {
	private Poly a;
	
	public Derivator(Poly a) {
		this.a=a;
		
	}
	
	public void derivPoly() {
		a.getList().forEach((n)->n.setCoef(n.getCoef()*n.getDegree()));
		a.getList().forEach((n)->n.setDegree(n.getDegree()-1));
	}
	
	
}
