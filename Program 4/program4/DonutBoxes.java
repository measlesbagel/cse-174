/*
Name: Myles Cagle
Date: 9/22/2019
Section: C
Description: Takes in number of donuts and
calculates the number of boxes required for
that amount

Test cases:
Everything worked correctly: 0-12000000
*/

import java.util.Scanner;

public class DonutBoxes {
  public static void main(String[] args) {
    //Initialize variables for program
    Scanner keys = new Scanner(System.in);
    int donuts;
    double boxes;

    //Find out number of donuts
    System.out.print("How many donuts? ");
    donuts = keys.nextInt();
    //Calculate the amount of boxes required
    boxes = (int)(donuts/12.0 + 0.99);

    //Output the amount of boxes needed
    System.out.printf("You will need %.0f box(es) for the donuts",boxes);

    keys.close();
  }
}
