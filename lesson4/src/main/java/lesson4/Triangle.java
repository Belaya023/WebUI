package lesson4;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public boolean isTriangle() {
        return ((a + b > c) && (b + c > a) && (c + a > b));
    }

    public static double getSquare(double a, double b, double c) {
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public static void main(String[] args) {
        System.out.println("Площадь треугольника = " + getSquare(14,12,12));
        //System.out.println();
    }

}
