package TwilightImperium;

public class ShipCarrier implements ShipUnits { // Project description said to extend the interface, but interfaces
// implement, while classes extend

    public int ResourceCost;
    public int CombatValue;
    public int MovSpeed;
    public int Capacity;
    public Player Owner;

    public ShipCarrier(Player owner) {
        ResourceCost = 3;
        CombatValue = 9;
        MovSpeed = 1;
        Capacity = 6;
        Owner = owner;
    }

    // Specifying actions of methods extended from interface

    public int getResourceCost(){
        return this.ResourceCost;
    }

    public int getCombatValue(){
        return this.CombatValue;
    }

    public int getMovSpeed(){
        return this.MovSpeed;
    }

    public int getCapacity(){
        return this.Capacity;
    }

    public Player BelongsToPlayer(){
        return this.Owner;
    }

}
