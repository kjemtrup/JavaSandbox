// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12@student.aau.dk
// Student Nr: 99055

package TwilightImperium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SolarSystem {

    // Fields
    String name;
    ArrayList<Planet> Planets = new ArrayList<Planet>();
    ArrayList<ShipUnits> Ships = new ArrayList<ShipUnits>();
    Map<CompassDirections, SolarSystem> Neighbours = new HashMap<>();
    // Six separate fields declared as type SolarSystem but not initialised inside the class to avoid logical
    // contradictions.
    //SolarSystem NeighbourNorth;
    //SolarSystem NeighbourNorthEast;
    //SolarSystem NeighbourSouthEast;
    //SolarSystem NeighbourSouth;
    //SolarSystem NeighbourSouthWest;
    //SolarSystem NeighbourNorthWest;


    // ArrayList<> chosen instead of array for both fields as they do not require a fixed length to be declared.
    // This does little for the "array" of planets limited to three objects, but allows for an arbitrary number of
    // ships to occupy a given system.

    // Constructors
    public SolarSystem(String name, ArrayList<Planet> planets, ArrayList<ShipUnits> ships) {
        this.name = name;
        this.Planets = planets;
        this.Ships = ships;
    }

    // Get Planets
    public ArrayList<Planet> getPlanets() {
        if (this.Planets.size() > 3) {
            String TooManyPlanetsErrorMsg = "You can't have that many planets in a system.";
            throw new IllegalArgumentException(TooManyPlanetsErrorMsg);
        } else return Planets;
    }

    public void setNeighbour(SolarSystem adjacentsystem, CompassDirections Direction) {

        this.Neighbours.put(Direction, adjacentsystem);

        // I am not sure how to define operational inverses on elements of an enum, other than doing it by cases:
        CompassDirections OppositeDirection = null;
        if (Direction == CompassDirections.NORTH) OppositeDirection = CompassDirections.SOUTH;
        if (Direction == CompassDirections.SOUTH) OppositeDirection = CompassDirections.NORTH;
        if (Direction == CompassDirections.SOUTHEAST) OppositeDirection = CompassDirections.NORTHWEST;
        if (Direction == CompassDirections.SOUTHWEST) OppositeDirection = CompassDirections.NORTHEAST;
        if (Direction == CompassDirections.NORTHWEST) OppositeDirection = CompassDirections.SOUTHEAST;
        if (Direction == CompassDirections.NORTHEAST) OppositeDirection = CompassDirections.SOUTHWEST;
        adjacentsystem.Neighbours.put(OppositeDirection, this); // Enforces reflexive adjacency
    }

    public SolarSystem getNeighbour(CompassDirections Direction) {
        SolarSystem DirectionSystem = Neighbours.get(Direction);
        if (DirectionSystem == null) {
            DirectionSystem = this;
        }
        return DirectionSystem;
    }

    // Retrieves all ships currently in the system
    public ArrayList<ShipUnits> getShips() {
        return Ships;
    }

    // The next two methods just alleviate notation. We can easily add ships to the arraylist Ships using .add(), but
    // defining these methods lets us add or remove ships directly to or from the solar system.
    public ArrayList<ShipUnits> AddShip(ShipUnits EnterShip) {
        Ships.add(EnterShip);
        return Ships;
    }

    public ArrayList<ShipUnits> RemoveShip(int ShipToRemove) {
        Ships.remove(ShipToRemove);
        return Ships;
    }

    public Player SpaceCombat(ArrayList<ShipUnits> InvadingPlayerShips) {

        // Initialising combatant fleets
        ArrayList<ShipUnits> DefenderShips = this.getShips();
        ArrayList<ShipUnits> InvaderShips = InvadingPlayerShips;

        while (DefenderShips.size() != 0 && InvaderShips.size() != 0) {
            // Working out how many hits the invading fleet scores:
            int InvadingHits = 0;
            for (ShipUnits ship : InvaderShips) {
                if (ship.getCombatValue() < D10.getD10()) {
                    InvadingHits++;
                }
            }

            // Working out how many hits the defending fleet scores:
            int DefendingHits = 0;
            for (ShipUnits ship : DefenderShips) {
                if (ship.getCombatValue() < D10.getD10()) {
                    DefendingHits++;
                }
            }

            // Now we can determine casualties:
            for (int InvadingForcesKill = 0; InvadingForcesKill <= InvadingHits; InvadingForcesKill++) { // For each hit, search out
                // the ship in the defending fleet with lowest resource cost, and remove it before incrementing the
                // number of casualties to determine
                int setresourcecosts = 10; // Larger than that of any ship
                int killship = 0; // Chooses first ship

                // The following for loop looks dumb, but if I invoke it on the arraylist using "ShipUnits ship :
                // DefenderShips", I wouldn't have an int to refer to when I go to remove the ship with minimal
                // resourcecost. This is poor design, and is caused by the .RemoveShip() method taking an int as
                // input instead of a ShipUnit object.
                if (DefenderShips.size() > 0) {
                    for (int ShipLooper = 0; ShipLooper <= DefenderShips.size(); ShipLooper++) {
                        if (DefenderShips.get(ShipLooper).getResourceCost() < setresourcecosts) {
                            setresourcecosts = DefenderShips.get(ShipLooper).getResourceCost();
                            killship = ShipLooper;
                        }
                        DefenderShips.remove(killship);
                    }
                }
            }
            System.out.println(DefenderShips.size());

            for (int DefendingKills = 0; DefendingKills <= DefendingHits; DefendingKills++) { // For each hit, search
                // out
                // the ship in the defending fleet with lowest resource cost, and remove it before incrementing the
                // number of casualties to determine
                int setresourcecosts = 10; // Larger than that of any ship
                int killship = 0; // Chooses first ship
                if (InvaderShips.size() > 0) {
                    for (int ShipLooper = 0; ShipLooper <= InvaderShips.size(); ShipLooper++) {
                        if (InvaderShips.get(ShipLooper).getResourceCost() < setresourcecosts) {
                            setresourcecosts = InvaderShips.get(ShipLooper).getResourceCost();
                            killship = ShipLooper;
                        }
                        InvaderShips.remove(killship);
                    }
                }
            }
            System.out.println(InvaderShips.size());
        }

        // Resolving combat by declaring a victor. If no victor exists, we throw an exception.
        if (DefenderShips.size() == 0 && InvaderShips.size() == 0) {
            throw new IllegalArgumentException("Complete annihilation. No survivors.");
        } else if (DefenderShips.size() == 0) {
            return InvaderShips.get(0).BelongsToPlayer();
        } else return DefenderShips.get(0).BelongsToPlayer();


    }

}
