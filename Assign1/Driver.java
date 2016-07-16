package Store;

import java.util.Scanner;

/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

public class Driver {
 
  /**
  * Creates a new movie inventory
  */
  private static MovieInventory inventory = new MovieInventory();

  public static void main (String [] args){
    Scanner input = new Scanner (System.in);
	int choice;
	       
    do{
      System.out.print("1. Add a movie to the inventory \n");
	  System.out.print("2. Remove a movie from the inventory \n");
	  System.out.print("3. Display the information for a movie \n");
	  System.out.print("4. Display the inventory in a table \n");
	  System.out.print("5. Quit \n\n");
	  System.out.print("Enter your choice: \n");
	  
	  choice = input.nextInt();
		      
      if(choice==1){
	    System.out.println("SKU:");
	    int sku = input.nextInt();			//declare SKU

        System.out.println ("Quantity");
	    int quantity= input.nextInt();		//declare quantity

	    System.out.print ("Price: \n");
	    double price = input.nextDouble();  //declare price
	    
	    input.nextLine();

	    System.out.println ("Title: ");
	    String title = input.nextLine();		//declare title
					
	    inventory.addMovie(sku, quantity, price, title);
      }
  
      if(choice==2){
        //Scanner input = new Scanner (System.in);
        System.out.print("Enter SKU to remove: \n");
	    int removeSku = input.nextInt();	//declare SKU to pass as parameter
        inventory.removeMovie(removeSku);
      }
    
	  if(choice==3){
	    //Scanner input = new Scanner (System.in);
	    System.out.print("Enter SKU to display: \n");
	    int displaySku = input.nextInt();		//declare SKU to pass as parameter
	    inventory.displayMovieInfo(displaySku);
	  }
	  
	  if(choice==4){
	    inventory.displayAllMovies();
	  }
    } while(choice != 5);

    inventory.writeToFile();
    System.out.print("Program Ended");
  }	
}



