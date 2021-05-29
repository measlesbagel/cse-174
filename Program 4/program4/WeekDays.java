/*
Name: Myles Cagle
Date: 9/22/2019
Section: C
Description: Outputs the day of the week given 
the number its related to
*/


import java.util.Scanner;

public class WeekDays {
  
  public static void main(String[] args) {
    //Initialize variables for program
    int choice;
    Scanner keys = new Scanner(System.in);
    String days = "Sunday   Monday   Tuesday  WednesdayThursday Friday   Saturday ";

    //Ask user to choose number
    System.out.print("Enter a number (0-6)");
    choice = keys.nextInt();
    //Shows user which day of the week that number is related to
    System.out.printf("%n** %d is %s **",choice,days.substring((choice%7)*9,(choice%7)*9+9).trim());

    keys.close();
  }
}
