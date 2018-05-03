package test;

import TwilightImperium.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GalaxyTests {

    @Test
    public void IsGalaxyInstanceOfArrayListOfSystems(){
        // Initialising three planets
        Planet Mars = new Planet("Mars",3);
        Planet Earth = new Planet("Earth",6);
        Planet Uranus = new Planet("Uranus",4);

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars","Jyde","Blue");
        Player Carlos = new Player("Carlos","Sjællænder","Red");

        // Initialising four different ship types belonging to two distinct players
        ShipDestroyer BlueDestroyerLars = new ShipDestroyer(Lars);
        ShipCruiser BlueCruiserLars = new ShipCruiser(Lars);
        ShipCarrier RedCarrierCarlos = new ShipCarrier(Carlos);
        ShipDreadnought RedDreadnoughtCarlos = new ShipDreadnought(Carlos);

        // Building an arraylist of all four ships
        ArrayList<ShipUnits> SystemShips = new ArrayList<ShipUnits>();
        SystemShips.add(BlueDestroyerLars);
        SystemShips.add(BlueCruiserLars);
        SystemShips.add(RedDreadnoughtCarlos);
        SystemShips.add(RedCarrierCarlos);

        // Building arraylists is a little dense compared to regular arrays
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);

        // Initialising two solar systems
        SolarSystem AlphaCentauri = new SolarSystem("Alpha Centauri", SystemPlanets, SystemShips);
        SolarSystem OurSolarSystem = new SolarSystem("Our Solar System", SystemPlanets, SystemShips);

        // ArrayList of the two defined systems
        ArrayList<SolarSystem> ContainedSystems = new ArrayList<SolarSystem>();
        ContainedSystems.add(AlphaCentauri);
        ContainedSystems.add(OurSolarSystem);

        Galaxy TheOneFromStarWars = new Galaxy(ContainedSystems);

        // Expect to be able to pluck a solar system out of the list, and expect the return type of
        // .getContainedSystem() to be an arraylist.
        assertTrue(TheOneFromStarWars.getContainedSystems().get(0) instanceof SolarSystem);
        assertTrue(TheOneFromStarWars.getContainedSystems() instanceof ArrayList);
    }

    @Test
    public void DoesGetContainedShipsReturnAShip(){
        // Initialising three planets
        Planet Mars = new Planet("Mars",3);
        Planet Earth = new Planet("Earth",6);
        Planet Uranus = new Planet("Uranus",4);

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars","Jyde","Blue");
        Player Carlos = new Player("Carlos","Sjællænder","Red");

        // Initialising four different ship types belonging to two distinct players
        ShipDestroyer BlueDestroyerLars = new ShipDestroyer(Lars);
        ShipCruiser BlueCruiserLars = new ShipCruiser(Lars);
        ShipCarrier RedCarrierCarlos = new ShipCarrier(Carlos);
        ShipDreadnought RedDreadnoughtCarlos = new ShipDreadnought(Carlos);

        // Building an arraylist of all four ships
        ArrayList<ShipUnits> SystemShips = new ArrayList<ShipUnits>();
        SystemShips.add(BlueDestroyerLars);
        SystemShips.add(BlueCruiserLars);
        SystemShips.add(RedDreadnoughtCarlos);
        SystemShips.add(RedCarrierCarlos);

        // Building arraylists is a little dense compared to regular arrays
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);

        // Initialising two solar systems
        SolarSystem AlphaCentauri = new SolarSystem("Alpha Centauri", SystemPlanets, SystemShips);
        SolarSystem OurSolarSystem = new SolarSystem("Our Solar System", SystemPlanets, SystemShips);

        // ArrayList of the two defined systems
        ArrayList<SolarSystem> ContainedSystems = new ArrayList<SolarSystem>();
        ContainedSystems.add(AlphaCentauri);
        ContainedSystems.add(OurSolarSystem);

        Galaxy TheOneFromStarWars = new Galaxy(ContainedSystems);

        // Expect to be able to pluck a ShipUnit out of returned output from method .getContainedShips()
        assertTrue(TheOneFromStarWars.getContainedShips().get(0) instanceof ShipUnits);

        // Expect to find the right ship and to correctly identify that ship's owner
        assertTrue(TheOneFromStarWars.getContainedShips().get(3).BelongsToPlayer() == Carlos);
        // Wildly inaccurate test, since we didn't implement an automated test generator and thus have to rely on
        // manually generated expected objects.
        // This manual input is limited by plain boredom on the author's part, making Carlos the correct
        // test value with an essentially fair 50% probability. Guesswork might have done just as well.
    }

    @Test
    public void DoesGetContainedPlanetsReturnPlanets(){
        // Initialising three planets
        Planet Mars = new Planet("Mars",3);
        Planet Earth = new Planet("Earth",6);
        Planet Uranus = new Planet("Uranus",4);

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars","Jyde","Blue");
        Player Carlos = new Player("Carlos","Sjællænder","Red");

        // Initialising four different ship types belonging to two distinct players
        ShipDestroyer BlueDestroyerLars = new ShipDestroyer(Lars);
        ShipCruiser BlueCruiserLars = new ShipCruiser(Lars);
        ShipCarrier RedCarrierCarlos = new ShipCarrier(Carlos);
        ShipDreadnought RedDreadnoughtCarlos = new ShipDreadnought(Carlos);

        // Building an arraylist of all four ships
        ArrayList<ShipUnits> SystemShips = new ArrayList<ShipUnits>();
        SystemShips.add(BlueDestroyerLars);
        SystemShips.add(BlueCruiserLars);
        SystemShips.add(RedDreadnoughtCarlos);
        SystemShips.add(RedCarrierCarlos);

        // Building arraylists is a little dense compared to regular arrays
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);

        // Initialising two solar systems
        SolarSystem AlphaCentauri = new SolarSystem("Alpha Centauri", SystemPlanets, SystemShips);
        SolarSystem OurSolarSystem = new SolarSystem("Our Solar System", SystemPlanets, SystemShips);

        // ArrayList of the two defined systems
        ArrayList<SolarSystem> ContainedSystems = new ArrayList<SolarSystem>();
        ContainedSystems.add(AlphaCentauri);
        ContainedSystems.add(OurSolarSystem);

        Galaxy TheOneFromStarWars = new Galaxy(ContainedSystems);

        // Expect to be able to pluck a ShipUnit out of returned output from method .getContainedShips()
        assertTrue(TheOneFromStarWars.getContainedPlanets().get(0) instanceof Planet);
    }

    @Test
    public void DoesGetContainedPlanetsReturnAllPlanets(){
        // Initialising three planets
        Planet Mars = new Planet("Mars",3);
        Planet Earth = new Planet("Earth",6);
        Planet Uranus = new Planet("Uranus",4);

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars","Jyde","Blue");
        Player Carlos = new Player("Carlos","Sjællænder","Red");

        // Initialising four different ship types belonging to two distinct players
        ShipDestroyer BlueDestroyerLars = new ShipDestroyer(Lars);
        ShipCruiser BlueCruiserLars = new ShipCruiser(Lars);
        ShipCarrier RedCarrierCarlos = new ShipCarrier(Carlos);
        ShipDreadnought RedDreadnoughtCarlos = new ShipDreadnought(Carlos);

        // Building an arraylist of all four ships
        ArrayList<ShipUnits> SystemShips = new ArrayList<ShipUnits>();
        SystemShips.add(BlueDestroyerLars);
        SystemShips.add(BlueCruiserLars);
        SystemShips.add(RedDreadnoughtCarlos);
        SystemShips.add(RedCarrierCarlos);

        // Building arraylists is a little dense compared to regular arrays
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);

        // Initialising two solar systems
        SolarSystem AlphaCentauri = new SolarSystem("Alpha Centauri", SystemPlanets, SystemShips);
        SolarSystem OurSolarSystem = new SolarSystem("Our Solar System", SystemPlanets, SystemShips);

        // ArrayList of the two defined systems
        ArrayList<SolarSystem> ContainedSystems = new ArrayList<SolarSystem>();
        ContainedSystems.add(AlphaCentauri);
        ContainedSystems.add(OurSolarSystem);

        Galaxy TheOneFromStarWars = new Galaxy(ContainedSystems);

        // Expect to be able to pluck a ShipUnit out of returned output from method .getContainedShips()
        assertTrue(TheOneFromStarWars.getContainedPlanets().size() == 6);
    }


}
