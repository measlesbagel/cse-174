/*
Name: Myles Cagle
Date: 10/6/2019
Section: C
Description: Prints out a box made up
of any 3 user specified characters
*/

import java.util.Scanner;

public class Boxes {
  public static void main(String[] args) {
    //Initialize variables for program
    char x,y,z;
    String check;
    Scanner keys = new Scanner(System.in);

    //Gets character choices for boxes from user
    System.out.print("Enter the characters to be displayed in the boxes" );
    check = keys.next();

    //Makes sure user only entered 3 characters, if correct outputs boxes
      if(check.length() != 3) {
      System.out.println("Invalid Input!");
    } else {
      x = check.charAt(0);
      y = check.charAt(1);
      z = check.charAt(2);
      draw(x);
      draw(y);
      draw(z);
    }
    keys.close();
  }

  //Creates box given the character to make it out of
  public static void draw(char a) {
    System.out.printf("%c %c %c %c %c%n",a,a,a,a,a);
    System.out.printf("%c       %c%n",a,a);
    System.out.printf("%c       %c%n",a,a);
    System.out.printf("%c       %c%n",a,a);
    System.out.printf("%c %c %c %c %c%n%n",a,a,a,a,a);

  }
}
