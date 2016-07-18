package store;

import java.util.Scanner;

/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

public class Driver {
 
  /**
  * Creates a new product inventory
  */
  private static Inventory inventory = new Inventory();

  public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
	int choice;
	       
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
	      int sku = input.nextInt();			//declare SKU
          System.out.println ("Quantity");
	      int quantity= input.nextInt();		//declare quantity
	      System.out.print ("Price: \n");
	      double price = input.nextDouble();  //declare price
	      input.nextLine();
	      System.out.println ("Title: ");
	      String title = input.nextLine();	//declare title
	       	
	      if(item.equals("M")){
	        System.out.println ("UPC: ");
	        int upc = input.nextInt();
	    	inventory.addMovie(sku, quantity, price, title, upc);		    
	      }	
	      else if(item.equals("B")){
	        System.out.println ("Author: ");
	        String author = input.next();
	        System.out.println ("ISBN: ");
	       	int isbn = input.nextInt();		    
		    inventory.addBook(sku, quantity, price, title, author, isbn);
	      }
		  else if(item.equals("T")){
		    System.out.println ("Weight: ");
			double weight = input.nextDouble();
			inventory.addToy(sku, quantity, price, title, weight);		    
		  }
	    }
		else{
		  System.out.println("Invalid entry");
		}
	  }
      
      if (choice == 2) {
        //Scanner input = new Scanner (System.in);
        System.out.print("Enter SKU to remove: \n");
	    int removeSku = input.nextInt();	//declare SKU to pass as parameter
        inventory.removeProduct(removeSku);
      }
    
	  if (choice == 3) {
	    //Scanner input = new Scanner (System.in);
	    System.out.print("Enter SKU to display: \n");
	    int displaySku = input.nextInt();		//declare SKU to pass as parameter
	    inventory.displayProductInfo(displaySku);
	  }
	  
	  if (choice == 4) {
	    inventory.displayAllProducts();
	  }
	  
	  if (choice == 5) {
	    System.out.println("SKU:");
		int sku = input.nextInt();			//declare SKU
		System.out.println ("Quantity");
	    int quantity = input.nextInt();		//declare quantity
	    System.out.println ("Shipping Cost");
	    double shippingCost = input.nextDouble();		//declare quantity
	    
	    System.out.println (inventory.ProcessSale(sku, quantity, shippingCost));
	  }
	  if (choice > 6 || choice < 1) System.out.println ("Invalid option");
    } while (choice != 6);

    inventory.writeToFile();
    System.out.print("Program Ended");
  }	
}

