
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numar {
	private String placuta="";
		public String getPlacuta() {
		return placuta;
	}
	public void setPlacuta(String placuta) {
		this.placuta = placuta;
	}
		Numar(String placuta)
		{
			this.placuta=placuta;
			try 
			{
				if(!verificare(placuta))
				{
					throw new Exceptie();
				}
				
			}catch(Exceptie e)
			{
				e.printStackTrace();
				
			}
			
		}
	boolean verificare( String nr)
	{
		Pattern nrBucuresti=Pattern.compile("[B]{1}\\s[0-9]{2,3}\\s[A-Z]{3}");
		Pattern nrGeneral=Pattern.compile("[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{3}");
		//folosit un pattern care are tipul de numere
		Matcher verif1=nrBucuresti.matcher(nr);
		Matcher verif2=nrGeneral.matcher(nr);
		boolean ok1=verif1.matches();
		boolean ok2=verif2.matches();
		if(ok1)
		{
			this.placuta=nr;
			System.out.println("\n Numar de Bururesti: "+nr);
			return ok1;
		}	
		else if(ok2)
		{
			this.placuta=nr;
			System.out.println("\n Numarul este de romania: "+nr);
			return ok2;
		}
		
		else
			return false;
		
	}
	public void afisare()
	{
		System.out.println("\n Numarul este: "+placuta);
	}

}
