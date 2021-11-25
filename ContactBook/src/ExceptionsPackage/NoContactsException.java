package ExceptionsPackage;

@SuppressWarnings("serial")
public class NoContactsException extends Exception {
	
	public static final String MESSAGE = "Contact book empty.";
	
	public NoContactsException() {
		super(MESSAGE);
	}
}