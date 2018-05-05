package TwilightImperium;


import java.util.ArrayList;

public class Demonstration {

    public static Galaxy ProblemSeven() {

        // Players initialised
        Player Crassus = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player Pompey = new Player("Pompey", "Federation of Sol", "Red");

        // Planets initialised
        Planet MecatolRex = new Planet("Mecatol Rex", 0);
        Planet VegaMinor = new Planet("Vega Minor", 2);
        Planet VegaMajor = new Planet("Vega Major", 3);
        Planet Industrex = new Planet("Industrex", 6);
        Planet RigelI = new Planet("Rigel I", 4);
        Planet RigelII = new Planet("Rigel II", 5);
        Planet Mirage = new Planet("Mirage", 1);

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

        // Adding planets to lists
        CenterPlanets.add(MecatolRex);
        NorthPlanets.add(VegaMajor);
        NorthPlanets.add(VegaMinor);
        SouthEastPlanets.add(Industrex);
        SouthPlanets.add(RigelI);
        SouthPlanets.add(RigelII);
        NorthWestPlanets.add(Mirage);

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

        // Setting up neighbourhoods. CenterSystem has six neighbours, of the remaining six systems, we need only
        // declare two neighbourhood relations for three of them.
        CenterSystem.setNeighbour(NorthSystem, CompassDirections.NORTH);
        CenterSystem.setNeighbour(NorthEastSystem, CompassDirections.NORTHEAST);
        CenterSystem.setNeighbour(SouthEastSystem, CompassDirections.SOUTHEAST);
        CenterSystem.setNeighbour(SouthSystem, CompassDirections.SOUTH);
        CenterSystem.setNeighbour(SouthWestSystem, CompassDirections.SOUTHWEST);
        CenterSystem.setNeighbour(NorthWestSystem, CompassDirections.NORTHWEST);

        NorthSystem.setNeighbour(NorthEastSystem, CompassDirections.SOUTHEAST);
        NorthSystem.setNeighbour(NorthWestSystem, CompassDirections.SOUTHWEST);

        SouthEastSystem.setNeighbour(NorthEastSystem, CompassDirections.NORTH);
        SouthEastSystem.setNeighbour(SouthSystem, CompassDirections.SOUTHWEST);

        SouthWestSystem.setNeighbour(NorthWestSystem, CompassDirections.NORTH);
        SouthWestSystem.setNeighbour(SouthSystem, CompassDirections.SOUTHEAST);

        // Adding Contained Systems to arraylist ContainedSystems before building a galaxy on those systems.
        ArrayList<SolarSystem> ContainedSystems = new ArrayList<SolarSystem>();
        ContainedSystems.add(NorthEastSystem);
        ContainedSystems.add(NorthSystem);
        ContainedSystems.add(NorthWestSystem);
        ContainedSystems.add(SouthWestSystem);
        ContainedSystems.add(SouthSystem);
        ContainedSystems.add(SouthEastSystem);
        ContainedSystems.add(CenterSystem);
        Galaxy DemonstrationGalaxy = new Galaxy(ContainedSystems);

        // At long last, a return statement:
        return DemonstrationGalaxy;

    }
}
