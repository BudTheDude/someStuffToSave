
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String placuta;
		System.out.println("\n Introduceti de la tastatura un numar: judet -spatiu-numar-spatiu-litere: ");
		placuta=scan.nextLine();
		
		Numar ob=new Numar(placuta);
		ob.afisare();

	}

}
