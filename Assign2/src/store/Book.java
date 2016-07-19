package store;

/**
 * Sub-Class representing a book in an inventory
 * Stores the author, and international standard book number.
 * Displays the Book ISBN and Author
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/
public class Book extends Product {
  
	private int isbn; // stores international standard book number
  private String author; // stores author name

  /**
   * Constructs book from parameters
   * @param sku the stock keeping unit of the book
   * @param quantity the number of copies in stock
   * @param price the selling price of the book
   * @param title the tile of the book
   * @param author the author of the book
   * @param isbn international standard book number
  */
  public Book(int sku, int quantity, double price, String title, String author, int isbn) {
    super(sku, quantity, price, title, "Book", 3.99, (0.15 * price));
    this.author = author;
	  this.isbn = isbn;	
  }
  
  /**
   * Returns a String of formatted product data
   * @param none
   * @return a string of the formatted data for product info
  */
  public String display(){
  	super.display();
    String output = super.display() + "Author: " +this.author + "\n" 
      + "ISBN: " + this.isbn + "\n";
    return output;
  }  
}
