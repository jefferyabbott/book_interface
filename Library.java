//	Author: Jeffery Abbott
// 	Library.java
//	Library class provides a data structure for storing book objects
//	1/27/18

import java.io.*;

public class Library 
{

	private final String FILENAME;
	public Book[] library;
	public static int currentArrayIndex;
	
	
/************************* CONSTRUCTOR ***********************/
	public Library(String filename)
	{
		FILENAME = filename;
		
		// check for existing library.obj file
		File f = new File(FILENAME);
		if(f.exists() && !f.isDirectory()) 
		{ 
			library = deserialzeLibrary();
			
			// get currentArrayIndex
			for (int i = 0; i < library.length; i++) 
			{
				if (library[i] == null)
				{
					currentArrayIndex = i;
					i = library.length;
				}
			}
		}
		else 
		{
			// initialize library with capacity of 10 books
			library = new Book[10];
			currentArrayIndex = 0;
		}
	}
	
   

/************************** addBook() ************************/
    public void addBook(Book book) 
    { 		
    		// check whether book already exists in library
    		if (bookExists(book))
    		{
    			System.out.println(book.getTitle() + " by " + book.getAuthor() + " is already in the library.");
			return;
    		}
    		
    		// check whether id is available
    		if (idExists(book.getId())) 
    		{
    			System.out.println("Id " + book.getId() + " is not available.");
    			return;
    		}
  
    		// check whether library is full
    		if (isFull()) 
    		{
    			extendArray();
    		}
    		
    		library[currentArrayIndex++] = book;
    		System.out.println(book.getTitle() + " by " + book.getAuthor() + " has been added.");
    }
    
    
    
/************************ deleteBook() ***********************/    
    public boolean deleteBook(Book book)
    {
    		// check whether book already exists in library
		if (!bookExists(book))
		{
			System.out.println(book.getTitle() + " by " + book.getAuthor() + " is not in the library.");
			return false;
		}
    	
    		// remove book
		for (int i = 0; i < library.length; i++) {
			if (library[i] != null && library[i].getTitle().equals(book.getTitle()) && library[i].getAuthor().equals(book.getAuthor())) 
			{
				for (int j = i; j < library.length; j++) 
				{
					if (library[j] != null) 
					{
						library[j] = library[j+1];
					}
					else 
					{
						currentArrayIndex--;
						System.out.println(book.getTitle() + " by " + book.getAuthor() + " has been deleted.");
						return true;
					}
				}
			}
		}

    		return false;
    }
    
    
    public boolean deleteBook(int id)
    {	
		// check whether book already exists in library
    		if (!idExists(id)) 
    		{
    			
    			System.out.println("Book with id " + id + " is not in the library.");
    			return false;
    		}
	
		// remove book
    		Book removedBook;
    		for (int i = 0; i < library.length; i++) 
    		{
    			if (library[i] != null && library[i].getId() == id) 
    			{
    				removedBook = library[i];
    				for (int j = i; j < library.length; j++) 
    				{
    					if (library[j] != null) 
    					{
    						library[j] = library[j+1];
    					}
    					else 
    					{
    						currentArrayIndex--;
    						System.out.println(removedBook.getTitle() + " by " + removedBook.getAuthor() + " has been deleted.");
    						return true;
    					}
    				}
    			}
    		}

		return false;
}
    
    
    
/*********************** printLibrary() **********************/
    public void printLibrary() 
    {
        System.out.println("\nLibrary:\n");
        
        for (Book book : library) 
        {
        		if (book == null) 
        		{
        			break;
        		}
        		else 
        		{
        			System.out.println(book);
        		}
        }
    }
    
    

/************************** persist() ************************/
    public boolean persist() 
    {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try 
		{
			fout = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(library); 
			oos.close();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
    }
    
    
    
/*************************************************************/
/*********************** HELPER METHODS **********************/
/*************************************************************/
    
    

/************************* isFull() ***********************/
    private boolean isFull() 
    {
    		if (currentArrayIndex == library.length - 1) 
    		{
    			return true;
    		}
    		else 
    		{
    			return false;
    		}
    }
    

    
/************************ extendArray() **********************/
    private void extendArray() 
    {
    		Book[] newBookArray = new Book[library.length * 2];
    		
    		for (int i = 0; i < library.length; i++) 
    		{
    			newBookArray[i] = library[i];
    		}
    		
    		library = newBookArray;
    }

    
    
/************************ bookExists() ***********************/
    private boolean bookExists(Book book) 
    {
    		for (Book existingBook : library) 
    		{
    			// if no more books in library, end search
			if (existingBook == null) 
			{
				return false;
			}
			else if (existingBook.getTitle().equals(book.getTitle()) && existingBook.getAuthor().equals(book.getAuthor())) 
			{
				return true;
			}
		}
    		return false;
    }

    

/************************* idExists() ************************/
    private boolean idExists(int id) 
    {
    		for (Book existingBook : library) 
    		{
			if (existingBook != null && existingBook.getId() == id) 
			{
				return true;
			}
		}
    		return false;
    }
    
    
    
/********************* deserializeLibrary() ******************/
    private Book[] deserialzeLibrary() 
    {
		Book[] savedLibrary = null;

		try 
		{
			FileInputStream fin = new FileInputStream(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fin);
			savedLibrary = (Book[]) ois.readObject();
			ois.close();
			fin.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 

		return savedLibrary;
	}
    
}
