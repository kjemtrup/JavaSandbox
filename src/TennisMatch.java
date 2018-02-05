import java.util.Arrays;
import java.util.Random;
import java.math.RoundingMode;
import static java.lang.Math.round;

public class TennisMatch {
    // FIELDS: Two teams, ONLY DECLARE objects, don't create them.
    TennisTeam Team1;
    TennisTeam Team2;

    // CONSTRUCTOR: Two teams constructed and named after instructor's wishes
    TennisMatch(){
        TennisTeam Team1 = new TennisTeam();
        TennisTeam Team2 = new TennisTeam();
        Team1.teamName = "Blue Team";
        Team2.teamName = "Red Team";
    }

    // METHOD: average age of all players
    double avgAge() {
        double avgAge = ((double)this.Team1.Player1.age + this.Team1.Player2.age + this.Team2.Player1.age + this
                .Team2.Player2.age) / 4;
        return avgAge;
        // Surely there's a shorter way to type out all this shite.
    }

    // METHOD: find player with highest winlossratio
    double maxWLRatio(){
        double wLRatioList[]={this.Team1.Player1.wLRatio(), this.Team1.Player2.wLRatio(), this.Team2.Player1.wLRatio(), this.Team2.Player2.wLRatio()};
        Arrays.sort(wLRatioList);
        return wLRatioList[wLRatioList.length-1];
    }

    // METHOD: declare one team the winner
    void matchPlayed(){
        long coinOutcome = 1 + Math.round(Math.random());
        String winner = "";
        if(coinOutcome == 1) {
            winner = "Blue Team";

            Team1.Player1.win++;
            Team1.Player2.win++;
            Team2.Player1.loss++;
            Team2.Player2.loss++;
        }
        else if(coinOutcome == 2){
            winner = "Red Team";

            Team2.Player1.win++;
            Team2.Player2.win++;
            Team1.Player1.loss++;
            Team1.Player2.loss++;
        }
        System.out.println(winner + " has won the match!");
    }

}
