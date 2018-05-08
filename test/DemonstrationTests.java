// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12@student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DemonstrationTests {

    @Test
    public void PlayerPropertiesCorrect() {

        Player Crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player Pompey = new Player("Pompey", "Federation of Sol", "Red");

        assertTrue(Crassus.getName() == "Crassus" && Crassus.getRace() == "The Emirates of Hacan" && Crassus
                .getColor() == "Blue");
        assertTrue(Pompey.getName() == "Pompey" && Pompey.getRace() == "Federation of Sol" && Pompey.
                getColor() == "Red");

    }

    @Test
    public void ShipPropertiesCorrect() {

        Player Crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player Pompey = new Player("Pompey", "Federation of Sol", "Red");

        // Crassus Ships initialised
        ShipDestroyer CrassusDestroyer = new ShipDestroyer(Crassus);
        ShipDreadnought CrassusDreadnoughtOne = new ShipDreadnought(Crassus);
        ShipDreadnought CrassusDreadnoughtTwo = new ShipDreadnought(Crassus);

        // Pompey ships initialised
        ShipCruiser PompeyCruiserOne = new ShipCruiser(Pompey);
        ShipCruiser PompeyCruiserTwo = new ShipCruiser(Pompey);
        ShipCarrier PompeyCarrier = new ShipCarrier(Pompey);

        // All ship properties (including ownership attributed in the constructor) have already been tested in
        // ShipTests.java, so we may settle for testing that each of the six ships are ships of the proper type.
        assertTrue(CrassusDestroyer instanceof ShipDestroyer &&
                CrassusDreadnoughtOne instanceof ShipDreadnought &&
                CrassusDreadnoughtTwo instanceof ShipDreadnought &&
                PompeyCruiserOne instanceof ShipCruiser &&
                PompeyCruiserTwo instanceof ShipCruiser &&
                PompeyCarrier instanceof ShipCarrier);

    }

    @Test
    public void DoSystemsHaveProperPlanets() {

        // Building seven planets
        Planet MecatolRex = new Planet("Mecatol Rex", 0);
        Planet VegaMinor = new Planet("Vega Minor", 2);
        Planet VegaMajor = new Planet("Vega Major", 3);
        Planet Industrex = new Planet("Industrex", 6);
        Planet RigelI = new Planet("Rigel I", 4);
        Planet RigelII = new Planet("Rigel II", 5);
        Planet Mirage = new Planet("Mirage", 1);

        // Building ArrayLists to put planets in
        ArrayList<Planet> CenterPlanets = new ArrayList<Planet>();
        ArrayList<Planet> NorthPlanets = new ArrayList<Planet>();
        ArrayList<Planet> NorthEastPlanets = new ArrayList<Planet>();
        ArrayList<Planet> SouthEastPlanets = new ArrayList<Planet>();
        ArrayList<Planet> SouthPlanets = new ArrayList<Planet>();
        ArrayList<Planet> SouthWestPlanets = new ArrayList<Planet>();
        ArrayList<Planet> NorthWestPlanets = new ArrayList<Planet>();

        // Adding planets to relevant arraylists
        CenterPlanets.add(MecatolRex);
        NorthPlanets.add(VegaMajor);
        NorthPlanets.add(VegaMinor);
        SouthEastPlanets.add(Industrex);
        SouthPlanets.add(RigelI);
        SouthPlanets.add(RigelII);
        NorthWestPlanets.add(Mirage);

        // Building the seven systems as specified
        SolarSystem CenterSystem = new SolarSystem("Center System", CenterPlanets, null);
        SolarSystem NorthSystem = new SolarSystem("North System", NorthPlanets, null);
        SolarSystem NorthEastSystem = new SolarSystem("North East System", NorthEastPlanets, null);
        SolarSystem SouthEastSystem = new SolarSystem("South East System", SouthEastPlanets, null);
        SolarSystem SouthSystem = new SolarSystem("South System", SouthPlanets, null);
        SolarSystem SouthWestSystem = new SolarSystem("South West System", SouthWestPlanets, null);
        SolarSystem NorthWestSystem = new SolarSystem("North West System", NorthWestPlanets, null);


        // Test that each system has proper number of planets
        assertTrue(CenterSystem.getPlanets().size() == 1 &&
                NorthSystem.getPlanets().size() == 2 &&
                NorthEastSystem.getPlanets().size() == 0 &&
                SouthEastSystem.getPlanets().size() == 1 &&
                SouthSystem.getPlanets().size() == 2 &&
                SouthWestSystem.getPlanets().size() == 0 &&
                NorthWestSystem.getPlanets().size() == 1);

        // Test that each system has the expected planets
        assertTrue(CenterSystem.getPlanets().get(0) == MecatolRex &&
                NorthSystem.getPlanets().get(0) == VegaMajor &&
                NorthSystem.getPlanets().get(1) == VegaMinor &&
                SouthEastSystem.getPlanets().get(0) == Industrex &&
                SouthSystem.getPlanets().get(0) == RigelI &&
                SouthSystem.getPlanets().get(1) == RigelII &&
                NorthWestSystem.getPlanets().get(0) == Mirage);

        // The above two tests guarantee that only the specified planets are contained in a given system.
    }

    @Test
    public void AreShipsInProperSystems() {

        // We test that ships are where they need to be

        // Players initialised
        Player Crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player Pompey = new Player("Pompey", "Federation of Sol", "Red");

        // Crassus Ships initialised
        ShipDestroyer CrassusDestroyer = new ShipDestroyer(Crassus);
        ShipDreadnought CrassusDreadnoughtOne = new ShipDreadnought(Crassus);
        ShipDreadnought CrassusDreadnoughtTwo = new ShipDreadnought(Crassus);

        // Pompey ships initialised
        ShipCruiser PompeyCruiserOne = new ShipCruiser(Pompey);
        ShipCruiser PompeyCruiserTwo = new ShipCruiser(Pompey);
        ShipCarrier PompeyCarrier = new ShipCarrier(Pompey);

        // Planet lists initialised
        ArrayList<Planet> CenterPlanets = new ArrayList<Planet>();
        ArrayList<Planet> NorthPlanets = new ArrayList<Planet>();
        ArrayList<Planet> NorthEastPlanets = new ArrayList<Planet>();
        ArrayList<Planet> SouthEastPlanets = new ArrayList<Planet>();
        ArrayList<Planet> SouthPlanets = new ArrayList<Planet>();
        ArrayList<Planet> SouthWestPlanets = new ArrayList<Planet>();
        ArrayList<Planet> NorthWestPlanets = new ArrayList<Planet>();

        // Initialising ship lists
        ArrayList<ShipUnits> CenterShips = new ArrayList<ShipUnits>();
        ArrayList<ShipUnits> NorthShips = new ArrayList<ShipUnits>();
        ArrayList<ShipUnits> NorthEastShips = new ArrayList<ShipUnits>();
        ArrayList<ShipUnits> SouthEastShips = new ArrayList<ShipUnits>();
        ArrayList<ShipUnits> SouthShips = new ArrayList<ShipUnits>();
        ArrayList<ShipUnits> SouthWestShips = new ArrayList<ShipUnits>();
        ArrayList<ShipUnits> NorthWestShips = new ArrayList<ShipUnits>();

        // Building systems first before adding ships with .AddShip() method
        SolarSystem CenterSystem = new SolarSystem("Center System", CenterPlanets, CenterShips);
        SolarSystem NorthSystem = new SolarSystem("North System", NorthPlanets, NorthShips);
        SolarSystem NorthEastSystem = new SolarSystem("North East System", NorthEastPlanets, NorthEastShips);
        SolarSystem SouthEastSystem = new SolarSystem("South East System", SouthEastPlanets, SouthEastShips);
        SolarSystem SouthSystem = new SolarSystem("South System", SouthPlanets, SouthShips);
        SolarSystem SouthWestSystem = new SolarSystem("South West System", SouthWestPlanets, SouthWestShips);
        SolarSystem NorthWestSystem = new SolarSystem("North West System", NorthWestPlanets, NorthWestShips);

        // Adding ships to proper systems
        CenterSystem.AddShip(CrassusDestroyer);
        CenterSystem.AddShip(CrassusDreadnoughtOne);
        CenterSystem.AddShip(CrassusDreadnoughtTwo);
        NorthSystem.AddShip(PompeyCarrier);
        NorthSystem.AddShip(PompeyCruiserOne);
        NorthSystem.AddShip(PompeyCruiserTwo);

        // Test that each system has proper number of planets
        assertTrue(CenterSystem.getShips().size() == 3 && NorthSystem.getShips().size() == 3);

        // Test that each system has the expected Ships
        assertTrue(CenterSystem.getShips().get(0) == CrassusDestroyer &&
                CenterSystem.getShips().get(1) == CrassusDreadnoughtOne &&
                CenterSystem.getShips().get(2) == CrassusDreadnoughtTwo &&
                NorthSystem.getShips().get(0) == PompeyCarrier &&
                NorthSystem.getShips().get(1) == PompeyCruiserOne &&
                NorthSystem.getShips().get(2) == PompeyCruiserTwo);

        // The above two tests guarantee that only the specified specified ships are contained in a given system.
        // We have not tested whether other systems contain ships. This is possible, but we choose to
        // disregard the eventuality.

    }

    // Having manually checked our implementation each step of the way, we are now ready to write the smallest test
    // input with the most important assertion to test:
    @Test
    public void IsGalaxyBuilt() {
        Galaxy TestGalaxy = Demonstration.ProblemSeven();

        assertTrue(TestGalaxy instanceof Galaxy);
        assertTrue(TestGalaxy.getContainedShips().size() == 6); // Correct number of ships included
        assertTrue(TestGalaxy.getContainedPlanets().size() == 7); // Ditto for planets

    }

}

