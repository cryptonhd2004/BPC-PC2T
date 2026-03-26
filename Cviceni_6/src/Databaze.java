import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Databaze {

    private Map<String, Student> studenti;
    private Scanner sc;

    public Databaze() {
        studenti = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void setStudent() {
        System.out.println("Zadejte jmeno studenta, rok narozeni");
        String jmeno = sc.next();
        int rok = Test.pouzeCelaCisla(sc);
        studenti.put(jmeno, new Student(jmeno, rok));
    }

    // vrací reference na studenta podle jména, nebo null
    public Student getStudent(String jmeno) {
        return studenti.get(jmeno);
    }

    // nastavení průměru podle jména, vrací false pokud student neexistuje
    public boolean setPrumer(String jmeno, float prumer) throws PrumerException {
        Student s = studenti.get(jmeno);
        if (s == null) {
            return false;
        }
        s.setStudijniPrumer(prumer);
        return true;
    }

    // výpis všech studentů (včetně průměru, pokud je)
    public void vypisStudentu() {
        for (Student s : studenti.values()) {
            System.out.print("Jmeno: " + s.getJmeno() + " rok narozeni: " + s.getRocnik());
            try {
                System.out.println(" prumer: " + s.getStudijniPrumer());
            } catch (PrumerException e) {
                System.out.println(" prumer nezadan");
            }
        }
    }

    // výpis pouze jmen všech studentů
    public void vypisJmenStudentu() {
        System.out.println("Jmena studentu v databazi:");
        for (String jmeno : studenti.keySet()) {
            System.out.println(jmeno);
        }
    }

    // odstranění studenta podle jména, vrací true/false podle úspěchu
    public boolean odstranStudenta(String jmeno) {
        return (studenti.remove(jmeno) != null);
    }

    public boolean zapisDoSouboru(String jmenoSouboru) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jmenoSouboru))) {
            bw.write(String.valueOf(studenti.size()));
            bw.newLine();
            for (Student s : studenti.values()) {
                bw.write(s.getJmeno() + " " + s.getRocnik());
                try {
                    bw.write(" " + s.getStudijniPrumer());
                } catch (PrumerException e) {
                    bw.write(" 0");
                }
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Chyba pri zapisu: " + e.toString());
            return false;
        }
    }

    public boolean nacteniZeSoubru(String jmenoSouboru) {
        try (BufferedReader br = new BufferedReader(new FileReader(jmenoSouboru))) {
            studenti.clear();
            String radek = br.readLine();
            if (radek == null)
                return false;
            int pocet = Integer.parseInt(radek.trim());
            for (int i = 0; i < pocet; i++) {
                radek = br.readLine();
                if (radek == null)
                    break;
                Scanner lineSc = new Scanner(radek);
                lineSc.useLocale(Locale.US);
                String jmeno = lineSc.next();
                int rok = lineSc.nextInt();
                float prumer = lineSc.nextFloat();
                Student s = new Student(jmeno, rok);
                if (prumer != 0) {
                    try {
                        s.setStudijniPrumer(prumer);
                    } catch (PrumerException e) {
                        // ignorovat chybný průměr
                    }
                }
                studenti.put(jmeno, s);
                lineSc.close();
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
            return false;
        } catch (IOException e) {
            System.out.println("Chyba pri cteni: " + e.toString());
            return false;
        }
    }
}
