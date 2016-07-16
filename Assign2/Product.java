package store;

import java.io.Serializable;
import java.text.DecimalFormat;
/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

/**
   SubClass
 */
public class Product implements Serializable {
	
  private int sku;			//holds the SKU of the product
  private int quantity;		//hold the quantity of the product
  private double price;		//hold the price of the product
  private String title; 	//hold the title of the product
	
  DecimalFormat dfd = new DecimalFormat("$#0.00");

  /**
  * The product information information
  * @param an int for the sku, an int for the quantity, a double for price, and a string for 
  * title
  * @return none
  */
  public Product(int sku, int quantity, double price, String title){
    this.sku = sku;
    this.quantity = quantity;
	  this.price = price;
	  this.title = title;
  }
	  
  /**
  * Returns a String of formatted product data
  * @param none
  * @return a string of the formatted data for table output
  */
  public String display(){
    String output = this.sku + "	" + this.quantity +
      "	  " + dfd.format(price) + "    "+this.title;    		 
    return output;
  }
  
  /**
  * Returns the SKU of a product
  * @return the int SKU of a product
  */
  int getSku(){
	  return sku;
  }
}
