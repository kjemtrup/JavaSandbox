package Shapes;

public class Demonstration {

    public static void main(String[] args) {

            Triangle Pyt = new Triangle(3, new double[]{4,5,6}, new double[]{10,20,30});

        System.out.println(Pyt.getArea());
        System.out.println(Pyt.getCircumference());
        System.out.println(Pyt.getNumEdges());
        }
}
