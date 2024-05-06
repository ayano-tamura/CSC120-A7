/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building {
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * Class constructor for building a Library
   * @param name name of library
   * @param address address of library
   * @param nFloors number of floors in library
   * @param hasElevator the library does or doesn't have an elevator
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloading constructor for Library with no elevator
   * @param name name of library
   * @param address address of library
   * @param nFloors number of floors in library
   */
  public Library(String name, String address, int nFloors){
    super(name, address, nFloors);
    this.collection = new Hashtable<> ();
    this.hasElevator = false;
  }

  /**
   * getter for hasElevator
   * @return true if library has elevator, false if not
   */
  public boolean withElevator(){
    return this.hasElevator;
  }
  /**
   * see if library contatins given book title
   * @param title book title to look up
   * @return true if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * getter for isAvailable
   * @param title Book title to look up
   * @return  true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title){
    if (collection.get(title) == true){
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method to add book title to library collection
   * @param title title of book to add to collection
   */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println(title + " has been added to the collection!");
  }

  /**
   * Overloading method for addTitle, to indicate if you want to add a title and show if the book currently checked out or not.
   * @param title title of book to add
   * @param inLibrary availability of the book when being added
   */
  public void addTitle(String title, boolean inLibrary){
    collection.put(title, inLibrary);
    System.out.println(title + "has been added to the collection!");
  }
  
  /**
   * method to remove a title from a collection
   * @param title book title to remove
   * @return title of book that was removed
   */
  public String removeTitle(String title){
    if (collection.contains(title)){
      collection.remove(title);
      System.out.println("You have removed " + title + " from your collection!");
      return title;
    } else {
      throw new RuntimeException("You cannot remove " + title + " from the collection, it doesn't exist in here!");
    }
  }

  /**
   * method for checking out a title from collection, if title is available and exists in the collection
   * @param title title of book to checkout
   */
  public void checkOut(String title){
    if(this.containsTitle(title)){
      if (this.isAvailable(title)){
        collection.replace (title, collection.get(title), false);
        System.out.println("You have checked out the book "+ title);
      } else {
        System.out.println(title + " is currently not available to check out");
      }
    } else {
      throw new RuntimeException("Sorry, this title is currently not available to check out");
    }
  }

  /**
   * method for returning a book title, if it was initially in the library
   * @param title title of book to return
   */
  public void returnBook(String title){
    if (this.containsTitle (title)){
      collection.replace(title, collection.get(title), true);
      System.out.println(title + " has been successfully returned");
    } else {
      throw new RuntimeException(title + " is not in " + this.getName() + ", perhaps you borrowed it from another place?");
    }
  }

  // prints out the entire collection in an easy-to-read way (including checkout status)
  public void printCollection(){
    System.out.println("The Magical Book Collection");
    for (String title : collection.keySet()){
      boolean available = collection.get(title);
      String status;
      if (available){
        status = "Available";
      } else {
        status = "Checked out/Not available";
      }
      System.out.printf(title, status);
    }
  }

  /**
   * Allows going to the different floors depending on if the building has an elevator or not.
   */
  public void goToFloor(int floorNum){
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
  }
  if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
  }
  if (!this.hasElevator){
    throw new RuntimeException("This building has no elevator. Please use the stairs, sorry about the inconvinience!");
  }
  System.out.println("You are now on floor #" + floorNum + " of " + this.name);
  this.activeFloor = floorNum;
  }


  /**
   * Display the different options available at the library that the user can interact with.
   */
  public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor()\n + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + printCollection()");
  }

  // public static void main(String[] args) {
  //     Library library = new Library ("Brook Library", "1 Elm Street", 3);
  //     System.out.println(library);
  //     library.addTitle("Rawr");
  //     library.checkOut("Rawr");
  //   }
  
  }