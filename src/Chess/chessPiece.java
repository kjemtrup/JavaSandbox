package Chess;

import java.awt.geom.Point2D;

public class chessPiece {

    String teamColour;
    String militaryRank;
    // Needs coordinate field
    int x,y;

    public chessPiece(String teamColour, String militaryRank, int x, int y) {
        this.teamColour = teamColour;
        this.militaryRank = militaryRank;
        this.x = x;
        this.y = y;
    }

}
