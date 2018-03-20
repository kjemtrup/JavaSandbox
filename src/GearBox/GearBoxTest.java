package GearBox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GearBoxTest {

    @Test
    public void getGearConfirms(){

        GearBox Gearbox = new GearBox();

        Gearbox.gear = 5;

        assertTrue(Gearbox.getGear() == 5);
        System.out.println("Turns out, you can get the gear that your gearbox is in.");
    }

    @Test
    public void changeGearWorksWithoutRestrictionsOnGearChange(){

        GearBox Gearbox = new GearBox();

        Gearbox.gear = 5;

        assertTrue(Gearbox.changeGear(4) == 4);
        System.out.println("Well done, you can change the gear of your gearbox.");
    }

    @Test
    public void changeGearRestrictsToDomainConfirms(){

        GearBox Box = new GearBox();

        Box.gear = 4;

        assertTrue(Box.changeGear(5) == 5);
        System.out.println("So you can still change gears... Well done. Retard.");
    }

    @Test
    public void changeGearMethodRestrictsToOneGearStepByThrowing(){
       try{
           GearBox Box = new GearBox(); // Object instantiated
           Box.gear = 4; // Gear set so that only 3 and 5 available
           Box.changeGear(2); // Attempt a gear change that exceeds step length of one (4 - 2 = 2)
       }
       catch (IllegalGearChangeException WrongGearChanged){
           System.out.println("Learn to drive, you jackass! ~ Your gearChange step length condition works!");
       }

    }

    @Test
    public void changeGearMethodRestrictsToDomainByThrowing(){
        try{
            GearBox Box = new GearBox(); // Object instantiated
            Box.gear = 4; // Gear set so that only 3 and 5 available
            Box.changeGear(9); // Attempt a gear change outside of gear domain
        }
        catch (IllegalGearChangeException WrongGearChanged){
            System.out.println("This isn't Fast and the Furious. ~ Your gearChange domain restriction works!");
        }
    }

    @Test
    public void changeGearReverseOnlyWorksFromFirstConfirm(){

            GearBox Box = new GearBox(); // Object instantiated
            Box.gear = 1; // Get in first gear
            Box.changeGear(-1); // Attempt to reverse, except working fine

            assertTrue(Box.getGear() == -1);
        System.out.println("You manage to reverse from being in first gear.");

        }


    @Test
    public void changeGearReverseOnlyWorksFromFirstDeny(){
        try{
            GearBox Box = new GearBox(); // Object instantiated
            Box.gear = 2; // Gear set so that only 3 and 5 available
            Box.changeGear(-1); // Attempt a wrong gear change
        }
        catch (IllegalGearChangeException WrongGearChanged){
            System.out.println("No, George, that's not how it works.");
        }
    }



}
