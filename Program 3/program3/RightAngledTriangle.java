/*
Name: Myles Cagle
Date: 9/9/2019
Section: C
Description: Calculates coordinates,
side lengths, angles, area, perimeter,
and centroid coordinate of a right angled
triangle given the coordinates of points a
and b (in a triangle abc)
*/

import java.util.Scanner;

public class RightAngledTriangle {

  public static void main(String[] args) {
    //Initialize all variables and scanner
    double ax,ay,bx,by;
    String name;
    Scanner keys = new Scanner(System.in);

    //Asks user for triangle name and assigns given name to triangle
    System.out.print("Enter three letter name of the triangle: ");
    name = keys.nextLine();

    //Asks user for coordinates of two points of triangle and assigns to given points
    System.out.printf("\n Enter the coordinate of %s%n: ", name.charAt(0));
    ax = keys.nextDouble();
    ay = keys.nextDouble();
    System.out.printf("\n Enter the coordinate of %s%n: ", name.charAt(1));
    bx = keys.nextDouble();
    by = keys.nextDouble();

    System.out.printf("##### Right Triangle Calculation for the %s Triangle #####%n", name);

    //Prints out coordinates in relation to triangle points
    System.out.printf("** The coordinates of the triangle are: **%n");
    System.out.printf("%S : (%.3f, %.3f)%n", name.charAt(0),ax,ay);
    System.out.printf("%S : (%.3f, %.3f)%n", name.charAt(1),bx,by);
    System.out.printf("%S : (%.3f, %.3f)%n", name.charAt(2),bx,ay);

    //Calculates triangle sides (x1-x2, y1-y2, hypotenuse) and assigns them to given side
    System.out.printf("** The side lengths are: **%n");
    System.out.printf("Side %s: %.3f units%n",name.charAt(0), Math.abs(ay-by));
    System.out.printf("Side %s: %.3f units%n",name.charAt(1), Math.abs(ax-bx));
    System.out.printf("Side %s: %.3f units%n",name.charAt(2),
                      Math.abs(Math.hypot(Math.abs(ay-by),Math.abs(ax-bx))));

    //Calculates angles given angle C is 90 degrees using basic trigonometry
    System.out.printf("** The angles are: **%n");
    System.out.printf("Angle %S: %.3f degrees%n",name.charAt(0),
                      Math.toDegrees(Math.asin(Math.abs(ay-by)/Math.abs
                                                 (Math.hypot(Math.abs(ay-by),Math.abs(ax-bx))))));
    System.out.printf("Angle %S: %.3f degrees%n",name.charAt(1),
                      90 - Math.toDegrees(Math.asin(Math.abs(ay-by)/Math.abs
                                                      (Math.hypot(Math.abs(ay-by),Math.abs(ax-bx))))));
    System.out.printf("Angle %S: %.3f degrees%n",name.charAt(2), 90.000);

    System.out.printf("** The area and perimeter are: **%n");
    //Calculates area as 1/2(base * height)
    System.out.printf("Area = %.3f sq. units%n", 0.5*(Math.abs(ay-by)*Math.abs(ax-bx)));
    //Calculates perimeter as total of all side lengths from previous calculation
    System.out.printf("Perimeter = %.3f units%n",
                      Math.abs(ay-by)+Math.abs(ax-bx)+Math.hypot(Math.abs(ay-by),Math.abs(ax-bx)));

    //Calculates centroid coordinate as 1/3 of (ax,bx,cx) and (ay,by,cy)
    System.out.printf("** The centroid coordinate: **%n");
    System.out.printf("O : (%.3f, %.3f)%n", (1.0/3.0)*(ax+2*bx), (1.0/3.0)*(2*ay+by));

  }
}
