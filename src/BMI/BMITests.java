package BMI;

import org.junit.jupiter.api.Test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;


public class BMITests {

    @Test
    public void testPersonFieldsConfirm() {

        Person Karsten = new Person("Karsten",180,90);

        assertTrue(Karsten.name == "Karsten");
    }

    @Test
    public void testPersonConstructorReturnsCorrectly() {

        Person Benjamin = new Person("Benjamin", 200, 60);

        assertTrue(Benjamin.name == "Benjamin");
        assertTrue(Benjamin.height == 200);
    }

    @Test
    public void testPersonBMICalc(){

        Person Yaro = new Person("Yaroslav",1.82,130);

        assertTrue(Yaro.getBMI() == 130 / pow(1.82,2));
    }

    @Test
    public void testPersonBMICalcAccurate(){

        Person Yaro = new Person("Yaroslav",1.82,130);

        assertFalse(Yaro.getBMI() == 131 / pow(1.82,2));
    }

    @Test
    public void testBMIYaroObese(){

        Person Yaro = new Person("Yaroslav",1.82,130);

        assertTrue(Yaro.BMIClassification() == "Fat fuck");
    }

    @Test
    public void testBMIKurtTwink(){

        Person Kurt = new Person("Kurt", 1.50, 55);

        assertTrue(Kurt.BMIClassification() == "Twinklet spotted");
    }

}
