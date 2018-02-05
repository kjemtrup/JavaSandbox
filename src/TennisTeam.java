public class TennisTeam {
    // Fields
    String teamName;
    TennisPlayer Player1;
    TennisPlayer Player2;

    // Constructor
    TennisTeam(){
        teamName = "Decepticons";
        Player1 = new TennisPlayer();
        Player2 = new TennisPlayer();
    }

    // Average age method
    double avgAge(){
        double avgAge = ((double)this.Player1.age + this.Player2.age) / 2;
        return avgAge;
    }

}
