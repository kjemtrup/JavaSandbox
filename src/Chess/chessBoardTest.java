package Chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chessBoardTest {

    @Test public void queensRightPlace() throws Exception{
        chessPiece whiteQueen = new chessPiece("White","Queen", 5, 1);
        chessPiece blackQueen = new chessPiece("Black","Queen", 6, 8);

        assertEquals(whiteQueen.y, 1);
    }

    @Test public void howManyPawns() throws Exception{
        chessBoard testBoard = new chessBoard();
        assertEquals(chessBoard.setupPawns());
    }
    // Add comment to testfails. Basically assertOPTION(clause, maybeclausetwo, "what do we expect here");

    // Any time a method is invoked, ALL tests should run to verify that nothing illegal has taken place, and
    // that the game is not yet over
    // Great scot, this is already implemented! @Test, @BeforeEach, @AfterEach and so on and so forth. Delicious.

    // Build test to verify correct number of pieces on board after every movemethod invoked?

    // If game over, one must win and another must lose. assertTrue(incrementWhite XOR incrementBlack) &&
    // assertTrue(decreaseWhite XOR decreaseBlack)

    // Syntax for every test:
    // @Test

    // Can run a method before each, before all, after each, or after all tests have run.
    // We want to run movemethods AFTER ALL movetests and gameNotOver-test have passed.
    // Grossly inefficient to check that the pawn hasn't done anything illegal when we're trying to move the queen,
    // but I can't see a good way to if-clause it other than hardcoding, and that would be building tests to fit the
    // code instead of coding the fit the testing. We're trying to be test-driven.

    // Test whether piece has legal name. assertEquals(name, pawn or queen or king or ... and so on)


}