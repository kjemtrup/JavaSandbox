package BankAccount;

public class BankAccount {

    // Fields

        private double balance;
        private String owner;

    // Constructor

        public BankAccount(double balance, String owner) {
            this.balance = balance;
            if(balance <= 0){
                String CreationCondition = "Du skal have penge for at oprette en konto.";
                throw new InsufficientFundsException(CreationCondition); // Throws exception if balance starts off negative
            }
            this.owner = owner;
        }


    // Methods

        // Getters
        public double getBalance(){
            return this.balance;
        }

        public String getOwner(){
            return this.owner;
        }

        // Withdraw
        public double withdraw(int i){
            if(balance - i <= 0){
                String overdraft = "Beløbet overstiger kontoens saldo.";
                throw new InsufficientFundsException(overdraft);
            }
            return balance = balance - i;
        }

        // Deposit
        public double deposit(int i) {
            return balance = balance + i;
        }

}
