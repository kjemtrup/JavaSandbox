package TwilightImperium;

import java.util.ArrayList;

public class SolarSystem {

    // Fields
    String name;
    ArrayList<Planet> Planets = new ArrayList<Planet>();
    ArrayList<ShipUnits> Ships = new ArrayList<ShipUnits>();

    // Six separate fields declared as type SolarSystem but not initialised inside the class to avoid logical
    // contradictions.
    SolarSystem NeighbourNorth;
    SolarSystem NeighbourNorthEast;
    SolarSystem NeighbourSouthEast;
    SolarSystem NeighbourSouth;
    SolarSystem NeighbourSouthWest;
    SolarSystem NeighbourNorthWest;

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

    // Implementation of the next twelve methods could definitely be handled more smoothly using enumerators. I write
    // this after spending 5 hours trying to implement the hex-grid of systems in class Galaxy.java as a 6-regular line
    // graph, so for now, this is the simplest way to implement neighbourhood lookups. Regrettably verbose.

    // Get/Set North Neighbour
    public SolarSystem getNeighbourNorth() {
        return this.NeighbourNorth;
    }
    public void setNeighbourNorth(SolarSystem NeighbourNorth) {
        this.NeighbourNorth = NeighbourNorth;
    }

    // Get/Set NorthEast Neighbour
    public SolarSystem getNeighbourNorthEast() {
        return this.NeighbourNorthEast;
    }
    public void setNeighbourNorthEast(SolarSystem NeighbourNorthEast) {
        this.NeighbourNorthEast = NeighbourNorthEast;
    }

    // Get/Set SouthEast Neighbour
    public SolarSystem getNeighbourSouthEast() {
        return this.NeighbourSouthEast;
    }
    public void setNeighbourSouthEast(SolarSystem NeighbourSouthEast) {
        this.NeighbourSouthEast = NeighbourSouthEast;
    }

    // Get/Set South Neighbour
    public SolarSystem getNeighbourSouth() {
        return this.NeighbourSouth;
    }
    public void setNeighbourSouth(SolarSystem NeighbourSouth) {
        this.NeighbourSouth = NeighbourSouth;
    }

    // Get/Set SouthWest Neighbour
    public SolarSystem getNeighbourSouthWest() {
        return this.NeighbourSouthWest;
    }
    public void setNeighbourSouthWest(SolarSystem NeighbourSouthWest) {
        this.NeighbourSouthWest = NeighbourSouthWest;
    }

    // Get/Set NorthWest Neighbour
    public SolarSystem getNeighbourNorthWest() {
        return this.NeighbourNorthWest;
    }
    public void setNeighbourNorthWest(SolarSystem NeighbourNorthWest) {
        this.NeighbourNorthWest= NeighbourNorthWest;
    }

    // Retrieves all ships currently in the system
    public ArrayList<ShipUnits> getShips() {
        return Ships;
    }

    // The next two methods just alleviate notation. We can easily add ships to the arraylist using .add(), but
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
