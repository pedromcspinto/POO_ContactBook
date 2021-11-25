package ExceptionsPackage;

@SuppressWarnings("serial")
public class InputMismatchException extends Exception {
	
	public static final String MESSAGE = "Not a valid phone number.";
	
	public InputMismatchException() {
		super(MESSAGE);
	}
}