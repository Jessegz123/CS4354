package store;
/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

/**
   SubClass
 */
public class Toy extends Product {
  private double weight;

  public Toy(int sku, int quantity, double price, String title, double weight) {
		super(sku, quantity, price, title, "Toy",(4.49+(.5*(weight/16))),0.15);
		this.weight = weight;
  }

}
