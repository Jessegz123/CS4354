package store;

import java.text.DecimalFormat;
import java.lang.*;

/**
 * Sub-Class representing a toy in an inventory
 * Stores the total weight in oz.
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/
public class Toy extends Product {
  private double weight; // stores total weight in oz
  
  /**
   * Constructs toy from parameters
   * @param sku the stock keeping unit of the toy
   * @param quantity the number of toys in stock
   * @param price the selling price of the toy
   * @param title the name of the toy
   * @param weight the toal weight of the toy in oz
  */
  public Toy(int sku, int quantity, double price, String title,
		  double weight) {
  	super(sku, quantity, price, title, (4.49 + (.5 *
  			(Math.ceil(weight / 16.0)))), (0.15 * price));

  }
  
  /**
   * Returns a String of formatted product data
   * @return a string of the formatted data for table output
  */
  public String displayAll(){
    String output = "Toy   " + super.displayAll();
    return output;
  }
  
  /**
   * Returns a String of formatted product data
   * @return a string of the formatted data for product info
  */
  public String display(){
  	DecimalFormat dft = new DecimalFormat("#0");
  	super.display();
    String output = super.display() + "Weight: " + dft.format(this.weight) 
    + "\n";
    return output;
  }  
}
