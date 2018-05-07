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
        }
        else return Planets;
    }

    public void setNeighbour(SolarSystem adjacentsystem, CompassDirections Direction){

        this.Neighbours.put(Direction, adjacentsystem);

        // I am not sure how to define operational inverses on elements of an enum, other than doing it by cases:
        CompassDirections OppositeDirection = null;
        if(Direction == CompassDirections.NORTH) OppositeDirection = CompassDirections.SOUTH;
        if(Direction == CompassDirections.SOUTH) OppositeDirection = CompassDirections.NORTH;
        if(Direction == CompassDirections.SOUTHEAST) OppositeDirection = CompassDirections.NORTHWEST;
        if(Direction == CompassDirections.SOUTHWEST) OppositeDirection = CompassDirections.NORTHEAST;
        if(Direction == CompassDirections.NORTHWEST) OppositeDirection = CompassDirections.SOUTHEAST;
        if(Direction == CompassDirections.NORTHEAST) OppositeDirection = CompassDirections.SOUTHWEST;
        adjacentsystem.Neighbours.put(OppositeDirection, this); // Enforces reflexive adjacency
    }

    public SolarSystem getNeighbour(CompassDirections Direction){
        SolarSystem DirectionSystem = Neighbours.get(Direction);
        if (DirectionSystem == null){
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


}
