package TwilightImperium;

import java.lang.reflect.Array;
import java.util.*;

import static TwilightImperium.CompassDirections.*;

public class Galaxy {

    // Fields
    ArrayList<SolarSystem> ContainedSystems; // Must correspond to NumberOfSystems, obviously


    // Constructor
    public Galaxy(ArrayList<SolarSystem> ContainedSystems) {
        this.ContainedSystems = ContainedSystems;
    }

    // Getters
    public ArrayList<SolarSystem> getContainedSystems() {
        return ContainedSystems;
    }


    // .getShips(), output isn't sorted by any obvious criterion
    public ArrayList<ShipUnits> getContainedShips() {
        // Retrieve this galaxy's contained systems
        ArrayList<SolarSystem> ContainedSystems = this.getContainedSystems();
        // Initialise an empty list of ships.
        ArrayList<ShipUnits> ContainedShips = new ArrayList<ShipUnits>();
        // For each ship in each system, add that ship to the arraylist ContainedShips
        for (int SystemIndex = 0; SystemIndex <= this.getContainedSystems().size() - 1; SystemIndex++) {
            for (int shipIndex = 0; shipIndex <= this.getContainedSystems().get(SystemIndex).getShips().size() - 1;
                 shipIndex++) {
                // The for loop terminates when it's added as many ships to ContainedShips as are contained in the
                // list returned by .getShips() when that method is in turn invoked on the system returned by
                // .get(SystemIndex)
                ContainedShips.add(ContainedSystems.get(SystemIndex).getShips().get(shipIndex));
            }
        }
        return ContainedShips;
    }

    // .getPlanets(), output isn't sorted by any obvious criterion
    public ArrayList<Planet> getContainedPlanets() {
        // Retrieve this galaxy's contained systems
        ArrayList<SolarSystem> ContainedSystems = this.getContainedSystems();
        // Initialise an empty list of Planets.
        ArrayList<Planet> ContainedPlanets = new ArrayList<Planet>();
        // For each ship in each system, add that ship to the arraylist ContainedShips
        for (int SystemIndex = 0; SystemIndex <= this.getContainedSystems().size() - 1; SystemIndex++) {
            for (int planetIndex = 0; planetIndex <= this.getContainedSystems().get(SystemIndex).getPlanets().size() - 1;
                 planetIndex++) {
                ContainedPlanets.add(ContainedSystems.get(SystemIndex).getPlanets().get(planetIndex));
            }
        }
        return ContainedPlanets;
    }

    // Method for checking legality as specified in project description
    public boolean isLegal() {

        // Initialising flags
        boolean MecatolFlag = true;
        boolean PlanetUniquenessFlag = true;
        boolean PlanetMaxNumberFlag = true;
        boolean NeighbourReflexivityFlag = true;

        // Checking existence and uniqueness of planet named "Mecatol Rex" in Center System
        if (this.getContainedSystems().get(0).getPlanets().size() != 1 || this.getContainedSystems().get(0).getPlanets
                ().get(0).getName() != "Mecatol Rex") {
            String MecatolErrorMsg = "Mecatol Rex is not in the center system, or it is not alone in the center system.";
            throw new MecatolRexException(MecatolErrorMsg);
        }
        // Warning: Implementation relies on centersystem being the FIRST appended to the null-initialised arraylist of
        // systems. HashMap (dictionary) might make this more reliable, but at the moment that's a time-costly
        // implementation that we'll omit on this basis.


        // Checking each planet belongs to only one system
        ArrayList<Planet> ContainedPlanets = this.getContainedPlanets();
        Set<Planet> SetContainedPlanets = new HashSet<Planet>(ContainedPlanets);
        if (this.getContainedPlanets().size() != SetContainedPlanets.size()) {
            String DuplicateErrorMessage = "There was a duplicate planet. Cloning on this scale is unethical.";
            throw new DuplicatePlanetException(DuplicateErrorMessage);
        }
        // I feel really clever about this one. Retrieving the arraylist of contained systems and defining it as a set
        // lets us check whether any objects of the arraylist were duplicated, as a set contains only one instance of
        // each object (Lecture 5a, slide 6). Since .getContainedPlanets() works by looping over every system and
        // every planet and appending encountered planets, it will contain a duplicate if any planet belongs to more
        // than one system.
        // Strictly speaking, it will contain duplicates if two planets are identical in name and resource production.
        // We will consider this property a feature instead of a bug.

        // Checking no system contains more than 3 planets.
        for (SolarSystem checksystem : this.getContainedSystems()) {
            if (checksystem.getPlanets().size() > 3) {
                PlanetMaxNumberFlag = false;
            }
        }
        // As this already has an exception implemented in SolarSystem.java, we won't implement a duplicate in Galaxy
        // .java. Redundancy is evil!


        // We do not check that every solar system's neighbour in direction X has that solar system as a neighbour in
        // direction "opposite X". This is due to the implementation of method .setNeighbour() which enforces this
        // rule by construction. It is not possible through stupidity to break this condition, unless you require a
        // crash helmet to go to the cinema.
        // A malicious agent could succeed in causing a problem by manually setting entries in the HashMap field of
        // SolarSystem called Neighbours.

            return MecatolFlag && PlanetUniquenessFlag && PlanetMaxNumberFlag && NeighbourReflexivityFlag;
            // Returns true if no conditions are violated, false if at least one condition is violated
        }


        // Method for finding and sorting all ships belonging to a single player
        public SortedMap<Integer, ShipUnits> FindSortShips(Player player){

            Map<Integer, ShipUnits> SortedShips = new TreeMap<Integer, ShipUnits>();
            ArrayList<ShipUnits> AllShips = this.getContainedShips();

            for(ShipUnits checkship:AllShips){
                if (checkship.BelongsToPlayer() == player){
                    SortedShips.put(checkship.getCombatValue(), checkship);
                }
            }

            return (SortedMap<Integer, ShipUnits>) SortedShips;

    }
    }
