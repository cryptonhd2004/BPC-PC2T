package cvi1;
import java.util.Scanner;

public class c1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadejte cislo k testovani: ");
	
		if(!sc.hasNextInt()) {
			System.out.println("Zadali jste spatne cislo!");
			sc.close();
			return;
		}
		
		int cislo = sc.nextInt();
		sc.close();
		int check = 0;
		
		for(int i = 2; i <= cislo; i++) {
			if(cislo%(i) == 0) {
				check++;
				if(check > 2) {
					System.out.println("Cislo NENI prvocislo");
					return; 
					
				}
			}
			
			
		}
		
		System.out.println("Cislo JE prvocislo");
		return;
		

	}

}
