//	Author: Jeffery Abbott
// 	Book.java
//	An object describing a book (title, author, and id)
//	1/27/18

import java.io.*;

public class Book implements BookInterface, Serializable 
{
    private int id;
    private String title;
    private String author;

    public Book(String title, String author, int id) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public int getId() 
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    @Override
    public String toString() 
    {
    		return this.title + ", " + this.author + " (id: " + this.id + ")";
    }
    
}
