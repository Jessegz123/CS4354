package store;

import java.io.*;
import java.util.*;

/**
 * Represents the inventory of the store
 * it provides methods to add a product to the inventory, remove 
 * a product from theinventory (given the sku from the user), find and
 * display a movie (given a sku from the user), and display all the 
 * products in the inventory.
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/

public class Inventory implements Serializable {
  ArrayList<Product> items = new ArrayList<Product>(); // inventory

  /**
   * Default constructor, creates an empty inventory
  */
  public Inventory() {
  
    try {
      FileInputStream fin = new FileInputStream("inventory.dat");
	    ObjectInputStream ois = new ObjectInputStream(fin);
	    items = (ArrayList<Product>)ois.readObject(); 
	    fin.close();
    } catch (FileNotFoundException e) {
	    System.out.println("Cannot find datafile.");
    } catch (IOException e) {
      System.out.println("Problem with file input.");
    } catch (ClassNotFoundException e) {
	  System.out.println("Class not found on input from file.");
    }
  }

  /**
   * Create a file output stream
  */
  void writeToFile(){
    try{
	    FileOutputStream fout = new FileOutputStream("inventory.dat");
	    ObjectOutputStream oout = new ObjectOutputStream(fout);
	    oout.writeObject(items);
	    oout.close();
	  } catch (IOException e){
	    System.out.println("Problem with file output");
    }
  }
  
  /**
   * Validates the product
   * @param sku of the product being validated
   * @param quantity of the product trying to ordered
   * @param price price of the product 
   * @return returns 0 if the items meets all the necessary criteria
   * -1 if the sku already exists in the inventory, or -2 if the
   * quantity or price are less then 0
   * 
  */
  int validateProduct(int sku, int quantity, double price) {
  	for (Product m : items){		//p declares a product object
  		if (sku == m.getSku())
  		  return -1;
  		if (quantity < 0 || price < 0 )
    		return -2;
  	}
  	return 0;
  }
  
  /**
   * Removes a product from the Inventory
   * @param removeSku sku of the product to be removed
  */
  void removeProduct(int removeSku) {
  	for(Product p : items){		//p declares a product object
  		if(p.getSku() == removeSku){
  			items.remove(p);
        System.out.println("Product removed.");
        return;
      }
  	} 
	System.out.print("No product found with this SKU \n");   
  }
		
  /**
   * Displays a product selected by SKU input by the user
   * @param displaySku the sku of the product to be displayed
  */
  void displayProductInfo(int displaySku){
    for(Product p : items){    //p declares a product object
      if(p.getSku() == displaySku){
        String display = p.display();    //display is a holder for the string returned
        System.out.println(display);    //from the display function
        return;
      }
    }
    System.out.print("No product found with this SKU\n");
    System.out.print("\n");
  } 
	
  /**
   * Displays all the products in the Inventory
  */
  void displayAllProducts(){
    Collections.sort(items);
    for(Product p : items){    //p declares a product object
      String display=p.displayAll();    //display is a holder for the string returned
      System.out.println(display);    //from the display function
    }
    System.out.print("\n");
  }
  
  /**
   * Processes sale of a certain product. Constructs a string
   * @param sku of the product being processed
   * @param quantity of the products purchased
   * @param shipping shipping cost used my store
   * @return a string with all of the field values labeled
  */
  String ProcessSale( int sku, int quantity, double shippingC) {
    for(Product p : items){    //p declares a product object
      if(p.getSku() == sku){
	      if (p.getQuantity() < quantity){
	    	  return "Quantity exceeds inventory";
	      }
	      else{
	        int newQuantity = p.getQuantity() - quantity;
	        p.setQuantity(newQuantity);
	        String output = String.format("%1s %16s %1s %5s %1s %10s %1s %21s", 
	          "Total price: ", p.dfd.format(p.getPrice() *
	            quantity), 
	          "\nTotal shipping credit: ", p.dfd.format(p.getShippingCredit()
	            * quantity),
	          "\nTotal commission: ", p.dfd.format(p.getCommission()
	            * quantity), 
	          "\nProfit: ", p.dfd.format((p.getPrice() * quantity) + 
	            (p.getShippingCredit() * quantity) - 
	            ((p.getCommission() * quantity)+ shippingC )));
	        return output;
	      }
	    }
    }return null;
  }
}
  

  
