package ExceptionsPackage;

@SuppressWarnings("serial")
public class ContactNoExistsException extends Exception {
	
	public static final String MESSAGE = "Contact does not exist.";
	
	public ContactNoExistsException() {
		super(MESSAGE);
	}
}