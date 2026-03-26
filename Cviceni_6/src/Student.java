
public class Student {
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws PrumerException {
		if (studijniPrumer==0)
			throw new PrumerException();
		return studijniPrumer;
	}

	public void setStudijniPrumer(float studijniPrumer) throws PrumerException  {	
		if (studijniPrumer<1||studijniPrumer>5)
			throw new PrumerException("Studijni prumer mimo rozsah "+studijniPrumer);
		this.studijniPrumer = studijniPrumer;
	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}