// Name: Frederik V. Kjemtrup
// Student Email: fkjemt12@student.aau.dk
// Student Nr: 99055

package TwilightImperium;

import java.util.Objects;

public class Player {

    // Fields
    public String name;
    public String race;
    public String color;

    // Constructor
    public Player(String name, String race, String color) {
        this.name = name;
        this.race = race;
        this.color = color;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object compareplayer) {
        if (this == compareplayer) return true;
        if (compareplayer == null || !(compareplayer instanceof Player)) return false;
        Player playercast = (Player) compareplayer;
        return this.getName() == playercast.getName() && this.getColor() == playercast.getColor() &&
                this.getRace() == playercast.getRace();

    }

    // Identification method hashCode
    public int hashCode(Player PlayerHash) {
        return Objects.hash(this.getName(), this.getColor(), this.getRace());

    }

    // Export method toString
    @Override
    public String toString() {

        return "Player{" + "name='" + this.getName() + '\'' + ", race='" + this.getRace() + '\'' + ", color='" +
                this.getColor() + '\'' + '}';
    }

}