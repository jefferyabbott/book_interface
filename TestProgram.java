//	Author: Jeffery Abbott
// 	TestProgram.java
//	Build your own persistent library in Java
//	1/27/18


public class TestProgram 
{

    public static void main(String[] args) 
    {
    		
    		final String FILENAME = "library.obj";
    		
    		// Initialize library from file system
    		Library testLibrary = new Library(FILENAME);
    		
    		
    		// Add 10 books in the Library
    		Book book1 = new Book("Dracula", "Bram Stoker", 1);
    		Book book2 = new Book("Grapes of Wrath", "John Steinbeck", 2);
    		Book book3 = new Book("War and Peace", "Leo Tolstoy", 3);
    		Book book4 = new Book("Frankenstein", "Mary Shelley", 4);
    		Book book5 = new Book("Little Women", "Louisa M. Alcott", 5);
    		Book book6 = new Book("Catcher in the Rye", "J.D. Salinger", 6);
    		Book book7 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 7);
    		Book book8 = new Book("David Copperfield", "Charles Dickens", 8);
    		Book book9 = new Book("The Count of Monte Cristo", "Alexandre Dumas", 9);
    		Book book10 = new Book("Robinson Crusoe", "Daniel Defoe", 10);

    		System.out.println("Add books:");
    		testLibrary.addBook(book1);
    		testLibrary.addBook(book2);
    		testLibrary.addBook(book3);
    		testLibrary.addBook(book4);
    		testLibrary.addBook(book5);
    		testLibrary.addBook(book6);
    		testLibrary.addBook(book7);
    		testLibrary.addBook(book8);
    		testLibrary.addBook(book9);
    		testLibrary.addBook(book10);
    	
    		
    		// Delete 5 books 
    		System.out.println("\nDelete books:");
    		testLibrary.deleteBook(book7);
    		testLibrary.deleteBook(book8);
    		testLibrary.deleteBook(book1);
    		testLibrary.deleteBook(book2);
    		testLibrary.deleteBook(9);	// test deleting by id

    		
    		// Print contents of the Library
    		testLibrary.printLibrary();
        
    		
    		// Persist Library
    		if (testLibrary.persist()) 
    		{
    			System.out.println("\nLibrary saved.");
    		}
    		else 
    		{
    			System.out.println("\n Library failed to save.");
    		}
    }
    
}
