package cvi3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BPC1 bpc1 = new BPC1();
        BPC2 bpc2 = new BPC2();
        BPIS bpis = new BPIS();

        System.out.println("=== Zadávání bodů (postupně) ===");

        System.out.print("BPC1: Kolik bodů přidat za aktivitu (0..20, lze postupně)? ");
        int akt1 = sc.nextInt();
        bpc1.pridejBodyZaAktivitu(akt1);

        System.out.print("BPC1: Kolik bodů za závěrečnou zkoušku (0..80)? ");
        int zk1 = sc.nextInt();
        bpc1.nastavBodyZaZkousku(zk1);

        System.out.print("BPC2: Kolik bodů za projekt (0..30)? ");
        int proj = sc.nextInt();
        bpc2.nastavBodyZaProjekt(proj);

        System.out.print("BPC2: Kolik bodů za půlsemestrální zkoušku (0..20)? ");
        int pul = sc.nextInt();
        bpc2.nastavBodyZaPulSemZkousku(pul);

        System.out.print("BPC2: Kolik bodů za závěrečnou zkoušku (0..50)? ");
        int zav = sc.nextInt();
        bpc2.nastavBodyZaZaverecnouZkousku(zav);

        System.out.print("BPIS: Udělit zápočet? (1 = ano, 0 = ne): ");
        int udel = sc.nextInt();
        if (udel == 1) {
            bpis.udelZapocet();
        }

        System.out.println("\n=== Výsledky ===");
        System.out.println(bpc1.getNazev() + ": body=" + bpc1.getPocetBodu()
                + ", zapocet=" + (bpc1.maZapocet() ? "ANO" : "NE"));
        System.out.println(bpc2.getNazev() + ": body=" + bpc2.getPocetBodu()
                + ", zapocet=" + (bpc2.maZapocet() ? "ANO" : "NE"));
        System.out.println(bpis.getNazev() + ": body=" + bpis.getPocetBodu()
                + ", zapocet=" + (bpis.maZapocet() ? "ANO" : "NE"));

        sc.close();
    }
}