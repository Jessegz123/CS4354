package store;
/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

/**
   SubClass
 */
public class Book extends Product {
  private int isbn;
  private String author;


  public Book(int sku, int quantity, double price, String title, String author,
		  int isbn) {
		super(sku, quantity, price, title, "Book",3.99,0.15);
		this.author = author;
		this.isbn = isbn;

		
  }

}
