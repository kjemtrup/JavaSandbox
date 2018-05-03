package TwilightImperium;

import java.util.ArrayList;

public class SolarSystem {


    // Fields
    String name;
    ArrayList<Planet> Planets = new ArrayList<Planet>();
    ArrayList<ShipUnits> Ships = new ArrayList<ShipUnits>();

    // ArrayList<> chosen instead of array for both fields as they do not require a fixed length to be declared.
    // This does little for the "array" of planets limited to three objects, but allows for an arbitrary number of
    // ships to occupy a given system.

    public SolarSystem(String name, ArrayList<Planet> planets, ArrayList<ShipUnits> ships) {
        name = name;
        Planets = planets;
        Ships = ships;
    }

    // Getters
    public ArrayList<Planet> getPlanets() {
        if (this.Planets.size() > 3) {
            String TooManyPlanetsErrorMsg = "You can't have that many planets in a system.";
            throw new IllegalArgumentException(TooManyPlanetsErrorMsg);
        }
        else return Planets;
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
