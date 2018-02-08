import java.util.Arrays;
import java.util.Random;
import java.math.RoundingMode;
import static java.lang.Math.round;
                        // FOR LATER STUDY: Why doesn't IDE highlight three packages in use?

public class TennisMatch {
    // FIELDS: Exactly two teams, ONLY DECLARE objects, don't create them with an "= new TennisPlayer()" and waste an
    // hour finding the flaw. (Terrible comment, but it's not written for anyone else, and I need to remember)
    TennisTeam Team1;
    TennisTeam Team2;

    // CONSTRUCTOR: Two teams constructed and named after instructor's wishes
    // Might be good to add optional teamnames in the constructor, say TennisMatch("Decepticons", "Autobots")
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
        // Surely there's a shorter way to type out all this crap.
    }

    // METHOD: Finds player with highest wLRatio
    double maxWLRatio(){
        double wLRatioList[]={this.Team1.Player1.wLRatio(), this.Team1.Player2.wLRatio(), this.Team2.Player1.wLRatio(), this.Team2.Player2.wLRatio()};
        Arrays.sort(wLRatioList);
        return wLRatioList[wLRatioList.length-1]; // Sorted array, last entry is maximal
    }

    // METHOD: Finds player with lowest wLRatio
    double minWLRatio(){
        double wLRatioList[]={this.Team1.Player1.wLRatio(), this.Team1.Player2.wLRatio(), this.Team2.Player1.wLRatio(), this.Team2.Player2.wLRatio()};
        Arrays.sort(wLRatioList);
        return wLRatioList[0]; // Sorted array, first entry is minimal
    }

    // METHOD: Simulate match, declare winner, update winloss-records.
    void matchPlayed(){

        // Flip a coin to decide victor
        long coinOutcome = 1 + Math.round(Math.random()); // Surprised there's no package java.util.coin tbh

        // Type declaration and init
        String winner = "";


        if(coinOutcome == 1) {
            winner = "Blue Team";

        // Statistics incremented accordingly
            Team1.Player1.win++;
            Team1.Player2.win++;
            Team2.Player1.loss++;
            Team2.Player2.loss++;
                    // FOR LATER STUDY: Surely there's a better way to handle these indices than manually typing out
                    // four lines like some animal
        }
        else if(coinOutcome == 2){
            winner = "Red Team";

        // Statistics incremented accordingly
            Team2.Player1.win++;
            Team2.Player2.win++;
            Team1.Player1.loss++;
            Team1.Player2.loss++;
        }
        // Print name of winning team.
        System.out.println(winner + " has won the match!");
    }
                        // FOR FUTURE STUDY: Can coinOutcome possibly be anything other than 1 or 2? Round-off errors?
                        // FOR FUTURE STUDY: Maybe build a single-class match simulator in one variable n that
                        // simulates a match through coinflip, prints updated winloss-statistics, and repeats n-1 times.
}
