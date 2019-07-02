package operations;
import struct.Poli.Poly;
public class Adder {
	private Poly a;
	private Poly b;
	
	public Adder(Poly a, Poly b) {
		this.a=a;
		this.b=b;
	}
	
	public void addPoly() {
		b.getList().forEach((n)->a.getList().add(n));
	}
	
	
}
