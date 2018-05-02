package TwilightImperium;

public class ShipCruiser implements ShipUnits {

    public int ResourceCost;
    public int CombatValue;
    public int MovSpeed;
    public int Capacity;
    public Player Owner;

    public ShipCruiser(Player owner) {
        ResourceCost = 2;
        CombatValue = 7;
        MovSpeed = 2;
        Capacity = 0;
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
