package Store;

import java.io.*;
import java.util.*;

/**
@author Sarah Zsohar
@author Jesse Gonzalez
*/

public class Inventory {
  private  List<MovieInformation> movies;

  /**
  * Opens a file and creates a movie inventory ListArru
  */
  public MovieInventory() {
    movies=new ArrayList<MovieInformation>();
  
    try {
      FileInputStream fin = new FileInputStream("inventory");
	    ObjectInputStream ois = new ObjectInputStream(fin);
	    movies = (ArrayList<MovieInformation>)ois.readObject(); 
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
	    FileOutputStream fout = new FileOutputStream("inventory");
	    ObjectOutputStream oout = new ObjectOutputStream(fout);
	    oout.writeObject(movies);
	    oout.close();
	  }catch (IOException e){
	    System.out.println("Problem with file output");
    }
  }
  
  /**
  * Adds a movie to the MovieInventory
  * @param information about the movie, sku, quanity, price and title
  */
  void addMovie(int sku, int quantity, double price, String title) {
	  for (MovieInformation m : movies){		//m declares a movie object
	    if (sku == m.getSku() || quantity < 0 || price < 0 ) {
	      System.out.println("Invalid input.");
	      return;
	    }
	  }
	  MovieInformation newMovie = new MovieInformation(sku, quantity, price, title);
	  movies.add(newMovie);
	  System.out.print("\n");
  }
  
  /**
  * Removes a movie from the MovieInventory
  * @param sku to be removed
  */
  void removeMovie(int removeSku) {
    for(MovieInformation m : movies){		//m declares a movie object
      if(m.getSku() == removeSku){
        movies.remove(m);
        System.out.println("Movie removed.");
        return;
      }
	} 
	System.out.print("No movie found with this SKU \n");   
  }
		
  /**
  * Displays a movie selected by SKU input by the user
  * @param the SKU of the selected movie
  */
  void displayMovieInfo(int displaySku){
    for(MovieInformation m : movies){    //m declares a movie object
      if(m.getSku() == displaySku){
        String display = m.display();    //display is a holder for the string returned
	    System.out.println(display);    //from the displayMovie function
	    return;
	  }
    }
    System.out.print("No movie found with this SKU\n");
	System.out.print("\n");
  }
	
  /**
  * Displays all the movies in the MovieInventory
  */
  void displayAllMovies(){
    for(MovieInformation m : movies){    //m declares a movie object
      String display=m.display();    //display is a holder for the string returned
	    System.out.println(display);    //from the displayMovie function
	  }
	  System.out.print("\n");
  }
}

