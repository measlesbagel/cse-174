/*
Name: Myles Cagle
Date: 11/10/2019
Section: C
Description: Creates a program that makes an
array of lockers for each person that the user
inputs. Asks the user if they want to see each
stage of the program or just the final output.
Runs an algorithm that flips that state of the
locker based on the modulus of the person
(numerically).
*/

import java.util.Scanner;

public class Program11 {

  //Global Keyboard Scanner for inputs
  static Scanner keys = new Scanner(System.in);

  //Starts menu to run rest of program
  public static void main(String[] args) {
    menu();
  }

  //Gets the number of lockers to create
  public static int numLockers() {
    boolean loop = true;
    int num = 0;
    //Loops while users input is not valid
    while(loop == true) {
      System.out.print("Number of lockers: ");
      num = keys.nextInt();
      if(num <= 2) System.out.println("Invalid input!");
      else loop = false;
    }

    return num;
  }

  //Gets Y/N decision to show stages and returns boolean choice
  public static boolean showStages() {
    boolean loop = true;
    String choice = " ";
    //Loops while users input is not valid
    while(loop == true) {
      System.out.print("Show stages [Y/N]: ");
      choice = keys.next();
      if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) loop = false;
      else System.out.println("Invalid input!");
    }

    return checkDecision(choice);
  }

  //Checks if user wants to continue using program
  public static boolean keepGoing() {
    boolean loop = true;
    String choice = " ";
    //Loops if users input is not valid
    while(loop == true) {
      System.out.print("\nDo you want to continue [Y/N]: ");
      choice = keys.next();
      if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) loop = false;
      else System.out.println("Invalid input!");
    }

    return checkDecision(choice);
  }

  //Takes a Y/N and converts it into a boolean choice
  public static boolean checkDecision(String choice) {
    boolean check;
    if(choice.equalsIgnoreCase("y")) return true;
    else return false;
  }

  //Creates the first array of lockers
  public static boolean[] createLockers(int size) {
    boolean[] lockers = new boolean[size];
    for(int i = 0; i < size; i++) {
      lockers[i] = false;
    }

    return lockers;
  }

  //Flips lockers status if it meets requirements, returns modified array
  public static boolean[] flip(boolean[] lockers, int mod) {
    for(int i = 0; i < lockers.length; i++) {
      if(lockers[i] == true &&  (i+1)%mod == 0) lockers[i] = false;
      else if(lockers[i] == false && (i+1)%mod == 0) lockers[i] = true;
    }
    return lockers;
  }

  //Runs locker array through algorithm of flipping based on modulus of persons number
  public static void runLockers(boolean[] lockers, boolean showStages, int people) {
    for(int i = 1; i <= people; i++) {
      lockers = flip(lockers, i);
      //Outputs status after each person if showStages = true
      if(showStages == true) {
        for(boolean x : lockers) {
          if(x == true) System.out.print("O");
          else System.out.print("-");
        }
        countLockers(lockers);
        System.out.println();
      }
    }
    indexLockers(lockers);
  }

  //Counts open and closed lockers in the array
  public static void countLockers(boolean[] lockers) {
    int countOpen = 0, countClose = 0;
    for(boolean i : lockers) {
      if(i == true) countOpen++;
      if(i == false) countClose++;
    }
    System.out.printf("     Open: %-3d Closed: %d",countOpen, countClose);
  }

  //Outputs the index position of open lockers
  public static void indexLockers(boolean[] lockers) {
    System.out.print("Open: ");
    for(int i = 0; i < lockers.length; i++) {
      if(lockers[i] == true) System.out.print((i+1) + " ");
    }
  }

  //Creates menu to input users choices into the program
  public static void menu() {
    int numLockers;
    boolean showStages, keepGoing = true;
    //Loops program while user wants to keep going
    while(keepGoing == true) {
      numLockers = numLockers();
      showStages = showStages();
      boolean[] lockers = createLockers(numLockers);
      runLockers(lockers, showStages, numLockers);
      keepGoing = keepGoing();
    }
    System.out.println("End");
  }
}
