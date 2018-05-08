// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12@student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SolarSystemTests {

    @Test
    public void SolarSystemGettersWork() {
        // Initialising three planets
        Planet Mars = new Planet("Mars", 3);
        Planet Earth = new Planet("Earth", 6);
        Planet Uranus = new Planet("Uranus", 4);

        // Building arraylists is a little dense compared to regular arrays
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);

        ArrayList<ShipUnits> SystemShips = null; // No reason to complicate testing with an arraylist of ships
        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", SystemPlanets, SystemShips);

        assertTrue(AlphaCentauri.getPlanets().get(0).getName() == "Mars");
    }


    @Test
    public void SolarSystemGettersWorkWithLessThanThreePlanets() {
        // Initialising only two planets
        Planet Mars = new Planet("Mars", 3);
        Planet Earth = null;
        Planet Uranus = new Planet("Uranus", 4);

        // Building arraylists is a little dense compared to regular arrays
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);

        ArrayList<ShipUnits> SystemShips = null; // No reason to complicate testing with an arraylist of ships

        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", SystemPlanets, SystemShips);

        assertTrue(AlphaCentauri.getPlanets().get(0).getName() == "Mars");
    }

    @Test
    public void SolarSystemPlanetOverflowExceptionThrown() {
        // Initialising four planets
        Planet Mars = new Planet("Mars", 3);
        Planet Earth = new Planet("Earth", 6);
        Planet Uranus = new Planet("Uranus", 4);
        Planet Jupiter = new Planet("Jupiter", 2);

        // Building an arraylist of the same four planets
        ArrayList<Planet> SystemPlanets = new ArrayList<Planet>();
        SystemPlanets.add(Mars);
        SystemPlanets.add(Earth);
        SystemPlanets.add(Uranus);
        SystemPlanets.add(Jupiter);

        // Not bothering with testing any property of SystemShips in this test
        ArrayList<ShipUnits> SystemShips = null;
        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", SystemPlanets, SystemShips);

        // Try-catch block for exception throwing
        IllegalArgumentException PlanetOverflowException = null;
        try {
            AlphaCentauri.getPlanets();
        } catch (IllegalArgumentException e) {
            PlanetOverflowException = e;
        }
        // Testing both that exception was thrown and caught with correct error message
        assertTrue(PlanetOverflowException != null);
        assertEquals("You can't have that many planets in a system.", PlanetOverflowException.getMessage());
    }

    @Test
    public void ShipFieldsAccessibleBySolarSystemClass() {
        // Not concerned with planets in this test
        ArrayList<Planet> SystemPlanets = null;

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars", "Jyde", "Blue");
        Player Carlos = new Player("Carlos", "Sjællænder", "Red");

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

        // Standard notation for instantiating the system with specified arraylists of planets and ships.
        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", SystemPlanets, SystemShips);

        // Expect that the third ship in the arraylist (a dreadnought) had combat value 5, belongs to Carlos, and has
        // movement speed 1
        assertTrue(AlphaCentauri.getShips().get(2).getCombatValue() == 5 && AlphaCentauri.getShips().get(2)
                .BelongsToPlayer() == Carlos && AlphaCentauri.getShips().get(2).getMovSpeed() == 1);

    }

    @Test
    public void AddingShipToSystemLeavesPreviousOccupantsIntact() {
        // Not concerned with planets in this test
        ArrayList<Planet> SystemPlanets = null;

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars", "Jyde", "Blue");
        Player Carlos = new Player("Carlos", "Sjællænder", "Red");

        // Initialising four different ship types belonging to two distinct players
        ShipDestroyer BlueDestroyerLars = new ShipDestroyer(Lars);
        ShipCarrier RedCarrierCarlos = new ShipCarrier(Carlos);


        // Building an arraylist of all four ships
        ArrayList<ShipUnits> SystemShips = new ArrayList<ShipUnits>();
        SystemShips.add(BlueDestroyerLars);

        // Standard notation for instantiating the system with specified arraylists of planets and ships.
        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", SystemPlanets, SystemShips);

        // Calling the .AddShip() method on our SolarSystem
        AlphaCentauri.AddShip(RedCarrierCarlos);

        // Expect to see both ships now in their right place in the "Ships" list belonging to object AlphaCentauri
        assertTrue(AlphaCentauri.getShips().get(0) == BlueDestroyerLars && AlphaCentauri.getShips().get(1) ==
                RedCarrierCarlos);

    }

    @Test
    public void RemovingShipsFromSystemWorks() {
        // Not concerned with planets in this test
        ArrayList<Planet> SystemPlanets = null;

        // Initialising two players to whom the four ships belong
        Player Lars = new Player("Lars", "Jyde", "Blue");
        Player Carlos = new Player("Carlos", "Sjællænder", "Red");

        // Initialising four different ship types belonging to two distinct players
        ShipDestroyer BlueDestroyerLars = new ShipDestroyer(Lars);
        ShipCarrier RedCarrierCarlos = new ShipCarrier(Carlos);


        // Building an arraylist of all four ships
        ArrayList<ShipUnits> SystemShips = new ArrayList<ShipUnits>();

        // Standard notation for instantiating the system with specified arraylists of planets and ships.
        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", SystemPlanets, SystemShips);

        // Calling the .AddShip() method on our SolarSystem
        AlphaCentauri.AddShip(BlueDestroyerLars);
        AlphaCentauri.AddShip(RedCarrierCarlos);

        // Calling the .Removeship() method on our SolarSystem
        AlphaCentauri.RemoveShip(0);

        // Expect to see both ships now in their right place in the "Ships" list belonging to object AlphaCentauri
        assertTrue(AlphaCentauri.getShips().get(0) == RedCarrierCarlos);

    }

    // Test whether adjacency hashmap properly implemented
    @Test
    public void DoesDirectionWork() {
        // Initialising four planets
        Planet Mars = new Planet("Mars", 3);
        Planet Earth = new Planet("Earth", 6);
        Planet Uranus = new Planet("Uranus", 4);
        Planet Jupiter = new Planet("Jupiter", 2);

        // Building an arraylist of the same four planets
        ArrayList<Planet> AlphaCentauriPlanets = new ArrayList<Planet>();
        ArrayList<Planet> OurSolarSystemPlanets = new ArrayList<Planet>();
        AlphaCentauriPlanets.add(Mars);
        AlphaCentauriPlanets.add(Earth);
        OurSolarSystemPlanets.add(Uranus);
        OurSolarSystemPlanets.add(Jupiter);

        // Initialising solar systems, two of them
        SolarSystem AlphaCentauri = new SolarSystem("AlphaCentauri", AlphaCentauriPlanets, null);
        SolarSystem OurSolarSystem = new SolarSystem("Our Solar System", OurSolarSystemPlanets, null);

        // We need to setup two systems with two planets each, and test different adjacency relations on those
        AlphaCentauri.setNeighbour(OurSolarSystem, CompassDirections.SOUTH);

        // We set one neighbour relation, and check that both itself and the other direction checks out:
        assertTrue(AlphaCentauri.getNeighbour(CompassDirections.SOUTH) == OurSolarSystem);
        assertTrue(OurSolarSystem.getNeighbour(CompassDirections.NORTH) == AlphaCentauri);
    }

    @Test
    public void DoesCombatWorkExceptionWork() {
        Galaxy TestGalaxy = Demonstration.ProblemSeven();
        Player Pompey = TestGalaxy.getPlayers().get(1);
        ShipDreadnought PompeyShip = new ShipDreadnought(Pompey);
        ArrayList<ShipUnits> PompeyFleet = new ArrayList<>();
        PompeyFleet.add(PompeyShip);

        TestGalaxy.getContainedSystems().get(0).SpaceCombat(PompeyFleet);

        // This test occasionally throw an exception when both fleets are defeated in the same round of hits. I do
        // not yet know how to assert that the output is either Blue Player, Red Player, or that the method
        // .SpaceCombat() throws an exception. I can catch exceptions, but, so far, only when I know they're coming.
    }
}
