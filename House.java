/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {
  // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Class Constructor for building a House
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors for house
   * @param hasDiningRoom boolean for whether the house has a Dining Room or not
   * @param hasElevator boolean for whether the house has an Elevator or not
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloading constructor for house with no dining hall or elevator
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors in house
   */
  public House (String name, String address, int nFloors){
    super(name, address, nFloors);
    this.residents = new ArrayList <> ();
    this.hasDiningRoom = false;
    this.hasElevator = false; 
  }

  /**
   * Getter for hasDiningRoom
   * @return result of whether or not the house has a dining room or not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Getter for hasElevator
   * @return true if house has elevator, false if it doesn't
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }

  /**
   * Getter for the number of residents in the house
   * @return the number of residents residing in the house
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Lets user know if the person is a resident of the house
   * @param person person to check if they are in the house
   * @return true/false if the given person is a resident of the house
   */
  public boolean isResident (String person){
    return this.residents.contains(person);
  }

  /**
   * Adds a new resident to the house if they are not in it already.
   * @param name name of new resident
   */
  public void moveIn(String name){
    if (!isResident(name)){
      this.residents.add(name);
      System.out.println("Resident"+ name + " has moved into " + this.getName());
    } else {
      throw new RuntimeException (name + " is already a resident here!");
    }
  }

  /**
   * Overloaded method of moveIn if a resident wants to provide their age, for more detailed record-keeping 
   * @param name name of resident moving into house
   * @param age age of resident moving into house
   */
  public void moveIn(String name, int age){
    if (!isResident(name)){
      this.residents.add(name);
      System.out.println("Resident "+ name + " has moved into this house at the age of " + age);

    } else {
      throw new RuntimeException(name + " is already a resident of this house");
    }
  }
  
  /**
   * remove a resident and return the name of the person
   * @param name name of resident to remove from house 
   * @return name of the resident who has moved out from the house
   */
  public String moveOut(String name){
    if (residents.contains(name)){
      this.residents.remove(name);
      System.out.println(name + "has moved out of " + this.getName());
      return name;
    } else {
      throw new RuntimeException(name + " is not a resident here");
    }
  }

  /**
   * Overrides goToFloor() from parent building class, to account for houses with no elevator and move between floors
   * @param floorNum the floor number the user wants to go to
   */
  public void goToFloor(int floorNum){
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
  }
  if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
  }
  if (!this.hasElevator){
    throw new RuntimeException("this house does not have an elevator. Please use the stairs.");
  }
  System.out.println("You are now on floor #" + floorNum + " of " + this.name);
  this.activeFloor = floorNum;
  }

  /**
   * Overrides the showOptions() from parent building class, gives users options to move in and move out of house.
   */
  public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor()\n + moveIn(name)\n + moveOut(name)");

  }
}