import java.util.Scanner;
import java.util.InputMismatchException;


import ExceptionsPackage.ContactExistsException;
import ExceptionsPackage.ContactNoExistsException;
import ExceptionsPackage.NoContactsException;
import cbook.ContactBook;
import cbook.ContactBookClass;
import cbook.Iterator;

public class Main {
	//Constantes que definem os comandos
	 public static final String ADD_CONTACT    = "AC";
	 public static final String REMOVE_CONTACT = "RC";
	 public static final String GET_PHONE      = "GP";
	 public static final String GET_EMAIL      = "GE";
	 public static final String SET_PHONE      = "SP";
	 public static final String SET_EMAIL      = "SE";
	 public static final String LIST_CONTACTS  = "LC";
	 public static final String QUIT           = "Q";
	 
	 //Constantes que definem as mensagens para o utilizador
	 public static final String CONTACT_EXISTS = "Contact already exists.";
	 public static final String NAME_NOT_EXIST = "Contact does not exist.";
	 public static final String CONTACT_ADDED = "Contact added.";
	 public static final String CONTACT_REMOVED = "Contact removed.";
	 public static final String CONTACT_UPDATED = "Contact updated.";
	 public static final String BOOK_EMPTY = "Contact book empty.";
	
	 public static void main(String[] args) {   
		 Scanner in = new Scanner(System.in);
		 ContactBook cBook = new ContactBookClass();
		 String comm = getCommand(in);
	  
		 while (!comm.equals(QUIT)){
			 switch (comm) {
			 case ADD_CONTACT: 
				 addContact(in,cBook);
				 break;
			 case REMOVE_CONTACT:
				 deleteContact(in,cBook);
				 break;
			 case GET_PHONE:
				 getPhone(in,cBook);
				 break;
			 case GET_EMAIL: 
				 getEmail(in,cBook);
				 break;
			 case SET_PHONE:
				 setPhone(in,cBook);
				 break;
			 case SET_EMAIL:
				 setEmail(in,cBook);
				 break;
			 case LIST_CONTACTS:
				 listAllContacts(cBook);
				 break;
			 default:
				 System.out.println("ERRO");
			 }
			 System.out.println();
			 comm = getCommand(in);
		 }
		 System.out.println("Goodbye!");
		 System.out.println();
		 in.close();
	 }
	
	private static String getCommand(Scanner in) {
		String input;
		input = in.nextLine().toUpperCase();
		return input;
	}

	private static void addContact(Scanner in, ContactBook cBook){

		try {
			String name, email;
			int phone;
			name = in.nextLine();
			phone = in.nextInt(); in.nextLine();
			email = in.nextLine();

			if(cBook.hasContact(name)) {
				throw new ContactExistsException();
			}
			cBook.addContact(name, phone, email);
			System.out.println(CONTACT_ADDED);		
		}
		catch(ContactExistsException e) {
			System.out.println(e.getMessage());
			
		}
		catch(InputMismatchException e) {
			System.out.println("Not a valid phone number.");
			in.nextLine();
			in.nextLine();
		}	
	}
	
	private static void deleteContact(Scanner in, ContactBook cBook) {
		try {
		String name;
		name = in.nextLine();
		
		if (!cBook.hasContact(name)) {
			throw new ContactNoExistsException();
		}
			cBook.deleteContact(name);
			System.out.println(CONTACT_REMOVED);
		}
		catch(ContactNoExistsException e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	private static void getPhone(Scanner in, ContactBook cBook) {
		try {
			String name;
			name = in.nextLine();
			if (!cBook.hasContact(name)) {
				throw new ContactNoExistsException();

			}
			System.out.println(cBook.getPhone(name));
			
		}
		catch(ContactNoExistsException e) {
			System.out.println(e.getMessage());

		}
	}
	
	private static void getEmail(Scanner in, ContactBook cBook) {
		try {
			String name;
			name = in.nextLine();
			if (!cBook.hasContact(name)) {
				throw new ContactNoExistsException();

			}
			System.out.println(cBook.getEmail(name));
			
		}
		catch(ContactNoExistsException e) {
			System.out.println(e.getMessage());

		}
	}
	
	private static void setPhone(Scanner in, ContactBook cBook) {
		try {
		String name;
		int phone;
		name = in.nextLine();
		phone = in.nextInt(); in.nextLine();
		if (!cBook.hasContact(name)) {
			throw new ContactNoExistsException();
			
		}
			cBook.setPhone(name,phone);
			System.out.println(CONTACT_UPDATED);
			
		}
		catch(ContactNoExistsException e) {
			System.out.println(e.getMessage());
			
		}
		catch(InputMismatchException e) {
			System.out.println("Not a valid phone number.");
			in.nextLine();
		}	
	}
	
	private static void setEmail(Scanner in, ContactBook cBook) {
		try {
			String name;
			String email;
			name = in.nextLine();
			email = in.nextLine();
			if (!cBook.hasContact(name)) {
				throw new ContactNoExistsException();
				
			}
				cBook.setEmail(name,email);
				System.out.println(CONTACT_UPDATED);
				
			}
			catch(ContactNoExistsException e) {
				System.out.println(e.getMessage());
				
			}
		}
	private static void listAllContacts(ContactBook cBook) {
		
		try {
			if(cBook.getNumberOfContacts() == 0) {
				throw new NoContactsException();
			}
			Iterator it = cBook.listContacts();
			while(it.hasNext()) 
				System.out.println(it.next());
		}
		catch(NoContactsException e) {
			System.out.println(e.getMessage());
		}
	}
}
