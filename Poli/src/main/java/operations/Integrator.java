package operations;

import struct.Poli.Poly;

public class Integrator {
	
	private Poly a;
		
	public Integrator(Poly a) {
		this.a=a;
	}
	
	public void integPoly() {
		a.getList().forEach((n)->n.setCoef(n.getCoef()/(n.getDegree()+1)));
		a.getList().forEach((n)->n.setDegree(n.getDegree()+1));
	}
	

}
