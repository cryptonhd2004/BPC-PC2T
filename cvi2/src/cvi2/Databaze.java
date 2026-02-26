package cvi2;

public class Databaze {
    private String jmeno;
    private int rokNarozeni;
    private double uvazek;
    private static double maxUvazek = 1.0;

    public Databaze(String jmeno, int rokNarozeni) {
        this.jmeno = jmeno;
        this.rokNarozeni = rokNarozeni;
        this.uvazek = 0.0;
    }


    public String getJmeno() {
        return jmeno;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public double getUvazek() {
        return uvazek;
    }

    public static void setMaxUvazek(double novaHodnota) {
        maxUvazek = novaHodnota;
    }

    public static double getMaxUvazek() {
        return maxUvazek;
    }

    public boolean pridejUvazek(double novyUvazek) {
        if (this.uvazek + novyUvazek > maxUvazek) {
            return false;
        }
        this.uvazek += novyUvazek;
        return true;
    }
}
