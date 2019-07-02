package operations;

import struct.Poli.Poly;

public class Multiplier {
	private Poly a;
	private Poly b;
	private Poly c =new Poly();
	private Poly d =new Poly();
	public Multiplier(Poly a, Poly b) {
		
		this.a=a;
		this.b=b;
		a.getList().forEach((n)->d.addElement(n.getDegree(), n.getCoef()));
	}
	
	public void multiplyPoly() {
			a.getList().clear();
			for(int i=0;i<b.getList().size();i++)
			{
				int j=i;
				d.getList().forEach((n)->c.addElement(n.getDegree(), n.getCoef()));

				c.getList().forEach((n)->n.setCoef(n.getCoef()*b.getList().get(j).getCoef()));
				c.getList().forEach((n)->n.setDegree(n.getDegree()+b.getList().get(j).getDegree()));
				
				c.getList().forEach((n)->a.addElement(n.getDegree(), n.getCoef()));
				
				c.getList().clear();
			}	
		
		
	}
	
}
