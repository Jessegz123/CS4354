package store;
/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

/**
   SubClass
 */
public class Movie extends Product{
  private int upc;
  public Movie(int sku, int quantity, double price, String title, int upc) {
		super(sku, quantity, price, title, "Movie",2.98,0.12);
		this.upc = upc;

	}


}
