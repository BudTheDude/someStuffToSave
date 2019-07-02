package interfata;

import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;



import operations.*;
import struct.Poli.Poly;



public class Top extends JFrame  {
	
	Poly a=new Poly();
	Poly b=new Poly();
	
	JPanel p=new JPanel();
	JPanel q=new JPanel();
	
	JLabel pol1=new JLabel("Polyonmial1:");
	JTextField getpol1= new JTextField(50);
	JButton savepol1= new JButton("Save Polynomial1");
	
	JLabel pol2=new JLabel("Polyonmial2:");
	JTextField getpol2= new JTextField(50);
	JButton savepol2= new JButton("Save Polynomial2");
	
	JButton der=new JButton("Derivate");
	JButton integ=new JButton("Integrate");
	JButton add=new JButton("Add");
	JButton sub=new JButton("Subtract");
	JButton div=new JButton("Divide");
	JButton mul=new JButton("Multiply");
	
	JLabel res=new JLabel("RESULT:");
	JTextField result=new JTextField();
	
	JButton neww=new JButton("New Operation");

	public static void main(String[] args) {
		new Top();
	}
	
	public Top() {
		
		Handler h=new Handler();
		
		this.setSize(600, 300);
		this.setVisible(true);
		this.setResizable(true);
		q.setLayout(new BoxLayout(q, BoxLayout.X_AXIS));
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		result.setEditable(false);
		
		p.add(pol1);
		
		p.add(getpol1);
		p.add(savepol1);
		p.add(pol2);
		p.add(getpol2);
		p.add(savepol2);
		
		q.add(der);
		q.add(integ);
		q.add(add);
		q.add(sub);
		q.add(div);
		q.add(mul);
		p.add(q);
		p.add(res);
		p.add(result);
		p.add(neww);
		
		neww.setAlignmentX(Component.CENTER_ALIGNMENT);
		res.setAlignmentX(Component.CENTER_ALIGNMENT);
		pol1.setAlignmentX(Component.CENTER_ALIGNMENT);
		pol2.setAlignmentX(Component.CENTER_ALIGNMENT);
		savepol1.setAlignmentX(Component.CENTER_ALIGNMENT);
		savepol2.setAlignmentX(Component.CENTER_ALIGNMENT);
		q.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		savepol1.addActionListener(h);
		savepol2.addActionListener(h);
		neww.addActionListener(h);
		add.addActionListener(h);
		sub.addActionListener(h);
		der.addActionListener(h);
		integ.addActionListener(h);
		mul.addActionListener(h);
		div.addActionListener(h);
		this.add(p);
		
		
	}
	
	public void displayPopupMessage(final String message) {
		JOptionPane.showMessageDialog(null, message, "Popup message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private class Handler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==savepol1) {
				try {
				a.getList().clear();
		        String str = getpol1.getText(); 
		        str=str.replace("-", "+-");
		        String[] arrOfStr = str.split("\\+", 0); 
		  
		        for (String t : arrOfStr) {
		        	if(t.length()>2) {
		            String[] nrs=t.split("x\\^",0);
		        	
		            float f=Float.parseFloat(nrs[0]);
		        	
		            int i=Integer.parseInt(nrs[1]);
		        	
		            a.addElement(i, f);
		            
		        	}
		        }
		        
				getpol1.setEnabled(false);
				savepol1.setEnabled(false);
				}catch(NumberFormatException | ArrayIndexOutOfBoundsException a) {
					displayPopupMessage("Invalid Input");
				}
			}
			if(e.getSource()==savepol2) {
				try {
				b.getList().clear();
				String str = getpol2.getText(); 
		        str=str.replace("-", "+-");
		        String[] arrOfStr = str.split("\\+", 0); 
		        
		        for (String t : arrOfStr) {
		        	if(t.length()>2) {
		            String[] nrs=t.split("x\\^",0);
		        	
		            float f=Float.parseFloat(nrs[0]);
		        	
		            int i=Integer.parseInt(nrs[1]);
		        	
		            b.addElement(i, f);
		            
		        	}
		        }
		    
		        
		        
				getpol2.setEnabled(false);
				savepol2.setEnabled(false);
				}catch(NumberFormatException | ArrayIndexOutOfBoundsException a) {
					displayPopupMessage("Invalid Input");
				}
			}
			if(e.getSource()==add) {
				sub.setEnabled(false);
				der.setEnabled(false);
				integ.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				add.setEnabled(false);
				Adder add=new Adder(a,b);
				add.addPoly();
				result.setText(a.printPoly());
			}
			if(e.getSource()==sub) {
				sub.setEnabled(false);
				der.setEnabled(false);
				integ.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				add.setEnabled(false);
				Subtracter subi=new Subtracter(a,b);
				subi.subPoly();
				result.setText(a.printPoly());
			}
			if(e.getSource()==der) {
				sub.setEnabled(false);
				der.setEnabled(false);
				integ.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				add.setEnabled(false);
				Derivator deri=new Derivator(a);
				deri.derivPoly();
				result.setText(a.printPoly());
			}
			if(e.getSource()==integ) {
				sub.setEnabled(false);
				der.setEnabled(false);
				integ.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				add.setEnabled(false);
				Integrator inti=new Integrator(a);
				inti.integPoly();
				result.setText(a.printPoly());
			}
			if(e.getSource()==mul) {
				sub.setEnabled(false);
				der.setEnabled(false);
				integ.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				add.setEnabled(false);
				Multiplier multi=new Multiplier(a,b);
				multi.multiplyPoly();
				result.setText(a.printPoly());
			}
			if(e.getSource()==div) {
				sub.setEnabled(false);
				der.setEnabled(false);
				integ.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				add.setEnabled(false);
				try{Divider divi=new Divider(a,b);
				divi.dividePoly();
				result.setText("C:"+divi.retcatf().printPoly()+"  R:"+a.printPoly());}
				catch(IndexOutOfBoundsException a) { 
					displayPopupMessage("Division by 0 not allowed!");
		        } 
			}
			if(e.getSource()==neww) {
				sub.setEnabled(true);
				der.setEnabled(true);
				integ.setEnabled(true);
				mul.setEnabled(true);
				div.setEnabled(true);
				add.setEnabled(true);
				getpol1.setEnabled(true);
				savepol1.setEnabled(true);
				getpol2.setEnabled(true);
				savepol2.setEnabled(true);
				getpol1.setText("");
				getpol2.setText("");
				result.setText(null);
			}
		
		}
		
	}
}
