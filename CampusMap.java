import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Ziskind House", "61 Elm Street Northampton, MA 01063", 3, true, true));
        myMap.addBuilding(new House("Cutter House", "60 Elm Street, Northampton MA 01063", 3, true, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "Neilson Library, Northampton MA 01063"));
        myMap.addBuilding(new Building("Campus Center", "5 Elm Street, Northampton MA", 2));
        myMap.addBuilding(new House("Chase House", "3 Elm Street, Northampton MA 01063", 3, true, true));
        myMap.addBuilding(new House("Albright House", "7 Bedford Terrace, Northampton MA", 3, false, true));
        myMap.addBuilding(new Building("Wright Hall", "1 Chapin Way, Northampton MA 01063", 2));
        myMap.addBuilding(new Building("College Hall", "10 Elm Street, Northampton MA 01063", 2));
        myMap.addBuilding(new Library("Neilson Library", "1 Neilson Dr., Northampton MA 01063", 4, true));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "1 Chapin Way"));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street, Northampton MA 01063", 4, true));



        System.out.println(myMap);
    }
    
}
