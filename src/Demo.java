public class Demo {
    public static void main(String[] args) {

    TennisPlayer Federer = new TennisPlayer();
    TennisPlayer Nadal = new TennisPlayer();
    TennisPlayer Serena = new TennisPlayer();
    TennisPlayer Venus = new TennisPlayer();

    // Inits for Federer
    Federer.win = 45;
    Federer.loss = 17;
    Federer.age = 37;
    Federer.firstName = "Roger";
    System.out.println(Federer.wLRatio());

    // Inits for Nadal
    Nadal.win = 42;
    Nadal.loss = 40;
    Nadal.age = 32;
    Nadal.firstName = "Rafael";
    System.out.println(Nadal.wLRatio());

    // Inits for Serena
    Serena.win = 70;
    Serena.loss = 5;
    Serena.age = 36;
    Serena.lastName = "Williams";
    System.out.println(Serena.wLRatio());

    // Inits for Venus
    Venus.win = 15;
    Venus.loss = 5;
    Venus.age = 39;
    Venus.lastName = "Williams";
    System.out.println(Venus.wLRatio());

    // All is called and declared. Ready to print and check some shit out?

    TennisTeam Guys = new TennisTeam();
        Guys.Player1 = Federer;
        Guys.Player2 = Nadal;


    TennisTeam Girls = new TennisTeam();
        Girls.Player1 = Serena;
        Girls.Player2 = Venus;

        System.out.println("Average age of guys is " + Guys.avgAge());
        System.out.println("Average age of girls is " + Girls.avgAge());

    // Method returns as expected, so everything was correctly declared, init'ed and computed.

    TennisMatch Legends = new TennisMatch();
    Legends.Team1 = Girls;
    Legends.Team2 = Guys;

    System.out.println("Average age of all players is " + Legends.avgAge());
    // avgAge returns a double, so we're happy with this method

    Legends.matchPlayed();

        System.out.println(Federer.win);
        System.out.println(Federer.loss);
        System.out.println(Serena.win);
        System.out.println(Serena.loss);

    // Upon running matchPlayed(), all winloss stats change. But every run of that method re-initialises their values
        // which is shit. Oh well.

    // Only missing: maxWLRatio of match.
        System.out.println(Legends.maxWLRatio());
    // Huh. Updated because of runtime update of winloss-statistics on every player involved.
    // tl;dr IT WORKS, HALLELUJAH


    }
}
