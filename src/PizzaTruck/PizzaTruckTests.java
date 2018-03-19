package PizzaTruck;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaTruckTests {

    @Test
    public void isPizzaLargePepperoni(){

        Pizza largepep = new Pizza();
        largepep.isFamilySize = true;
        largepep.Pepperoni = true;

        assertTrue(largepep.isFamilySize == true);
        System.out.println("You can hardcode a large pepperoni pizza.");
    }

    @Test
    public void pizzaTruckConstructorWorks(){

        PizzaTruck JoesPies = new PizzaTruck("Ford","T",1934,4);

        assertTrue(JoesPies.getModel() == "T" && JoesPies.getMake() == "Ford");

        System.out.println("Constructor works. Duh.");
    }

    @Test
    public void pizzaTruckMakePizzaWorks(){

        PizzaTruck JoesPies = new PizzaTruck("Ford","T",1934,4);

        assertTrue(JoesPies.makePizza() instanceof Pizza);

        System.out.println("PizzaTruck class method makePizza() returns an instance of class Pizza");

    }

    @Test
    public void TruckMadePizzaCanBePepperoni(){

        PizzaTruck JoesPies = new PizzaTruck("Ford","T",1934,4);
        Pizza JoesPizza = JoesPies.makePizza();
        JoesPizza.Pepperoni = true;

        assertTrue(JoesPizza.getPepperoni() == true);

        System.out.println("PizzaTruck's makePizza method returns a Pizza, whose Pepperoni val can be true.");
    }

}
