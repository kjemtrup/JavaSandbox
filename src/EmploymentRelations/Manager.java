package EmploymentRelations;

public class Manager extends Employee {

    int bonus;

    public Manager(int age, String name, String title, int salary, int bonus) {
        super(age, name, title, salary);
        this.bonus = bonus;
    }
}
