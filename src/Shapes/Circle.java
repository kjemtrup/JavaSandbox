package Shapes;

public class Circle implements Shapes{

    double radius;
    int edges = 0;

    public Circle(double radius, int edges) {
        this.radius = radius;
        this.edges = edges;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }

    public double getCircumference(){
        return this.radius * 2 * Math.PI;
    }

    public int getNumEdges(){
        return 0;
    }

}
