package ExceptionsPackage;

@SuppressWarnings("serial")
public class ContactExistsException extends Exception {
	
	public static final String MESSAGE = "Contact already exists.";
	
	public ContactExistsException() {
		super(MESSAGE);
	}
}