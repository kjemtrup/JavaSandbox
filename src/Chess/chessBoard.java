package Chess;

import java.util.*;

public class chessBoard {

    // Set up an 8x8 array
    int board[][] = new int[8][8];

    List<chessPiece> whitePawns = new ArrayList<chessPiece>();
    List<chessPiece> blackPawns = new ArrayList<chessPiece>();

    // Using for-loop, set up 16 pawns
    public void setupPawns(){
        for(int i = 1; i <= 16; i++){
            if(i < 9){
                whitePawns.add(new chessPiece("White","Pawn", i,2));
            }
            else{
                blackPawns.add(new chessPiece("Black","Pawn", i-8,7));
            }
        }
    }

    // Manually set up two Queens
        chessPiece whiteQueen = new chessPiece("White","Queen", 5, 1);
        chessPiece blackQueen = new chessPiece("Black","Queen", 6, 8);
    // Manually set up two Kings

    // Manually set up four Rooks

    // Manually set up four Bishops

    // Manually set up four Knights

    // Create move-methods for each class: if(piece.militaryrank == "Pawn") then only three moves are possible. True
    // only when this is attempted. Move (update position) only if move is true.

    // Create boolean isChecked(int x, int y) to return True if piece at x,y is King and is checked.
}
