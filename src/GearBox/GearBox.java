package GearBox;

public class GearBox {

    // Fields
    int gear;

    public int getGear() {
        return this.gear;
    }

    public int changeGear(int i) {
        if(((this.gear == i + 1) | (this.gear == i - 1)) & ((i<=5) & (-1 <= i))
         ){
        return this.gear = i;
        }
        else if ((this.gear == 1 & i == -1) | (this.gear == -1 & i == 1)) {
            return this.gear = i;
        }
        else{
            throw new IllegalGearChangeException();
        }
    }
}
