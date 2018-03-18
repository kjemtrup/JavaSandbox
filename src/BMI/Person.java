package BMI;

public class Person {

    String name;
    double height;
    double weight;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public double getBMI() {
        double BMI = this.weight / Math.pow(this.height, 2);
        return BMI;
    }

    public String BMIClassification(){
        if (this.getBMI() > 30){
            return "Fat fuck";
        }
        else if (this.getBMI() < 30 && this.getBMI() > 25){
            return "Thick, solid, tight";
        }
        else if (this.getBMI() < 25){
            return "Twinklet spotted";
        }
        else return "What are you even?";
    }

}
