/*
Name: Myles Cagle
Date: 10/6/2019
Section: C
Description: Outputs the temperature in
celsius and fahrenheit given a depth into
earth in kilometers
*/

import java.util.Scanner;

public class EarthTemp {
  public static void main(String[] args) {
    //Initialize variables for program
    Scanner keys = new Scanner(System.in);
    double depth;

    //Gets depth from user
    System.out.print("Enter the depth in kilometers: ");
    depth = keys.nextDouble();

    //Outputs calculations with labels
    System.out.printf("%nThe celsius temperature at depth %.2f km is %.2f.",
                      depth,getCelsiusAtDepth(depth));
    System.out.printf("%nThe fahrenheit temperature at depth %.2f is %.2f.",
                      depth,convertCelsiusToFahrenheit(getCelsiusAtDepth(depth)));

    keys.close();
  }

  //Calculates temperature in celsius given depth into earth in kilometers
  public static double getCelsiusAtDepth(double km) {
    double celsius = 10*km+20;
    return celsius;
  }

  //Calculates temperature in fahrenheit given temperature in celsius
  public static double convertCelsiusToFahrenheit(double temp) {
    double fahrenheit = 1.8*temp+32;
    return fahrenheit;
  }
}
