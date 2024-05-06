/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Class constructor for building a cafe
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors in cafe
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets amount of sugar packets
     * @param nCreams amount of coffee cream
     * @param nCups amount of coffee cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloading constructor for Cafe, if the supplies have a given amount regardless of which cafe is built.
     * @param name name of Cafe
     * @param address address of cafe
     * @param nFloors number of floors in cafe
     */
    public Cafe(String name, String address){
        super(name, address);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 50;
    }

    /**
     * getter for canSell, check if there are enough ingredients to operate coffee-making
     * @param size size of coffee 
     * @param nSugarPackets amount of sugar packets required 
     * @param nCreams amount of coffee cream needed
     * @return true if coffee can be sold, false if there are not enough ingredients
     */
    private boolean canSell(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && this.nCups > 0){
            return true;
        } else {
            return false;
        }
    }


    /**
     * method to restock the coffee making supplies
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets amount of sugar packets
     * @param nCreams amount of coffee cream
     * @param nCups amount of coffee cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Overloading method for restock(), if the user calls it at any point regardless of if the supplies are running low or not.
     */
    public void restock(){
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 50;
        System.out.println("All Coffee supplies have been restocked, thank you!");
    }

    /**
     * Process for selling coffee, sell if there are enough ingredients, restock if not enough ingredients
     * @param size size of coffee created
     * @param nSugarPackets amount of Sugar packets used
     * @param nCreams amount of coffee cream used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.canSell(size, nSugarPackets, nCreams)){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        } else {
            this.restock(size * 10, nSugarPackets * 10, nCreams * 10, 10);
        }
    }

    /**
     * Overriding method for goToFloor from parent class. User can only stay on first floor of cafe.
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1 && floorNum <= this.nFloors){
            System.out.println("You are only allowed on the first floor of this cafe.");
        }
        this.activeFloor = floorNum;
        }

    /**
     * Overriding showOptions() method from parent class, includes sellCoffee option in Cafe
     */
    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor()\n + sellCoffee()\n + restock()");
    }
    
    // public static void main(String[] args) {
    //     Cafe cafe = new Cafe ("Compass", "10 Elm Street", 2, 50,50,10,10);
    //     System.out.println(cafe);
    //     cafe.showOptions();
    //     cafe.enter();
    //     cafe.goToFloor(2);
    // }
    
}