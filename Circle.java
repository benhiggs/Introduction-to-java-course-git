/**
 * Created by Ben on 29/01/2015.
 */
import java.lang.Math;

public class Circle {
    private static double radius;
    private static int count;

    public static double getRadius() {return radius;}
    public static int getCount() {return count;}
    public static void setRadius(double radius) {Circle.radius = radius;}
    public static void setCount(int count) {Circle.count = count;}

    public Circle(double r){
        setRadius(r);
        int c=getCount();
        c++;
        setCount(c);
    }
    public static double circumference (){
        double rad=getRadius();
        return (2*Math.PI*rad);
    }
    public static double area() {
        double rad=getRadius();
        return (Math.PI * Math.pow(rad, 2.0));
    }
    public static void report (){
        double rad=getRadius();
        System.out.printf("%s %6.3f %s %7.3f %s %9.4f %n","Radius ",rad," Circumference ",circumference()," Area ",area());
    }
    public static void main(String[] args) {
        System.out.println(count + " circles have been created.");
        for (int r=1; r<=10 ; r++) new Circle(r).report();
        System.out.println(count + " circles have been created.");
    }


}
