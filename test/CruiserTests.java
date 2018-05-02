// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.Player;
import TwilightImperium.ShipCruiser;
import TwilightImperium.ShipDestroyer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CruiserTests {

    @Test
    void CruiserConstructorWorks() {
        Player CruiserConstructorPlayer = new Player("Lars", "Ork", "Blue");
        ShipCruiser MilenniumFoolcon = new ShipCruiser(CruiserConstructorPlayer);

        assertTrue(MilenniumFoolcon.getCombatValue() == 7);
        // Field CombatValue chosen WLOG
    }

    // Construction of ShipCruiser differs from ShipDestroyer only by class name so we won't test BelongsToPlayer or
    // anything else on this unit.
    // Testing each "identical" ship class because their names differ is unnecessarily verbose unless you're writing
    // shuttle guidance systems for Lockheed.

}

