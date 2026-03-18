package cv5;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Databaze {
    public Databaze(int pocetPrvku) {
        prvkyDatabaze = new Student[pocetPrvku];
        sc = new Scanner(System.in);
        posledniStudent = 0;
    }

    public void setStudent() {
        System.out.println("Zadejte jmeno studenta, rok narozeni");
        String jmeno = sc.next();
        int rok = sc.nextInt();
        prvkyDatabaze[posledniStudent++] = new Student(jmeno, rok);
    }

    public Student getStudent(int idx) {
        return prvkyDatabaze[idx];
    }

    public void setPrumer(int idx, float prumer) throws StudentException {
        prvkyDatabaze[idx].setStudijniPrumer(prumer);
    }

    // a) výpis celé databáze do konzole
    public void vypisVse() {
        for (int i = 0; i < prvkyDatabaze.length; i++) {
            Student s = prvkyDatabaze[i];
            if (s != null) {
                try {
                    System.out.println(
                        "Jmeno: " + s.getJmeno()
                        + ", rok narozeni: " + s.getRocnik()
                        + ", studijni prumer: " + s.getStudijniPrumer()
                    );
                } catch (StudentException e) {
                    System.out.println(
                        "Jmeno: " + s.getJmeno()
                        + ", rok narozeni: " + s.getRocnik()
                        + ", studijni prumer: nezadan"
                    );
                }
            }
        }
    }

    // b) ulozeni cele databaze do souboru
    // format radku: jmeno;rok;prumer nebo "null"
    public void ulozDoSouboru(String nazevSouboru) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(nazevSouboru); // přepíše soubor, pokud existuje[web:35]
        for (int i = 0; i < prvkyDatabaze.length; i++) {
            Student s = prvkyDatabaze[i];
            if (s != null) {
                float prumer;
                try {
                    prumer = s.getStudijniPrumer();
                } catch (StudentException e) {
                    prumer = 0.0f; // 0 = nezadany prumer
                }
                pw.println(s.getJmeno() + ";" + s.getRocnik() + ";" + prumer);
            } else {
                pw.println("null");
            }
        }
        pw.close();
    }

    // c) nacteni cele databaze ze souboru
    public void nactiZeSouboru(String nazevSouboru) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(nazevSouboru));[web:30]
        int i = 0;
        while (fileScanner.hasNextLine() && i < prvkyDatabaze.length) {
            String radek = fileScanner.nextLine();
            if (radek.equals("null")) {
                prvkyDatabaze[i] = null;
            } else {
                String[] casti = radek.split(";");
                if (casti.length >= 3) {
                    String jmeno = casti[0];
                    int rok = Integer.parseInt(casti[1]);
                    float prumer = Float.parseFloat(casti[2]);
                    Student s = new Student(jmeno, rok);
                    try {
                        if (prumer != 0.0f) {
                            s.setStudijniPrumer(prumer);
                        }
                    } catch (StudentException e) {
                        System.out.println("Chybna hodnota prumeru v souboru: " + e.getMessage());
                    }
                    prvkyDatabaze[i] = s;
                } else {
                    prvkyDatabaze[i] = null;
                }
            }
            i++;
        }
        fileScanner.close();
    }

    private Scanner sc;
    private Student[] prvkyDatabaze;
    private int posledniStudent;
}
