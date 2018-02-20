package EmploymentRelations;

public class Demonstration {

    public static void main(String[] args) {

        Manager Dave = new Manager(50, "Dave", "Account Manager",5000, 50);

        System.out.println(Dave.title + Dave.name + "earns a bonus of " + Dave.bonus + " in addition to his salary of" +
                " " + Dave.salary);
    }
}
