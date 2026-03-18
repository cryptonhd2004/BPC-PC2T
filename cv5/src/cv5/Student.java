package cv5;

public class Student {
    public Student(String jmeno, int rocnik) {
        this.jmeno = jmeno;
        this.rocnik = rocnik;
        this.studijniPrumer = 0.0f; // 0 = nezadaný průměr
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getRocnik() {
        return rocnik;
    }

    public float getStudijniPrumer() throws StudentException {
        if (studijniPrumer == 0.0f) {
            throw new StudentException("Studijni prumer zatim nebyl zadan.");
        }
        return studijniPrumer;
    }

    public void setStudijniPrumer(float studijniPrumer) throws StudentException {
        if (studijniPrumer < 1.0f || studijniPrumer > 5.0f) {
            throw new StudentException("Prumer musi byt v rozsahu 1 az 5.");
        }
        this.studijniPrumer = studijniPrumer;
    }

    private String jmeno;
    private int rocnik;
    private float studijniPrumer;
}
