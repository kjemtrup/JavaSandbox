package Shapes;

public class Triangle implements Shapes{

    int edges;
    double[] edgeLength = new double[3];
    double[] heightLength = new double[3];

    public Triangle(int edges, double[] edgeLength, double[] heightLength) {
        this.edges = edges;
        this.edgeLength = edgeLength;
        this.heightLength = heightLength;
    }

    public double getArea(){
        return 0.5 * this.edgeLength[0] * this.heightLength[0];
    }

    public double getCircumference(){
        return this.edgeLength[0] + this.edgeLength[1] + this.edgeLength[2];
    }

    public int getNumEdges(){
        return 3;
    }

}
