package store;

/**
 * Sub-Class representing a movie in an inventory
 * Stores the universal product code
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/
public class Movie extends Product{
  private int upc; // stores universal product code  
  
  /**
   * Constructs movie from parameters
   * @param sku the stock keeping unit of the movie
   * @param quantity the number of copies in stock
   * @param price the selling price of the movie
   * @param title the tile of the movie
   * @param upc the universal product code
   */
  public Movie(int sku, int quantity, double price, String title, int upc) {
    super(sku, quantity, price, title, "Movie",  2.98, (0.12 * price));
    this.upc = upc;
  }
  
  /**
   * Returns a String of formatted product data
   * @return a string of the formatted data for product info
  */
  public String display(){
  	super.display();
    String output = super.display() + "UPC: " + this.upc + "\n";
    return output;
  } 
}
  
