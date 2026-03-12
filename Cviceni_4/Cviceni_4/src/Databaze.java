import java.util.Scanner;

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
        return prvkyDatabaze[idx];  // případné chyby ošetří Test
    }

    public void setPrumer(int idx, float prumer) throws StudentException {
        prvkyDatabaze[idx].setStudijniPrumer(prumer); // StudentException i NPE/ArrayIndex v Testu
    }

    private Scanner sc;
    private Student[] prvkyDatabaze;
    private int posledniStudent;
}
