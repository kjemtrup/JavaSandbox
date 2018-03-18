package CircleOverlap;

public class Circle {

    // Fields
    public double[] Center;
    public double radius;

    public Circle(double[] center, double radius) {
        Center = center;
        this.radius = radius;
    }


    // Getters, x, y, and radius
    public double getX() {
        return this.Center[0];
    }

    public double getY() {
        return this.Center[1];
    }

    public double getradius() {
        return this.radius;
    }

    // Circle contains point?
    public boolean contains(double[] Punkt) {
        if (Math.sqrt(Math.pow(this.getX() - Punkt[0], 2) + Math.pow(this.getY() - Punkt[1], 2)) <= this.getradius
                ()) {
            return true;
        } else return false;
    }

    // Circle overlaps with other circle?
    public boolean overlaps(Circle cirkel2) {

        if (Math.sqrt(Math.pow(this.getX() - cirkel2.getX(), 2) + Math.pow(this.getY() - cirkel2.getY(), 2)) <= this
                .getradius() + cirkel2.getradius()) {

            return true;
        } else return false;
    }
}

