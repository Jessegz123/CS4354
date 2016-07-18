package store;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Super-Class representing a product in an inventory
 * Stores the stock keeping unit number, the quantity, price, and title
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
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
   * Constructs product from parameters
   * @param sku the stock keeping unit of the product
   * @param quantity the number of copies in stock
   * @param price the selling price of the product
   * @param title the tile of the product
   * @param type the type of product (movie, book, toy)
   * @param shippingCredit the shipping credit
   * @param commission the commission
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
   * @return a string of the formatted data for product info
  */
  public String display(){
    String output = "SKU: " +this.sku + "\n" 
      + "Quantity: " + this.quantity + "\n"
      + "Price: " + dfd.format(price) + "\n"
      + "Title: " + this.title + "\n";    		 
    return output;
  }  
  
  /**
   * Returns a String of formatted product data
   * @param none
   * @return a string of the formatted data for table output
  */
  public String displayAll(){
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