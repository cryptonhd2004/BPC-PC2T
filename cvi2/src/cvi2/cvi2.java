package cvi2;

public class cvi2 {
	private double polomer;
	private static double PI = 3.14;
	
	cvi2(double polomer){
		this.polomer = polomer;
	}
	public double getPolomer() {
		return polomer;
	}
	public void setPolomer(double polomer) {
		this.polomer = polomer;
	}
	public static double obsahKruznice(double r) {
		return PI*r*r;
	}
	public double obsah() {
		return obsahKruznice(polomer);
	}
	
}
