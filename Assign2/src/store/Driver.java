package store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver for the store inventory program.
 * inputs stored inventory from a file, offers users a menu of 6 options
 * add product, remove product, find product, display inventory, process 
 * a sale, and quit. When the users selects quit, the inventory is saved 
 * to a file.
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/

public class Driver {
 
	/**
   * Creates a new product inventory
  */
  public static void main (String [] args) { 
  	Inventory inventory = new Inventory();
  	int sku; // sku of product to add/ remove/ search
  	int quantity; // quantity of product to add
  	double price; // price of product to add
  	String title; // title of product to add
  	int isbn; // isbn of product to add
  	int upc; // upc of product to add;
  	double weight; // weight of product to add
  	double shippingCost; // shipping cost of product
	  int choice; // choice from menu
	  Scanner input = new Scanner (System.in);
	       
    do {
      System.out.print("1. Add a product to the inventory \n");
	    System.out.print("2. Remove a product from the inventory \n");
	    System.out.print("3. Display the information for a product \n");
	    System.out.print("4. Display the inventory in a table \n");
	    System.out.print("5. Process a sale \n");
	    System.out.print("6. Quit \n\n");
	    System.out.print("Enter your choice: \n");
	   
      choice = input.nextInt();
	    input.nextLine();
	  
	    if (choice == 1) {
	      System.out.println("Add a Product (Enter M for Movie, B for book,"
	      		+ " or T for Toy: )");
	      String item = input.next();
	    
	      if (item.equals("M") || item.equals("B") || item.equals("T")
	      	  || item.equals("m") || item.equals("b") || item.equals("t")){
	      	
	    	  System.out.println("SKU:");
	        sku = input.nextInt();			//declare SKU
        
	        System.out.println ("Quantity");
          quantity= input.nextInt();		//declare quantity
	      
          System.out.print ("Price: \n");
	        price = input.nextDouble();  //declare price
	        input.nextLine();
	      
	        System.out.println ("Title: ");
	        title = input.nextLine();	//declare title
	       	
	        if(item.equals("M") || item.equals("m")){
	      	  System.out.println ("UPC: ");
	          upc = input.nextInt();
	          // Add movie to inventory
	          if (inventory.validateProduct(sku, quantity, price) == 0){
	        	  Movie newProduct = new Movie(sku, quantity, price, title,
	        			  upc);
		          inventory.items.add(newProduct);
	          }
	          // Errors adding movie to inventory
	          else if (inventory.validateProduct(sku, quantity, price) == -1)
	        	  System.out.println("Unable to add, SKU is not unique.");
	          else if (inventory.validateProduct(sku, quantity, price) == -2)
	            System.out.println("Unable to add, price or quantity are less "
	            		+ "then 0.");
	        }	
	      
	        else if(item.equals("B") || item.equals("b")){
	          System.out.println ("Author: ");
	          String author = input.nextLine();
	          System.out.println ("ISBN: ");
	       	  isbn = input.nextInt();	
	       	  // Add book to inventory
	       	  if (inventory.validateProduct(sku, quantity, price) == 0) {
	       	  	Book newProduct = new Book(sku, quantity, price, title, author, isbn);
	        	  inventory.items.add(newProduct);
	       	  }
	       	  // Errors adding book to inventory
	       	  else if (inventory.validateProduct(sku, quantity, price) == -1)
	        	  System.out.println("Unable to add, SKU is not unique.");
	       	  else if (inventory.validateProduct(sku, quantity, price) == -2)
	            System.out.println("Unable to add, price or quantity are less"
	            		+ " then 0.");
	        }
	      
	        else if(item.equals("T") || item.equals("t")){
	      	  System.out.println ("Weight: ");
	      	  weight = input.nextDouble();
	      	  // Add toy to inventory
	      	  if (inventory.validateProduct(sku, quantity, price) == 0) {
	      	  	Toy newProduct = new Toy(sku, quantity, price, title, weight);
	      	  	inventory.items.add(newProduct);
	      	  }
	      	  // Errors adding book to inventory
	      	  else if (inventory.validateProduct(sku, quantity, price) == -1)
	        	  System.out.println("Unable to add, SKU is not unique.");
	      	  else if (inventory.validateProduct(sku, quantity, price) == -2)
	            System.out.println("Unable to add, price or quantity are "
	            		+ "less then 0.");
	        }
	      }
	      else{
	    	  System.out.println("Invalid entry");
	      }
	    }
      
      if (choice == 2) {
        System.out.print("Enter SKU to remove: \n");
	      sku = input.nextInt();	//declare SKU to pass as parameter
	      inventory.removeProduct(sku);
      }
    
	    if (choice == 3) {
	      System.out.print("Enter SKU to display: \n");
	      sku = input.nextInt();		//declare SKU to pass as parameter
	      System.out.println("\n"); 
	      inventory.displayProductInfo(sku);
	    }
	  
	    if (choice == 4) {
	      inventory.displayAllProducts();
	    }
	  
	    if (choice == 5) {
	    
	      System.out.println("SKU:");
	      sku = input.nextInt(); //declare SKU
	      if (inventory.validateProduct(sku, 1, 1.0) == -1){
		      System.out.println ("Quantity");
		      quantity = input.nextInt();		//declare quantity
		      System.out.println ("Shipping Cost");
		      shippingCost = input.nextDouble();		//declare quantity
		    
		      System.out.println (inventory.ProcessSale(sku, quantity,
		    		  shippingCost));
	      }
	      else System.out.println("Unable find matching SKU \n");
	    }
 
	  
	    if (choice > 6 || choice < 1) 
	  	  System.out.println ("Invalid option");
	  
    } while (choice != 6);
    
    inventory.writeToFile();
    System.out.print("Program Ended");
  }	
}


