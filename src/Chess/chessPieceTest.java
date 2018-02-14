package Chess;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class chessPieceTest {

    // Testing constructor. Would like to test every possible combination.
    @Test
    public void constructorTest() throws Exception{
        chessPiece whitePawn = new chessPiece("White", "Pawn",4, 5);
        assertTrue(whitePawn.teamColour == ("White") | whitePawn.militaryRank == "Pawn" & whitePawn.x == 5);
    }


    // FOR FUTURE STUDY: Can I include somewhere that if teamColour != "White" or "Black" to make some noise and exit?
}