/**
   An interface that describes the operations of Book objects.
   @author Jeffery Abbott
   @version 1.0
*/

public interface BookInterface 
{
	
    /** Sets the id of the Book.
	 @param  int - id assigned to the book. */
    public void setId(int id);

    
    /** Sets the name of the Book.
	 @param  String - title assigned to the book. */
    public void setTitle(String title);

    /** Sets the author of the Book.
	 @param  String - author assigned to the book. */
    public void setAuthor(String author);

    /** Gets the id of the Book
	 @return  The integer id of the Book. */
    public int getId();

    /** Gets the title of the Book
	 @return  The String title of the Book. */
    public String getTitle();

    
    /** Gets the author of the Book
	 @return  The String author of the Book. */
    public String getAuthor();

    /** Gets a String representation of the Book's title, author and id.
	 @return  A String describing the Book. */
    public String toString();
}
