package store;

import java.io.*;
import java.util.*;

/**
 * Represents the inventory of the store
 * it provides methods to add a product to the inventory, remove a product from the
 * inventory (given the sku from the user), find and display a movie (given a sku 
 * from the user), and display all the products in the inventory.
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/

public class Inventory implements Serializable {
  
	private  ArrayList<Product> items = new ArrayList<Product>(); // inventory

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
	}catch (IOException e){
	  System.out.println("Problem with file output");
    }
  }
  
  /**
   * Validates the product
  * @param information about the movie, sku, quantity, price and title
  * @return returns true if the items meets all the necessary criteria
  * price > 0, quantity > 0, and sku is original 
  */
  boolean validateProduct(int sku, int quantity, double price) {
  	for (Product m : items){		//p declares a product object
  		if (sku == m.getSku() || quantity < 0 || price < 0 ) {
  			return false;
  		}
  	}
  	return true;
  }
  
  /**
   * Adds a movie to the Inventory
  * @param information about the movie, sku, quanity, price and title
  */
  void addMovie(int sku, int quantity, double price, String title, int upc) {
  	Movie newProduct = new Movie(sku, quantity, price, title, upc);
  	items.add(newProduct);
  	System.out.print("\n");
  }
  
  /**
  * Adds a book to the Inventory
  * @param information about the book: sku, quantity, price, title, author, isbn
  */
  void addBook(int sku, int quantity, double price, String title, String author, int isbn) {
  	Book newProduct = new Book(sku, quantity, price, title, author, isbn);
  	items.add(newProduct);
  	System.out.print("\n");
  }
   
   /**
   * Adds a toy to the Inventory
   * @param information about the book: sku, quantity, price, title, and weight
   */
  void addToy(int sku, int quantity, double price, String title,  double weight) {
  	Toy newProduct = new Toy(sku, quantity, price, title, weight);
  	items.add(newProduct);
  	System.out.print("\n");
   }
  
  /**
   * Removes a product from the Inventory
   * @param sku to be removed
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
  * @param the SKU of the selected product
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
      String display=p.display();    //display is a holder for the string returned
      System.out.println(display);    //from the display function
    }
    System.out.print("\n");
  }
  
  /**
  * Processes sale of a certain product. Constructs a string
  * @param sku, quantity, shipping
  * @return a string with all of the field values labeled
  */
  String ProcessSale( int sku, int quantity, double shippingC) {
    for(Product p : items){    //p declares a product object
	  if(p.getSku() == sku){
	    if (p.getQuantity() < quantity)
	    	return "Error with purchase";
	    else {
	      int newQuantity = p.getQuantity() - quantity;
	      p.setQuantity(newQuantity);
	      String output =  "Total price: " + p.dfd.format(p.getPrice() * quantity) + " \n"
	          + "Total shipping credit: " + p.dfd.format(p.getShippingCredit() * quantity) + "\n" 
	          +  "Total commission: " + p.dfd.format(p.getCommission() * quantity) +"\n" +
	          "Profit: "+ ((p.getPrice() * quantity)+(p.getShippingCredit() * quantity)
	        		  -((p.getCommission() * quantity)+ shippingC ));
	      return output;
	    }
	  }
	} 
  return "Error occured";
  }
}
  
