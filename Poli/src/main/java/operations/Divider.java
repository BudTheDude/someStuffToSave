package operations;

import struct.Poli.Poly;

public class Divider {
	private Poly a;
	private Poly b;
	
	private Poly c=new Poly();
	private Poly d=new Poly();
	
	public Divider(Poly a, Poly b) {
		this.a=a;
		this.b=b;
		
	}
	
	public void dividePoly() {
		
		
		while(b.getList().get(0).getDegree()<=a.getList().get(0).getDegree())
		{
			c.addElement( a.getList().get(0).getDegree()-b.getList().get(0).getDegree(),a.getList().get(0).getCoef()/b.getList().get(0).getCoef());
			Poly aux=new Poly();
			
			aux.getList().clear();
			aux.addElement(a.getList().get(0).getDegree()-b.getList().get(0).getDegree(),a.getList().get(0).getCoef()/b.getList().get(0).getCoef());
			
			d.getList().clear();
			b.getList().forEach((n)->d.addElement(n.getDegree(), n.getCoef()));
	
			c.correct();
			
			Multiplier m=new Multiplier(d,aux);
			m.multiplyPoly();
			
			d.correct();
			
			
			Subtracter s=new Subtracter(a,d);
			s.subPoly();
		
			a.correct();
			
			if(a.getList().size()==0) {
				break;
			}
		
		}

		
	}
	public Poly retcatf() {
		return c;
	}
	
	
	
}
