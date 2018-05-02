// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12student.aau.dk
// Student Nr: 99055

package test;

import TwilightImperium.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    void PlayerConstructorConfirms() {
        Player ConstructorTest = new Player("Lars", "Jyde", "Bleg");

        assertEquals(ConstructorTest.color, "Bleg"); // field "color" chosen for test WLOG
    }


    @Test
    void PlayerGetterConfirms() {
        Player GetterTest = new Player("Lars", "Jyde", "Bleg");

        assertEquals(GetterTest.getName(), "Lars");
        // Realistically possible to test every single field individually, but seems superfluous
    }

    // Now testing more complex methods:
    @Test
    void PlayerMethodEqualsConfirms() {
        Player EqualsTest = new Player("Lars", "Jyde", "Bleg");
        Player EqualsTestComparison = new Player("Lars", "Jyde", "Bleg");

        assertTrue(EqualsTest.equals(EqualsTestComparison));
    }

    @Test
    void PlayerMethodEqualsFailsByRaceField() {
        Player EqualsTest = new Player("Lars", "Jyde", "Bleg");
        Player EqualsTestComparison = new Player("Lars", "Sjællænder", "Bleg");

        assertFalse(EqualsTest.equals(EqualsTestComparison));
        // Can confirm that this.race made .equals() return 'false' due to test PlayerMethodEqualsConfirms passing
    }

    @Test
    void PlayerMethodEqualsFailsByNullPointer() {
        Player EqualsTest = new Player("Lars", "Jyde", "Bleg");
        Object EqualsTestComparison = null;

        assertFalse(EqualsTest.equals(EqualsTestComparison));
    }

    @Test
    void PlayerMethodHashCodeConfirms() {
        Player HashTest= new Player("Lars", "Jyde", "Bleg");
        Player HashTestComparison = new Player("Lars", "Jyde", "Bleg");

        assertTrue(HashTest.hashCode() == HashTest.hashCode());

    }

    @Test
    void PlayerMethodHashCodeFails() {
        Player HashTest= new Player("Lars", "Jyde", "Solbrændt");
        Player HashTestComparison = new Player("Lars", "Jyde", "Bleg");

        assertFalse(HashTest.hashCode() == HashTestComparison.hashCode());

    }

    @Test
    void PlayerMethodToStringConfirms() {
        Player toStringTest = new Player("Lars", "Jyde", "Bleg");

        assertEquals(toStringTest.toString(), "Player{name='Lars', race='Jyde', color='Bleg'}");

    }

    @Test
    void PlayerMethodToStringFailsByCapitalization() {
        Player toStringTest = new Player("Lars", "Jyde", "Bleg");

        assertFalse(toStringTest.toString() == "Player{name='lars', race='Jyde', color='Bleg'}");
        // Hard writing meaningful unit test when any exchanged or moved comma, brace, capital letter, or letter will
        // make the assertion false. For reference, the lower-case L in 'lars' made this fail.

    }

}
