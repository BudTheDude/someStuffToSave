package struct.Poli;


import org.junit.Assert;
import org.junit.Test;

import operations.Adder;
import operations.Subtracter;
import operations.Multiplier;
import operations.Divider;
import operations.Derivator;
import operations.Integrator;
public class TestOperation {
	
	
	
	


	
	@Test
	
	public void adunare()
	{
		Poly secondPolinom=new Poly();
		Poly firstPolinom=new Poly();
		firstPolinom.addElement(1,1);
		secondPolinom.addElement(1,1);
		Adder a=new Adder(firstPolinom,secondPolinom);
		a.addPoly();
		Assert.assertTrue(firstPolinom.printPoly().equals("   2.0X^1"));
	}
	@Test
	public void scadere()
	{
		Poly secondPolinom=new Poly();
		Poly firstPolinom=new Poly();
		firstPolinom.addElement(5,1);
		secondPolinom.addElement(1,1);
		Subtracter s=new Subtracter(firstPolinom,secondPolinom);
		s.subPoly();
		Assert.assertTrue(firstPolinom.printPoly().equals("   1.0X^5   -1.0X^1"));
		
	}
	
	@Test 
	public void inmultire()
	{	
		Poly secondPolinom=new Poly();
		Poly firstPolinom=new Poly();
		firstPolinom.addElement(5,1);
		secondPolinom.addElement(1,1);
		secondPolinom.addElement(2, 2);
		Multiplier m=new Multiplier(firstPolinom,secondPolinom);
		m.multiplyPoly();
		Assert.assertTrue(firstPolinom.printPoly().equals("   2.0X^7   1.0X^6"));
	}
	
	@Test
	public void impartire()
	{
		Poly secondPolinom=new Poly();
		Poly firstPolinom=new Poly();
		firstPolinom.addElement(2,1);
		firstPolinom.addElement(0, -1);
		secondPolinom.addElement(1,1);
		secondPolinom.addElement(0, 1);
		Divider m=new Divider(firstPolinom,secondPolinom);
		m.dividePoly();
		Assert.assertTrue(firstPolinom.printPoly().equals(""));
		Assert.assertTrue(m.retcatf().printPoly().equals("   1.0X^1   -1.0X^0"));
	}
	
	@Test
	public void derivare()
	{

		Poly firstPolinom=new Poly();
		firstPolinom.addElement(2,1);
		Derivator de=new Derivator(firstPolinom);
		de.derivPoly();
	
		Assert.assertTrue(firstPolinom.printPoly().equals("   2.0X^1"));
		
	}
	
	
	@Test
	public void intergrare()
	{
		Poly firstPolinom=new Poly();
		firstPolinom.addElement(4,5);
		Integrator de=new Integrator(firstPolinom);
		de.integPoly();
	
		Assert.assertTrue(firstPolinom.printPoly().equals("   1.0X^5"));
	}
	
	
	
}
