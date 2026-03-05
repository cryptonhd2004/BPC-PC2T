package cvi3;

public class BPIS implements Predmet {
    private boolean zapocet;

    @Override
    public String getNazev() {
        return "BPIS";
    }

    // Zadání říká "metodu pro udělení zápočtu"
    public void udelZapocet() {
        zapocet = true;
    }

    @Override
    public int getPocetBodu() {
        // BPIS v zadání nemá body, tak vracíme 0
        return 0;
    }

    @Override
    public boolean maZapocet() {
        return zapocet;
    }
}
