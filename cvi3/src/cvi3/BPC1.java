package cvi3;

public class BPC1 implements Predmet {
    private int bodyAktivita; // max 20
    private int bodyZkouska;  // max 80

    @Override
    public String getNazev() {
        return "BPC1";
    }

    public void pridejBodyZaAktivitu(int body) {
        if (body < 0) body = 0;
        bodyAktivita = Math.min(20, bodyAktivita + body);
    }

    public void nastavBodyZaZkousku(int body) {
        if (body < 0) body = 0;
        bodyZkouska = Math.min(80, body);
    }

    @Override
    public int getPocetBodu() {
        return bodyAktivita + bodyZkouska;
    }

    @Override
    public boolean maZapocet() {
        return getPocetBodu() >= MIN_BODU_ZAPOCET;
    }
}