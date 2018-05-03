package TwilightImperium;

public class Planet {

    // Fields
    public String Name;
    public int ResourceProduction;

    public Planet(String name, int resourceProduction) {
        Name = name;
        ResourceProduction = resourceProduction;
    }

    public String getName() {
        return this.Name;
    }

    public int getResourceProduction() {

        if (this.ResourceProduction < 0) {
            String NegativeResourceProductionErrorMsg = "Your planet cannot produce a negative amount of resources.";
            throw new IllegalArgumentException(NegativeResourceProductionErrorMsg); // Might as well use the
            // exception that's already an extension of RunTimeException.java
        }
        if (this.ResourceProduction > 6) {
            String OverflowResourceProductionErrorMsg = "Your planet cannot produce that many resources.";
            throw new IllegalArgumentException(OverflowResourceProductionErrorMsg);
        }
        else return this.ResourceProduction;

        }
    }



