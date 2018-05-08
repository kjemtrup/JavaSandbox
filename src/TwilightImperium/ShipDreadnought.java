// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12@student.aau.dk
// Student Nr: 99055

package TwilightImperium;

public class ShipDreadnought implements ShipUnits { // Project description said to extend the interface, but interfaces
// implement, while classes extend

    public int ResourceCost;
    public int CombatValue;
    public int MovSpeed;
    public int Capacity;
    public Player Owner;

    public ShipDreadnought(Player owner) {
        ResourceCost = 5;
        CombatValue = 5;
        MovSpeed = 1;
        Capacity = 0;
        Owner = owner;
    }

    // Specifying actions of methods extended from interface

    public int getResourceCost() {
        return this.ResourceCost;
    }

    public int getCombatValue() {
        return this.CombatValue;
    }

    public int getMovSpeed() {
        return this.MovSpeed;
    }

    public int getCapacity() {
        return this.Capacity;
    }

    public Player BelongsToPlayer() {
        return this.Owner;
    }

}
