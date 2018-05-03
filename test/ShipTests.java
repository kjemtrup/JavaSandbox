// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ShipTests {

    @Test
    void DestroyerWorks() {
        Player DestroyerWorksPlayer = new Player("Lars", "Jyde", "Red");
        ShipDestroyer MilenniumFalcon = new ShipDestroyer(DestroyerWorksPlayer);

        assertTrue(MilenniumFalcon.getResourceCost() == 1 && MilenniumFalcon.getCombatValue() == 9 &&
                MilenniumFalcon.getMovSpeed() == 2 && MilenniumFalcon.getCapacity() == 0 && MilenniumFalcon
                .BelongsToPlayer() == DestroyerWorksPlayer);
    }

    @Test
    void CruiserWorks() {
        Player CruiserWorksPlayer = new Player("Lars", "Jyde", "Red");
        ShipCruiser MilenniumFalcon = new ShipCruiser(CruiserWorksPlayer);

        assertTrue(MilenniumFalcon.getResourceCost() == 2 && MilenniumFalcon.getCombatValue() == 7 &&
                MilenniumFalcon.getMovSpeed() == 2 && MilenniumFalcon.getCapacity() == 0 && MilenniumFalcon
                .BelongsToPlayer() == CruiserWorksPlayer);
    }

    @Test
    void CarrierWorks() {
        Player CarrierWorksPlayer = new Player("Lars", "Jyde", "Red");
        ShipCarrier MilenniumFalcon = new ShipCarrier(CarrierWorksPlayer);

        assertTrue(MilenniumFalcon.getResourceCost() == 3 && MilenniumFalcon.getCombatValue() == 9 &&
                MilenniumFalcon.getMovSpeed() == 1 && MilenniumFalcon.getCapacity() == 6 && MilenniumFalcon
                .BelongsToPlayer() == CarrierWorksPlayer);
    }

    @Test
    void DreadnoughtWorks() {
        Player DreadnoughtWorksPlayer = new Player("Lars", "Jyde", "Red");
        ShipDreadnought MilenniumFalcon = new ShipDreadnought(DreadnoughtWorksPlayer);

        assertTrue(MilenniumFalcon.getResourceCost() == 5 && MilenniumFalcon.getCombatValue() == 5 &&
                MilenniumFalcon.getMovSpeed() == 1 && MilenniumFalcon.getCapacity() == 0 && MilenniumFalcon
                .BelongsToPlayer() == DreadnoughtWorksPlayer);
    }


}
