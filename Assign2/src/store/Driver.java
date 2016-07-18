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
 * a sale, and quit. When the users selects quit, the inventory is daved to a file.
 * @author Sarah Zsohar
 * @author Jesse Gonzalez
*/

public class Driver {
 
  /**
  * Creates a new product inventory
  */
 // private static Inventory inventory = new Inventory();

  public static void main (String [] args) {
  	Inventory inventory;
  	
  	
  	 
  	inventory = new Inventory();
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
	    System.out.println("Add a Product (Enter M for Movie, B for book, or T for Toy: )");
	    String item = input.next();
	    
	    if (item.equals("M") ||item.equals("B") ||item.equals("T")){
	    	System.out.println("SKU:");
	      sku = input.nextInt();			//declare SKU
        
	      System.out.println ("Quantity");
        quantity= input.nextInt();		//declare quantity
	      
        System.out.print ("Price: \n");
	      price = input.nextDouble();  //declare price
	      input.nextLine();
	      
	      System.out.println ("Title: ");
	      title = input.nextLine();	//declare title
	       	
	      if(item.equals("M")){
	      	System.out.println ("UPC: ");
	        upc = input.nextInt();
	        if (inventory.validateProduct(sku, quantity, price))
	        	inventory.addMovie(sku, quantity, price, title, upc);
	        else 
	        	System.out.println("Invalid input.");
	      }	
	      
	      else if(item.equals("B")){
	        System.out.println ("Author: ");
	        String author = input.nextLine();
	        System.out.println ("ISBN: ");
	       	isbn = input.nextInt();	
	       	if (inventory.validateProduct(sku, quantity, price))
	       		inventory.addBook(sku, quantity, price, title, author, isbn);
	       	else 
		        System.out.println("Invalid input.");
	      }
	      
	      else if(item.equals("T")){
	      	System.out.println ("Weight: ");
	      	weight = input.nextDouble();
	      	if (inventory.validateProduct(sku, quantity, price))
	      		inventory.addToy(sku, quantity, price, title, weight);	
	      	else 
		        System.out.println("Invalid input.");
	      }
	    }
	    else{
	    	System.out.println("Invalid entry");
	    }
	  }
      
    if (choice == 2) {
    	//Scanner input = new Scanner (System.in);
      System.out.print("Enter SKU to remove: \n");
	    sku = input.nextInt();	//declare SKU to pass as parameter
	    inventory.removeProduct(sku);
    }
    
	  if (choice == 3) {
	    //Scanner input = new Scanner (System.in);
	    System.out.print("Enter SKU to display: \n");
	    sku = input.nextInt();		//declare SKU to pass as parameter
	    inventory.displayProductInfo(sku);
	    System.out.println("\n"); 
	  }
	  
	  if (choice == 4) {
	    inventory.displayAllProducts();
	  }
	  
	  if (choice == 5) {
	    System.out.println("SKU:");
	    sku = input.nextInt();			//declare SKU
	    System.out.println ("Quantity");
	    quantity = input.nextInt();		//declare quantity
	    System.out.println ("Shipping Cost");
	    shippingCost = input.nextDouble();		//declare quantity
	    
	    System.out.println (inventory.ProcessSale(sku, quantity, shippingCost));
	  }
	  
	  if (choice > 6 || choice < 1) 
	  	System.out.println ("Invalid option");
	  
    } while (choice != 6);

    inventory.writeToFile();
    System.out.print("Program Ended");
  }	
}


