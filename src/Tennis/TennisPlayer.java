public class TennisPlayer{
    // Basic fields
        public int age;
        public String firstName;
        String lastName;
        int win;
        int loss;

    // Optional - how is optionality denoted?
        public String sponsor;


    // Win-loss ratio method (no input arguments because method relies on "this.field" calls.)
        double wLRatio(){
            if(loss != 0) {
                return (double)this.win / this.loss;
            }
            else return -1;
                            // FOR FUTURE STUDY: Read up on exceptions, OR just manually build a subroutine to
                            // maxWLRatio in TennisMatch that first checks if wLRatio is -1 and compares any player
                            // objects for which true. Biggest win counter must have best ratio.
        }

    // Constructor using default estimates
        TennisPlayer(){
            age = 20;
            firstName = "John";
            lastName = "Smith";
            win = 1;
            loss = 1;
            sponsor = "This player does not have a sponsor!";
        }
                    // FOR FUTURE STUDY: You _know_ there's more to constructors than default values. Remember to
                    // make the most of them.
}

// For future reference: Maybe best to have fields, immediately followed by constructor, THEN methods?
// FOR FUTURE STUDY: Check "Clean Code". That guy might have an opinion on style...


