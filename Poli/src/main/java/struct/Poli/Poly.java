package struct.Poli;


import java.util.ArrayList;
import java.util.Collections;


public class Poly {
	private ArrayList<Monom> p=new ArrayList<Monom>();
	int maxDegree;
	String s=new String();
	public Poly() {
		this.maxDegree=0;
	}
	
	public void addElement(int d, float c) {
		Monom m=new Monom(d,c);
		p.add(m);
	}
	
	public void correct() {
		Collections.sort(p);
		
		for(int i=0;i<p.size();i++) {
			for(int j=i+1;j<p.size();j++) {
				if(p.get(j).getDegree()==p.get(i).getDegree()) {
					p.get(i).setCoef(p.get(i).getCoef()+p.get(j).getCoef());
					p.get(j).setCoef(0);
				}
			}
		}
		ArrayList<Monom> q=new ArrayList<Monom>();
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getCoef()==0.0)
				q.add(p.get(i));
		}
		
		p.removeAll(q);
		
		}
	
	
	public String printPoly() {
		correct();
		s="";
		p.forEach((n)->s=s+"   "+n.getCoef()+"X^"+n.getDegree());
		return s;
	}
	
	public ArrayList<Monom> getList(){
		return p;
	}
	
	
}
