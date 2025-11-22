/**
 * For JUnit5 testing.
 */
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * For class functionality.
 */
import java.util.List;
import java.util.ArrayList;


/**
 * Represents a single book.
 * 
 * Temporary book object for testing purposes.
 */
class Book
{
	String title,
			author;
	
	/**
	 * Constructor to set Title and Author.
	 * 
	 * @param t Given title name.
	 * @param a Given Author name.
	 */
	public Book(String t, String a)
	{
		this.title = t;
		this.author = a;
	}
}

/**
 * Represents a single Book Category.
 */
public class Category 
{
	String name;
	
	/**
	 * Constructor giving the Category its name when created.
	 * 
	 * @param c Given Category name.
	 */
	/*
	public Category(String c)
	{
		this.name = c;
	}
	*/
	
	List<Book> books = new ArrayList<>();
	
	/**
	 * Adds a book to the book list.
	 * 
	 * @param book The Book added.
	 */
	public void addBook(Book book)
	{
		//Only add Book to list if not a duplicate.
		if(!books.contains(book))
		{
			books.add(book);
		}	
	}
	
	/**
	 * Removes a book from the book list.
	 * 
	 * @param book The Book removed.
	 */
	public void removeBook(Book book)
	{	
		//Only remove Book if it exists.
		if(books.contains(book))
		{
			books.remove(book);
		}
	}
	
	/**
	 * Provides this ArrayList of Books.
	 * 
	 * @return books This Book list.
	 */
	public List<Book> listBooks()
	{
		return books;
	}
	
	/**
	 * Method to test functionality of class with JUnit.
	 */
	@Test
	public void testMethods()
	{
		Category testCat = new Category();
		
		List<Book> catRef = testCat.listBooks();
		
		Book bookOne = new Book("Book One","Author One");
		Book bookTwo = new Book("Book Two","Author Two");
		Book bookThree = new Book("Book Three","Author Three");
		
		/************
		 *Proper use*
		 ************/
		
		//Testing Book addition to Category.
		testCat.addBook(bookOne);
		testCat.addBook(bookTwo);
		testCat.addBook(bookThree);
		
		//Correct Books contained in list.
		assertTrue("Book addition test", catRef.contains(bookOne));
		assertTrue("Book addition test", catRef.contains(bookTwo));
		assertTrue("Book addition test", catRef.contains(bookThree));
		
		//Testing Book removal from Category and that it is the correct list.
		testCat.removeBook(bookOne);
		testCat.removeBook(bookThree);
		
		//2 Books removed.
		assertEquals("Book removal test", 1, catRef.size());
		
		//Correct last book remaining.
		assertTrue("Book correctness test", catRef.contains(bookTwo));
		
		
		/**************
		 *Improper use*
		 **************/
		
		//Attempting to add duplicate book.
		testCat.addBook(bookTwo);
		
		//Duplicate book not added.
		assertEquals("Book duplicate addition test", 1, catRef.size());
		
		//Attempting to remove non-existant book.
		testCat.removeBook(bookOne);
	
		assertEquals("Non-existant Book removal test", 1, catRef.size());
		
		/************
		 *Edge Cases*
		 ************/
		
		/**
		 * Java will not allow the testing for the edge cases described
		 * in the test plan.
		 */
	}
}














