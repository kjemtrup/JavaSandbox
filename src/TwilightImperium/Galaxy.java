package TwilightImperium;

import java.util.ArrayList;

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

    // To implement the Neighbourhood Structure for output of .getContainedSystems(), we import tools for simple
    // graph definition and manipulation. A hexagonal grid like the one described in the project can be thought of
    // as a line graph of degree at most 6. Two regions can be either adjacent or not, implying that we can settle
    // for a simple, undirected graph.


}
