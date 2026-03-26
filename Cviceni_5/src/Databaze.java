import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=Test.pouzeCelaCisla(sc);
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer) throws PrumerException 
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	public void vypisStudentu()
	{
		for (int i=0;i<prvkyDatabaze.length;i++)
		{
			if (prvkyDatabaze[i]==null)
				break;
			System.out.print("Jmeno: "+prvkyDatabaze[i].getJmeno());
			System.out.print("\trok narozeni: "+prvkyDatabaze[i].getRocnik());
			try {
				System.out.println("\tstudijni prumer: "+prvkyDatabaze[i].getStudijniPrumer());
			} catch (PrumerException e) {
				System.out.println("\tstudijni prumer: nezadan");
			}
		}
	}
	
	public boolean zapisDoSouboru(String jmenoSouboru)
	{
		try (FileWriter fw=new FileWriter(jmenoSouboru);
			BufferedWriter bw=new BufferedWriter(fw))
		{
			
			bw.write("Pocet: "+prvkyDatabaze.length);
			bw.newLine();
			for (int i=0;i<prvkyDatabaze.length;i++)
			{
				if (prvkyDatabaze[i]==null)
					break;
				bw.write("Jmeno: "+prvkyDatabaze[i].getJmeno());
				bw.write(" rok narozeni: "+prvkyDatabaze[i].getRocnik());
				try {
					bw.write(" studijni prumer: "+prvkyDatabaze[i].getStudijniPrumer());
				} catch (PrumerException e) {
					bw.write(" studijni prumer: nezadan");
				}
				bw.newLine();
			}
			
		} 
		catch (IOException e) {
			System.out.println("Nepodarilo se otevrit soubor");
			return false;
		}
		
		
		return true;
	}
	
	public boolean nacteniZeSoubru(String jmenoSoboru)
	{
		try (FileReader fr = new FileReader(jmenoSoboru);
			BufferedReader br=new BufferedReader(fr);
			Scanner sc=new Scanner(br))
		{
			sc.useLocale(Locale.US);
			String text=sc.next();
			if (text.compareTo("Pocet:")!=0||!sc.hasNextInt())
			{
				System.out.println("Chybny format dat");
				return false;
			}
			prvkyDatabaze=new Student[sc.nextInt()];
			posledniStudent=0;
			while(sc.hasNext()&&sc.next().compareTo("Jmeno:")==0)
			{
				String jmeno=sc.next();
				sc.next();
				sc.next();
				if (!sc.hasNextInt())
				{
					System.out.println("Chybny format dat pro studenta "+jmeno);
					sc.nextLine();
					continue;
				}
				int rok=sc.nextInt();
				prvkyDatabaze[posledniStudent]=new Student(jmeno,rok);
				sc.next();
				sc.next();
				try
				{
					if (sc.hasNextFloat())
						prvkyDatabaze[posledniStudent].setStudijniPrumer(sc.nextFloat());
					else
						sc.next();
				}
				catch (PrumerException e)
				{
				}
				posledniStudent++;
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Soubor nelze otervit");
			return false;
		} 
		catch (IOException e1) {
			System.out.println("Soubor nelze otervit");
			return false;
		}
		
		
		return true;
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}