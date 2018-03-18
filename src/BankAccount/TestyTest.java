package BankAccount;

public class TestyTest {

    public static void main(String[] args) {

        BankAccount MinKonto = new BankAccount(-5, "Frederik Kjemtrup");

        MinKonto.withdraw(320);
        System.out.println(MinKonto.getBalance());

    }
}
