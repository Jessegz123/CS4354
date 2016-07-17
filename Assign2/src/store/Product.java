package store;

import java.io.Serializable;
import java.text.DecimalFormat;
/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

/**
   Superclass 
 */
public class Product implements Serializable, Comparable<Product> {
	
  private int sku;			//holds the SKU of the product
  private int quantity;		//hold the quantity of the product
  double price;		//hold the price of the product
  private String title; 	//hold the title of the product
  private String type;       //declare whether a product is a book, movie, or toy
  private double shippingCredit;
  private double commission;
  DecimalFormat dfd = new DecimalFormat("$#0.00");
  /**
   * The product information information
   * @param an int for the sku, an int for the quantity, a double for price, and a string for 
   * title
   * @return none
   */
   public Product(int sku, int quantity, double price, String title, String type, 
 		  double shippingCredit, double commission){
     this.sku = sku;
     this.quantity = quantity;
 	this.price = price;
 	this.title = title;
 	this.type = type;
 	this.shippingCredit = shippingCredit;
 	this.commission = commission;
   }
  /**
   * Returns the SKU of a product
   * @return the int SKU of a product
   */
   int getSku(){ return sku; }
   
   /**
    * Returns the SKU of a product
    * @return the int SKU of a product
    */
    double getPrice(){ return price; }
    
    /**
     * Returns the SKU of a product
     * @return the int SKU of a product
     */
     double getShippingCredit(){ return shippingCredit; }
     
     /**
      * Returns the SKU of a product
      * @return the int SKU of a product
      */
      double getCommission(){ return commission; }
     
    
   /**
    * Returns the quantity of a product
    * @return the int SKU of a product
    */
    int getQuantity(){ return quantity; }
   
    /**
     * Returns the SKU of a product
     * @return the int SKU of a product
     */
     void setQuantity(int newQuantity){ quantity = newQuantity; }
	  
  /**
  * Returns a String of formatted product data
  * @param none
  * @return a string of the formatted data for table output
  */
  public String display(){
    String output = this.type+ "	" + this.sku + "	" + this.quantity +
      "	  " + dfd.format(price) + "    "+this.title;    		 
    return output;
  }
  
  public int compareTo(Product compareProduct) {
		
		int compareSku = ((Product) compareProduct).getSku(); 
		
		//ascending order
		return this.sku - compareSku;
		
		//descending order
		//return compareQuantity - this.quantity;
		
	}	
  
}