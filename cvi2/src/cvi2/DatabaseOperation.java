package cvi2;

import java.util.Scanner;
public class DatabaseOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Databaze[] databaze = new Databaze[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Zadejte jméno osoby " + (i + 1) + ": ");
            String jmeno = scanner.nextLine();
            System.out.print("Zadejte rok narození osoby " + (i + 1) + ": ");
            int rok = Integer.parseInt(scanner.nextLine());
            databaze[i] = new Databaze(jmeno, rok);
        }
        
        System.out.print("Zadejte maximální povolenou výši úvazku: ");
        double maxUvazek = Double.parseDouble(scanner.nextLine());
        Databaze.setMaxUvazek(maxUvazek);
        
        while (true) {
            System.out.print("Zadejte index osoby (0-2) nebo 'q' pro ukončení: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            
            try {
                int index = Integer.parseInt(input);
                if (index < 0 || index > 2) {
                    System.out.println("Neplatný index! Použijte 0, 1 nebo 2.");
                    continue;
                }
                
                System.out.print("Zadejte výši nového úvazku: ");
                double novyUvazek = Double.parseDouble(scanner.nextLine());
                
                System.out.println("Osoba: " + databaze[index].getJmeno() + 
                                 ", rok narození: " + databaze[index].getRokNarozeni());
                
                if (databaze[index].pridejUvazek(novyUvazek)) {
                    System.out.println("Nový úvazek: " + databaze[index].getUvazek());
                } else {
                    System.out.println("Dosažen maximální úvazek! Aktuální: " + 
                                     databaze[index].getUvazek() + 
                                     " (max: " + Databaze.getMaxUvazek() + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup! Zadejte číslo.");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
