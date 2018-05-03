// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlanetTests {

    @Test
    void PlanetConstructorWorks() {
        Planet Uranus = new Planet("Uranus", 5);

        assertEquals(Uranus.getResourceProduction(), 5);
    }

    @Test
    void PlanetGetNameWorks() {
        Planet Uranus = new Planet("Uranus", 5);

        assertEquals(Uranus.getName(), "Uranus");
    }

    @Test
    void PlanetExceptionThrownByResourceOverflow() {
        Planet Uranus = new Planet("Uranus", 7);

        IllegalArgumentException OverflowException = null; // Initialises a null exception to remain as such unless
        // exception is thrown
            try {
                Uranus.getResourceProduction();
            } catch (IllegalArgumentException e) {
                OverflowException = e;
            }
            assertTrue(OverflowException != null); // Test passes only when some exception is thrown
            assertEquals("Your planet cannot produce that many resources.", OverflowException.getMessage()); // Test passes
        // only when correct exception message is returned.
        }

    @Test
    void PlanetExceptionThrownByNegativeResources() {
        Planet Uranus = new Planet("Uranus", -2);

        IllegalArgumentException NegativeException = null;
        try {
            Uranus.getResourceProduction();
        } catch (IllegalArgumentException e) {
            NegativeException = e;
        }
        assertTrue(NegativeException != null);
        assertEquals("Your planet cannot produce a negative amount of resources.", NegativeException.getMessage());
    }

    @Test
    void PlanetExceptionsDontAlwaysThrow() {
        Planet Uranus = new Planet("Uranus", 4);

        IllegalArgumentException NegativeException = null;
        try {
            Uranus.getResourceProduction();
        } catch (IllegalArgumentException e) {
            NegativeException = e;
        }
        assertTrue(NegativeException == null);
        assertEquals(Uranus.getResourceProduction(), 4);
    }

}
