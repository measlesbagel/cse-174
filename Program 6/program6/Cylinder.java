/*
Name: Myles Cagle
Date: 10/6/2019
Section: C
Description: Calculates the area of a circle,
surface area of a cylinder, or the volume
of a cylinder given the radius and/or height
*/

import java.util.Scanner;

public class Cylinder {
  public static void main(String[] args) {
    //Initialize variables for program
    Scanner keys = new Scanner(System.in);
    String decision;
    double radius,height;

    //Outputs menu of options
    System.out.println("-- Menu --");
    System.out.println("a) Area of a circle");
    System.out.println("b) Area of the surface of a cyclinder");
    System.out.println("c) Volume of a cylinder");
    System.out.print("Enter your choice: ");

    //takes users choice
    decision = keys.next().toLowerCase();

    //Outputs correct calculations given users menu choice
    switch (decision) {
      case "a":
        System.out.print("Enter the radius: ");
        radius = keys.nextDouble();
        System.out.printf("%nThe area of the circle is %.3f",circArea(radius));
        break;
      case "b":
        System.out.print("Enter the radius: ");
        radius = keys.nextDouble();
        System.out.print("\nEnter the height: ");
        height = keys.nextDouble();
        System.out.printf("%nThe area of the surface of a cylinder is %.3f",cylArea(radius,height));
        break;
      case "c":
        System.out.print("Enter the radius: ");
        radius = keys.nextDouble();
        System.out.print("\nEnter the height: ");
        height = keys.nextDouble();
        System.out.printf("%nThe volume of the cylinder is %.3f",cylVolume(radius,height));
        break;

      //If users choice isnt in menu, tells user, ends program
      default:
        System.out.println("The selection is not correct. Program terminated.");
    }

    keys.close();
  }

  //Calculates area of a circle given radius, returns as double
  public static double circArea(double radius) {
    double area = Math.PI*Math.pow(radius,2);
    return area;
  }

  //Calculates surface area of a cylinder given radius and height, returns as double
  public static double cylArea(double radius, double height) {
    double surface = 2*circArea(radius)+(Math.PI*(2*radius)*height);
    return surface;
  }

  //Calculates volume of a cylinder given radius and height, returns as double
  public static double cylVolume(double radius, double height) {
    double volume = circArea(radius)*height;
    return volume;
  }
}
