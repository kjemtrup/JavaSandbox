package CircleOverlap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CircleTest {

    @Test
    void testCircleCenter() {
        Circle CirkelTestCentrum = new Circle(new double[]{3, 4}, 3);
        // Created circle center point is equal to double-type coordinates
        assertEquals(3, CirkelTestCentrum.getX());

    }

    @Test
    void testCircleRadius() {
        Circle CirkelTestRadius = new Circle(new double[]{20, 10}, 5);
        assertEquals(5, CirkelTestRadius.getradius());
    }


    @Test
    void testContainsMethodConfirms() {
        Circle Enhedscirkel = new Circle(new double[]{0, 0}, 1);

        assertTrue(Enhedscirkel.contains(new double[]{1, 0}));
    }

    @Test
    void testContainsMethodDenies() {

        Circle Enhedscirkel = new Circle(new double[]{0, 0}, 1);

        assertFalse(Enhedscirkel.contains(new double[]{1, 0.1}));

    }

    @Test
    void testOverlapMethodConfirms() {

        Circle Cirkel1 = new Circle(new double[]{-2, 0}, 2);
        Circle Cirkel2 = new Circle(new double[]{2, 0}, 3);

        assertTrue(Cirkel1.overlaps(Cirkel2));

    }

    @Test
    void testOverlapMethodDenies() {

        Circle Cirkel1 = new Circle(new double[]{-2, 0}, 2);
        Circle Cirkel2 = new Circle(new double[]{2, 0}, 1);

        assertFalse(Cirkel1.overlaps(Cirkel2));
    }

}