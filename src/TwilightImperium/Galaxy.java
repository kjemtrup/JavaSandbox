// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12student.aau.dk
// Student Nr: 99055

package TwilightImperium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    // .getPlayers()
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> AllPlayersDuplicates = new ArrayList<Player>();
        for (ShipUnits ShipWhoseOwnerMustAppend : this.getContainedShips()) {
            AllPlayersDuplicates.add(ShipWhoseOwnerMustAppend.BelongsToPlayer());
        }
        // After looping, we convert the arraylist of many, many duplicates to a set, thus eliminating duplicates:
        return AllPlayersDuplicates;
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
    public ArrayList<ShipUnits> FindSortShips(Player AllShipsPlayer) {

        ArrayList<ShipUnits> PlayerShips = this.getContainedShips();

        for (ShipUnits checkship : PlayerShips) {
            if (checkship.BelongsToPlayer() == AllShipsPlayer) {
                PlayerShips.add(checkship);
            }
        }

        // Now to sort... Omitted due to time restrictions. I was so gung-ho about sorting using a lambda
        // expression that I think I stared myself blind, and now I can't even make sense of a regular
        // SortedMap<Integer, ShipUnits> collection.

        return PlayerShips;

    }

    // Method to print
    public void PrintsPlayerControlsToFile() throws IOException {

        // Initialising filename, builds file, and instantiates a new bufferedwriter object
        String fileName = "PlayerControlsSystem";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append("Here is a listing of the players and the systems under their control:");
        bufferedWriter.newLine();

        // Here's where the magic happens:
        Set<Player> AllPlayers = new HashSet<>(this.getPlayers()); // Fetches all players
        for (Player controlPlayer : AllPlayers) { // For each player, begin by writing their name
            bufferedWriter.append(controlPlayer.getColor() + " Player " + "(" + controlPlayer.getRace() + ")");
            bufferedWriter.newLine();
            for (SolarSystem controlsystem : this.getContainedSystems()) { // For each system in the galaxy
                ArrayList<ShipUnits> systemships = controlsystem.getShips(); // Fetch ships
                if (systemships.size() == 0) break; // You should only proceed if there are ships in the system
                boolean ControlledByPlayerFlag = true; // Set a control flag to true.
                for (ShipUnits compareship : systemships) {
                    // If any ship in the system belongs to another player than the owner of the first ship, we set
                    // flag to false and repeat the "for" looping:
                    if (compareship.BelongsToPlayer() != null && controlPlayer != compareship
                            .BelongsToPlayer()) {
                        ControlledByPlayerFlag = false;
                    }
                }
                // I am aware that this is a cubic-time function, and therefore a rubbish implementation, but it gets
                // the job done, and the problem size is restricted to the product of number of systems, number of
                // planets in systems, and number of ships in each system, which is again at most 3 times the product
                // of the number of ships and the number of systems in the game.
                // We might have the time or resources to implement something more clever if we were not working with
                // "baby" Twilight Imperium, but for now, this will have to do.


                if (ControlledByPlayerFlag) { // If system is under control by one player
                    // Converts planets to set, i.e. no planetary duplicates:
                    Set<Planet> PlanetsUnderControl = new HashSet<>(controlsystem.getPlanets());
                    // Append every such planet in this system to the output file
                    for (Planet AppendPlanet : PlanetsUnderControl) {
                        bufferedWriter.append(AppendPlanet.getName());
                        bufferedWriter.newLine();
                    }
                }
            }
            bufferedWriter.newLine(); // Separating player's controlled planets by a line
        }
        bufferedWriter.close();
    }
}