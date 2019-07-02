package mihai;

import java.awt.Desktop;
import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;





public class Texte {
	File fisier=new File("/home/bud/workspace3/mihai/grupe");
	File[] lista=fisier.listFiles();
	
	
	public SequenceInputStream returnStream() {
		FileInputStream[] f=new FileInputStream[lista.length];
		try {
			for(int i=0;i<lista.length;i++) {
			f[i]=new FileInputStream(lista[i].getAbsolutePath());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vector<InputStream> inputStreams = new Vector<InputStream>();
		for(int i=0;i<f.length;i++) {
			inputStreams.add(f[i]);
		}
		Enumeration<InputStream> enu = inputStreams.elements();
		SequenceInputStream s= new SequenceInputStream(enu);
		return s;
	}
	
	public void print(SequenceInputStream s) {
		  int j;
		  ArrayList<String> names=new ArrayList<String>();
		   try {
			
			   while((j=s.read())!=-1){  
				   String str="";
				   while((char)j!='\n' && j!=3) {
					   str=str+(char)j;
					   j=s.read();
				   }
				   names.add(str);
			    
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		  Collections.sort(names);
		  try {
			
			PrintWriter writer = new PrintWriter("/home/bud/workspace3/mihai/studenti.txt", "UTF-8");
			names.forEach((n)->writer.println(n));
			writer.close();
			File file=new File("/home/bud/workspace3/mihai/studenti.txt");
			Desktop.getDesktop().open(file);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  
	}
	
	public static void main(String[] args) {
		
		Texte t=new Texte();
		t.print(t.returnStream());
		
	}
}
