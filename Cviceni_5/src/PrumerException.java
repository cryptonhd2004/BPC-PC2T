
public class PrumerException extends Exception {
	public PrumerException() {
		super("Nebyl zadan zadny prumer");
	}
	
	public PrumerException(String message) {
		super(message);
	}
}
