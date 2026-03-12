import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    public static int pouzeCelaCisla(Scanner sc) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("Zadejte prosim cele cislo.");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }
        return cislo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Databaze mojeDatabaze = new Databaze(1);
        int idx;
        float prumer;
        int volba;
        boolean run = true;

        while (run) {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni nove databaze");
            System.out.println("2 .. vlozeni noveho studenta");
            System.out.println("3 .. nastaveni prumeru studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. ukonceni aplikace");

            volba = pouzeCelaCisla(sc);

            switch (volba) {
                case 1:
                    System.out.println("Zadejte pocet studentu");
                    try {
                        int pocet = pouzeCelaCisla(sc);
                        mojeDatabaze = new Databaze(pocet);
                    } catch (Exception e) {
                        System.out.println("Chyba pri vytvareni databaze: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        mojeDatabaze.setStudent();
                    } catch (InputMismatchException e) {
                        System.out.println("Spatny format vstupu: " + e.toString());
                        sc.nextLine();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Databaze je plna (mimo rozsah pole): " + e.toString());
                    } catch (NullPointerException e) {
                        System.out.println("Databaze neni inicializovana: " + e.toString());
                    }
                    break;

                case 3:
                    System.out.println("Zadejte index a prumer studenta");
                    try {
                        idx = pouzeCelaCisla(sc);
                        prumer = sc.nextFloat();
                        mojeDatabaze.setPrumer(idx, prumer);
                    } catch (InputMismatchException e) {
                        System.out.println("Spatny format vstupu (ocekavan float): " + e.toString());
                        sc.nextLine();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Chybny index studenta: " + e.toString());
                    } catch (NullPointerException e) {
                        System.out.println("Na danem indexu neni zadny student: " + e.toString());
                    } catch (StudentException e) {
                        System.out.println("Chyba studijniho prumeru: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Zadejte index studenta");
                    try {
                        idx = pouzeCelaCisla(sc);
                        Student info = mojeDatabaze.getStudent(idx);
                        System.out.println("Jmeno: " + info.getJmeno()
                                + " rok narozeni: " + info.getRocnik()
                                + " prumer: " + info.getStudijniPrumer());
                    } catch (InputMismatchException e) {
                        System.out.println("Spatny format vstupu: " + e.toString());
                        sc.nextLine();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Chybny index studenta: " + e.toString());
                    } catch (NullPointerException e) {
                        System.out.println("Na danem indexu neni zadny student nebo databaze neni vytvorena: " + e.toString());
                    } catch (StudentException e) {
                        System.out.println("Chyba pri cteni prumeru: " + e.getMessage());
                    }
                    break;

                case 5:
                    run = false;
                    break;

                default:
                    System.out.println("Neplatna volba menu.");
            }
        }

        sc.close();
    }
}

