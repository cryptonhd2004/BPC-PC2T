import java.util.Scanner;

public class Test {

    public static int pouzeCelaCisla(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }
        return cislo;
    }

    public static float pouzeCisla(Scanner sc) {
        float cislo = 0;
        try {
            cislo = sc.nextFloat();
        } catch (Exception e) {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cislo ");
            sc.nextLine();
            cislo = pouzeCisla(sc);
        }
        return cislo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze();
        float prumer;
        int volba;
        boolean run = true;
        while (run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vlozeni noveho studenta");
            System.out.println("2 .. nastaveni prumeru studenta (podle jmena)");
            System.out.println("3 .. vypis informace o studentovi (podle jmena)");
            System.out.println("4 .. vypis vsech studentu");
            System.out.println("5 .. vypis pouze jmen studentu");
            System.out.println("6 .. odstraneni studenta podle jmena");
            System.out.println("7 .. ulozeni do souboru");
            System.out.println("8 .. nacteni ze souboru");
            System.out.println("9 .. ukonceni aplikace");
            volba = pouzeCelaCisla(sc);
            switch (volba) {
                case 1:
                    mojeDatabaze.setStudent();
                    break;
                case 2:
                    System.out.println("Zadejte jmeno a prumer studenta");
                    String jmenoPrumer = sc.next();
                    prumer = pouzeCisla(sc);
                    try {
                        if (!mojeDatabaze.setPrumer(jmenoPrumer, prumer)) {
                            System.out.println("Student s timto jmenem nebyl nalezen");
                        }
                    } catch (PrumerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Zadejte jmeno studenta");
                    String jmenoInfo = sc.next();
                    Student info = mojeDatabaze.getStudent(jmenoInfo);
                    if (info == null) {
                        System.out.println("Student s timto jmenem nebyl nalezen");
                    } else {
                        System.out.print("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik());
                        try {
                            System.out.println(" prumer: " + info.getStudijniPrumer());
                        } catch (PrumerException e) {
                            System.out.println(" prumer nezadan");
                        }
                    }
                    break;
                case 4:
                    mojeDatabaze.vypisStudentu();
                    break;
                case 5:
                    mojeDatabaze.vypisJmenStudentu();
                    break;
                case 6:
                    System.out.println("Zadejte jmeno studenta k odstraneni");
                    String jmenoDel = sc.next();
                    if (!mojeDatabaze.odstranStudenta(jmenoDel)) {
                        System.out.println("Student s timto jmenem nebyl nalezen");
                    }
                    break;
                case 7:
                    if (!mojeDatabaze.zapisDoSouboru("test.txt"))
                        System.out.println("Zapis se nezdaril");
                    break;
                case 8:
                    if (!mojeDatabaze.nacteniZeSoubru("test.txt"))
                        System.out.println("Nacteni se nezdarilo");
                    break;
                case 9:
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}
