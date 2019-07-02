package mitaColocviu;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int id;
		double media;
		String nume;
		System.out.println("\n Introduceti numarul de obiecte: ");
		
		int n = scan.nextInt();
		scan.nextLine();
		Student[] st = new Student[n];
		
		for (int i = 0; i < n; i++) {
			st[i] = new Student();
		}
		
		try (BufferedWriter buff=new BufferedWriter(new FileWriter("studenti.txt"));){
			FileOutputStream fout=new FileOutputStream("studenti.txt");
			
			
			
			for(int i=0;i<n;i++)
			{
				buff.append("User" + (i + 1));
				StringBuilder sb = new StringBuilder();
				System.out.println("\n Nume:");
				nume=scan.nextLine();
				st[i].setNume(nume);
				System.out.println("\n Id:");
				id=scan.nextInt();
				scan.nextLine();
				st[i].setId(id);
				System.out.println("\n Media: ");
				media=scan.nextDouble();
				scan.nextLine();
				st[i].setMedia(media);
				sb.append(st[i].getNume() + " ");
				sb.append(st[i].getId() + " ");
				sb.append(st[i].getMedia() + " ");
				
				String[] aux = sb.toString().split("\\s");
				
				for(String s : aux)
				{
					buff.write(s);
					buff.newLine();
				}
				
				
				buff.newLine();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sortam array. am pus un buble sort simplu
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++) {
				if(st[j-1].getId()>st[j].getId()) {
					Student temp=st[j-1];
					st[j-1]=st[j];
					st[j]=temp;
				}
			}
			
		}
		
		//am bagat aici niste valori sa vad ca merge. le citesti tu de la tastatura daca vrei. sau de unde vrei tu
		List<Student> listaStudenti=new ArrayList<Student>();
		listaStudenti.add(new Student("Gheorghe",1,4.5));
		listaStudenti.add(new Student("Adin",4,7.5));
		listaStudenti.add(new Student("Mihai",2,5.7));
		listaStudenti.add(new Student("Cacat",9,6.7));
		listaStudenti.add(new Student("Gheorghe2",10,10));
		
		for(int i=0;i<n;i++)
		{
			System.out.println(st[i]);
		}
		
		Collections.sort(listaStudenti,Student.CompareByID);
		System.out.println("Lista sortata dupa ID:");
		for(Student s:listaStudenti) {
			System.out.println(s);
		}
		
		Collections.sort(listaStudenti,Student.CompareByName);
		System.out.println("Lista sortata dupa nume:");
		for(Student s:listaStudenti) {
			System.out.println(s);
		}
		
		Collections.sort(listaStudenti,Student.CompareByMedie);
		System.out.println("Lista sortata dupa medie:");
		for(Student s:listaStudenti) {
			System.out.println(s);
		}
		
	}

}
