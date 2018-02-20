package EmploymentRelations;

public class Employee extends Person{

    String title;
    int salary;

    public Employee(int age, String name, String title, int salary) {
        super(age, name);
        this.title = title;
        this.salary = salary;
    }
}
