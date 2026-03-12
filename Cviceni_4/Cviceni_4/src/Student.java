public class Student {
    public Student(String jmeno, int rocnik) {
        this.jmeno = jmeno;
        this.rocnik = rocnik;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getRocnik() {
        return rocnik;
    }

    public float getStudijniPrumer() throws StudentException {
        if (studijniPrumer == 0.0f) {
            throw new StudentException("Studijní průměr zatím nebyl zadán.");
        }
        return studijniPrumer;
    }

    public void setStudijniPrumer(float studijniPrumer) throws StudentException {
        if (studijniPrumer < 1.0f || studijniPrumer > 5.0f) {
            throw new StudentException("Průměr musí být v rozsahu 1 až 5.");
        }
        this.studijniPrumer = studijniPrumer;
    }

    private String jmeno;
    private int rocnik;
    private float studijniPrumer; // default 0.0f
}
