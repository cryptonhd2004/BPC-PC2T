package cvi3;

public class BPC2 implements Predmet {
    private int bodyProjekt;     // max 30
    private int bodyPulSem;      // max 20
    private int bodyZavZkouska;  // max 50

    @Override
    public String getNazev() {
        return "BPC2";
    }

    public void nastavBodyZaProjekt(int body) {
        if (body < 0) body = 0;
        bodyProjekt = Math.min(30, body);
    }

    public void nastavBodyZaPulSemZkousku(int body) {
        if (body < 0) body = 0;
        bodyPulSem = Math.min(20, body);
    }

    public void nastavBodyZaZaverecnouZkousku(int body) {
        if (body < 0) body = 0;
        bodyZavZkouska = Math.min(50, body);
    }

    @Override
    public int getPocetBodu() {
        return bodyProjekt + bodyPulSem + bodyZavZkouska;
    }

    @Override
    public boolean maZapocet() {
        return getPocetBodu() >= MIN_BODU_ZAPOCET;
    }
}
