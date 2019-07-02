package mitza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class mitza {
	BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	
	
	public String read() {
		String str=new String();
		try {
			System.out.println("Introduce message+date:\n");
			str=buf.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public void printDate(String s) {
		String[] arrOfStr = s.split(" ", 0); 
		String mes;
		int day;
		String month;
		int year;
		
		mes=arrOfStr[0];
		day=Integer.parseInt(arrOfStr[1]);
		month=arrOfStr[2];
		year=Integer.parseInt(arrOfStr[3]);
		
		System.out.println(mes);
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		
	}
	public static void main(String[] args) {
		mitza m=new mitza();
		m.printDate(m.read());
		}
}
