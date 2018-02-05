public class TennisPlayer{
    // Basic fields
        public int age;
        public String firstName;
        String lastName;
        int win;
        int loss;

    // Optional
        public String sponsor;


    // Win-loss ratio method (no input arguments because method relies on this.field calls.)
        double wLRatio(){
            if(loss != 0) {
                return (double)this.win / this.loss;
            }
            else return -1;
        }

    // Constructor using default wild-ass estimates
        TennisPlayer(){
            age = 20;
            firstName = "John";
            lastName = "Smith";
            win = 1;
            loss = 1;
            sponsor = "This player does not have a sponsor!";
        }
}

// God damn this is so cool
// For future reference: Maybe best to have class declaration, fields, immediately followed by constructor, THEN methods?


