// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.Player;
import TwilightImperium.ShipDestroyer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DestroyerTests {

        @Test
        void DestroyerConstructorWorks() {
            Player DestroyerConstructorPlayer = new Player("Lars", "Eldar", "Blue");
            ShipDestroyer MilenniumFoolcon = new ShipDestroyer(DestroyerConstructorPlayer);

            assertTrue(MilenniumFoolcon.getMovSpeed() == 2);
            // Field MovSpeed chosen WLOG
        }

        @Test
        void DestroyerConstructorDoesNotMessUpReturnTypeOfOwner() {
            Player DestroyerConstructorPlayer = new Player("Lars", "Eldar", "Blue");
            ShipDestroyer MilenniumFoolcon = new ShipDestroyer(DestroyerConstructorPlayer);

            assertTrue(MilenniumFoolcon.BelongsToPlayer() == DestroyerConstructorPlayer);

    }

}

