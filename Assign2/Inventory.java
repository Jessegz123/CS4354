package store;

import java.io.*;
import java.util.*;

/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

public class Inventory {
  private  List<Product> items;

  /**
  * Opens a file and creates a item inventory ListArry
  */
  public Inventory() {
    items = new ArrayList<Product>();
  
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
  * Adds a product to the Inventory
  * @param information about the product, sku, quanity, price and title
  */
  void addProduct(int sku, int quantity, double price, String title) {
	  for (Product m : items){		//m declares a product object
	    if (sku == m.getSku() || quantity < 0 || price < 0 ) {
	      System.out.println("Invalid input.");
	      return;
	    }
	  }
	  Product newProduct = new Product(sku, quantity, price, title);
	  items.add(newProduct);
	  System.out.print("\n");
  }
  
  /**
  * Removes a product from the Inventory
  * @param sku to be removed
  */
  void removeProduct(int removeSku) {
    for(Product m : items){		//m declares a product object
      if(m.getSku() == removeSku){
        items.remove(m);
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
    for(Product m : items){    //m declares a product object
      if(m.getSku() == displaySku){
        String display = m.display();    //display is a holder for the string returned
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
    for(Product m : items){    //m declares a product object
      String display=m.display();    //display is a holder for the string returned
	    System.out.println(display);    //from the display function
	  }
	  System.out.print("\n");
  }
}
