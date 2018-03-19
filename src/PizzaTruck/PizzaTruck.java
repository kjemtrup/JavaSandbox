package PizzaTruck;

public class PizzaTruck implements ItalianKitchen, Vehicle {

    String make;
    String model;
    int year;
    int numberOfWheels;

    public PizzaTruck(String make, String model, int year, int numberOfWheels) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public Pizza makePizza(){
        Pizza somePizza = new Pizza();
        return somePizza;
    }

    public String getModel() {
        return this.model;
    }

    public String getMake() {
        return this.make;
    }
}
