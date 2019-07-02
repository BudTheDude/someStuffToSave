package mihai;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JLabel;

public class Test extends Frame implements WindowListener{
JLabel text1;

BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
String name;
String group;

	Test(String titlu)
	{
		setLayout( new BorderLayout() );
		try {
			name=buf.readLine();
			group=buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.addWindowListener(this);
		setLayout(new FlowLayout());//creare eticheta centrata in care putem scrie
		text1=new JLabel("Salut "+name+" ,grupa ta este "+group);
		text1.setForeground(Color.blue);
		text1.setHorizontalAlignment(JLabel.CENTER);
		text1.setVerticalAlignment(JLabel.CENTER);
		add(text1, BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);//facem fereastra vizibila
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(1);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Test ob=new Test("Mihai Bolchis");

	}


}
